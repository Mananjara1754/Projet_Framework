package etu1754.framework.servlet;
import utils.Utilitaire;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class FrontServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        Utilitaire use = new Utilitaire();
        String[] composant = use.getData(req.getRequestURL().toString());
        for (int i = 0; i < composant.length; i++) {
            out.print(composant[i]);
        }
        String action = req.getParameter("action");
        if(action.compareToIgnoreCase("somme")==0){
            out.print("somme");
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        processRequest(req, res);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        processRequest(req, res);
    }
}
