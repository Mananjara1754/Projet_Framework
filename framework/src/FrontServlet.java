package etu1754.framework.servlet;
import utils.Utilitaire;
import java.io.*;
import javax.servlet.*;
import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import etu1754.framework.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import modelview.ModelView;
import note.Fonction;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URI;
public class FrontServlet extends HttpServlet {
    HashMap<String,Mapping> MappingUrls; 

    public void init()throws ServletException{
        ServletContext context = this.getServletContext();
        //...traitement
        Utilitaire use = new Utilitaire();
        Mapping mapping = null;
        String nom = "null";
        ArrayList<Class<?>> params = new ArrayList<>();
        try {
                //Avoir url
            ClassLoader loader = context.getClassLoader();
            URI uri = Objects.requireNonNull(loader.getResource("")).toURI();
            File f = new File(uri);
            String classPath = f.getPath();
            System.out.println(classPath); 
            System.out.println("voici le path");
            String lien = classPath;

            ArrayList<Class<?>> cl = use.getAll_Classe(lien,params,lien);
            HashMap<String,Mapping> huhu = new  HashMap<String,Mapping>();
            for (int i = 0; i < cl.size(); i++) {
                for (int j = 0; j < cl.get(i).getDeclaredMethods().length; j++) {
                    if (cl.get(i).getDeclaredMethods()[j].isAnnotationPresent(Fonction.class)){
                        Annotation fonction = cl.get(i).getDeclaredMethods()[j].getAnnotation(Fonction.class);
                            mapping = new Mapping(cl.get(i).getName(),cl.get(i).getDeclaredMethods()[j].getName());
                            nom = cl.get(i).getDeclaredMethods()[j].getAnnotation(Fonction.class).getClass().getMethod("nomMethod").invoke(fonction).toString();
                            huhu.put(nom,mapping);
                    }
                }   
            }
        this.MappingUrls = huhu;
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        Utilitaire use = new Utilitaire();
        String composant = use.getData(req.getRequestURL().toString());
       
        out.print(composant);
        try {
            use.verif(composant,this.MappingUrls);
            Mapping test = null;
            for (Map.Entry mapentry : this.MappingUrls.entrySet()) {
                out.print("\nLa cle est : "+mapentry.getKey());
                test = (Mapping)mapentry.getValue();
                out.print("\n"+"La Classe est :"+test.getClassName());
            }
            Class laclasse = Class.forName(test.getClassName());
            Object objet = laclasse.getConstructor().newInstance();
            Method[] function = laclasse.getDeclaredMethods();
            Method theMeth = null;

            for (int i = 0; i < function.length; i++) {
                if (function[i].getName().compareToIgnoreCase(test.getMethod()) == 0) {
                    theMeth = function[i];
                }
            }
            Object Objetview =  theMeth.invoke(objet,1);
            out.print("Tonga ato");
            ModelView view = (ModelView)Objetview;
            if (view.getData() != null) {
                for (Map.Entry mapentry : view.getData().entrySet()) {
                    req.setAttribute(mapentry.getKey().toString(),mapentry.getValue());
                }
            }
            RequestDispatcher dispat = req.getRequestDispatcher(view.getView()); 
            dispat.forward(req,res);

        } catch (Exception e) {
            e.printStackTrace();
            out.print(e.getMessage());
        }
        
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        processRequest(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        processRequest(req, res);
    }
}
