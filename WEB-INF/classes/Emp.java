package employee;

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
    public void getAll() {
        System.out.println("Voici les Employes");
    }
}
