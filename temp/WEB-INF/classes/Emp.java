package employee;
import java.util.List;
import java.util.ArrayList;
import modelview.*;
import note.Fonction;
import note.Parametre;

import java.util.HashMap;
public class Emp {
    String Nom;
    int Age;

    public String getNom() {
        return Nom;
    }
    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int Age) {
        this.Age = Age ;
    }
    public Emp(String Nom) {
        this.Nom = Nom;
    }
    @Fonction(nomMethod = "all_emp")
    public ModelView getAll() {
        HashMap<String,Object> data = new HashMap<String,Object>();
        ModelView mv = new ModelView("redirect.jsp",data);
        List<Emp> e =  new ArrayList<Emp>();
        e.add(new Emp("Jean"));
        e.add(new Emp("Soa"));
        mv.addItem("all_emp",e);
        System.out.println("all emploue");
        return mv;
    }
    // @Fonction(nomMethod = "index")
    // public ModelView index() {
    //     HashMap<String,Object> data = new HashMap<String,Object>();
    //     ModelView mv = new ModelView("index.jsp");
    //     System.out.println("index eh");
    //     return mv;
    // }
    public Emp() {
    }
    public Emp(String Nom, int Age) {
        this.Nom = Nom;
        this.Age = Age;
    }
    @Fonction(nomMethod = "save")
    public void save() {
        System.out.println("Voantso ilay fonction");
    }
    @Fonction(nomMethod = "getId")
    public void getId(@Parametre(nomParametre = "id")int id) {
        System.out.println("Okey mety be  "+String.valueOf(id));
    }
}
