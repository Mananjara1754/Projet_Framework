import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import note.Fonction;
import utils.Utilitaire;
public class Main {
    public static ArrayList<String> findAllFilesInFolder(File folder) {
		ArrayList<String> list= new ArrayList<>();
        for (File file : folder.listFiles()) {
			if (!file.isDirectory()) {
                String filen =  file.getName();
                String[] filename = filen.split(".class"); 
                for (int i = 0; i < filename.length; i++) {                  
                    list.add(filename[i]);  
                }
			} else {
				findAllFilesInFolder(file);
			}
		}
        return list;
	}   
    public static void main(String[] args) {
        try {
            String lien = "D:\\FIANARANA\\Logiciel\\apache-tomcat-9.0.64-windows-x64\\apache-tomcat-9.0.64\\webapps\\sprint3\\WEB-INF\\classes\\";
            String lien2 = "D:\\FIANARANA\\Logiciel\\apache-tomcat-9.0.64-windows-x64\\apache-tomcat-9.0.64\\webapps\\sprint3\\WEB-INF\\classes\\lala";
            String k = lien2.replace(lien, "");
            String rep = k.replace("/", "lo");
            System.out.println(rep);
            Utilitaire u = new Utilitaire();
            ArrayList<Class<?>> cl = new ArrayList<>(); 
            u.getAll_Classe(lien, cl,lien);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

 // String path = "elements";
            // File file = new File(path);          
            // ArrayList<String> list = findAllFilesInFolder(file);
            // ArrayList<Class<?>> cl = new ArrayList<>();  
            // for (int i = 0; i < list.size(); i++) {
            //     cl.add(Class.forName("elements."+list.get(i)));
            // }
            // for (int i = 0; i < cl.size(); i++) {
            //     System.out.println("Les Class sont : "+cl.get(i).getSimpleName());
            // }