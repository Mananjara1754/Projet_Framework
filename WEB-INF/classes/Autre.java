package autre;
import note.*;
public class Autre {
    String prenom;
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Autre(String prenom) {
        this.prenom = prenom;
    }
    @Fonction(nomMethod = "all_autre")
    public void getAll() {
        System.out.println("voici les autres");
    }
}
