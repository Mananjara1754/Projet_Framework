package employee;
import java.util.List;
import java.util.ArrayList;
import src.modelview.*;
import src.note.Fonction;
import java.util.HashMap;
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
        HashMap<String,Object> data = new HashMap<String,Object>();
        ModelView mv = new ModelView("redirect.jsp",data);
        List<Emp> e =  new ArrayList<Emp>();
        e.add(new Emp("Jean"));
        e.add(new Emp("Soa"));
        mv.addItem("all_emp",e);
        return mv;
    }
    public Emp() {
    }

    
}
