package employee;
import modelview.*;
import note.Fonction;

public class Emp {
    String nom;

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Emp(String nom) {
        this.nom = nom;
    }
    @Fonction(nomMethod = "all_emp")
    public ModelView getAll(int y) {
        return new ModelView("redirect.jsp");
    }
    public Emp() {
    
    }
    
}
