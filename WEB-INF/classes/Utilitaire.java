package utils;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Vector;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class Utilitaire {
    
    public String[] getData(String requete) {
        System.out.println(requete);
        String[] sans_slash = requete.split("/");
        Vector v = new Vector<>();
        int count = 0;
        for (int i = 4; i < sans_slash.length; i++) {
            v.add(sans_slash[i]);
        }
        Object[] value = v.toArray();
        String[] answer = new String[value.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = (String)value[i];
        }
        return answer;
    }

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
    public boolean verifDirectory(String path){
        try {
            File dir  = new File(path);
            File[] liste = dir.listFiles();
            int count = 0;
            for(File item : liste){
                if(item.isDirectory()){
                    count++;
                }
            }
            if (count==0) {
                return false;
            }
            if (count!=0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Class<?>> getAll_Classe(String lien , ArrayList<Class<?>> cl,String origine) {
        String path = "oulala";
        File file = null;
        ArrayList<String> list = null;
        try {
            File dir  = new File(lien);
            File[] liste = dir.listFiles();
            String k = "null";
            String fold = "null";
            for(File item : liste){
                if(item.isDirectory()){
                    System.out.format("Nom du répertoir: %s%n", item.getName()); 
                    path = lien+"\\"+item.getName();
                    file = new File(path); 
                    list = findAllFilesInFolder(file);
                    k = path.replace(origine, "");
                    fold = k.replace("\\", ".").substring(1);
                    for (int i = 0; i < list.size(); i++) {
                        //System.out.println("voila " + fold+"."+list.get(i));
                        cl.add(Class.forName(fold+"."+list.get(i)));
                    }
                    if (this.verifDirectory(path) == true) {
                        this.getAll_Classe(path,cl,origine);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cl;
    }
}

