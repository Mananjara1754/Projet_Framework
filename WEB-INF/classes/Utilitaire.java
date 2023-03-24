package utils;

import java.util.Vector;

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
}