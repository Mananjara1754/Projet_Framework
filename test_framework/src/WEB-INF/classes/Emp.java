package employee;
import java.util.List;

import javax.management.modelmbean.ModelMBean;

import java.util.ArrayList;
import modelview.*;
import note.Fonction;
import note.Parametre;
import note.Auth;
import fileUpload.FileUpload;
import java.util.HashMap;
import note.Singleton;
import note.RestAPI;



@Singleton()
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
    @Fonction(nomMethod = "test_restAPI")
    @Auth(profil = "admin")
    @RestAPI()
    public Emp[] employe() {
        Emp[] tabEmp = new Emp[5];
        tabEmp[0]  = new Emp("Jean");
        tabEmp[1]  = new Emp("Jean1");
        tabEmp[2]  = new Emp("Jean2");
        tabEmp[3]  = new Emp("Jean3");
        tabEmp[4]  = new Emp("Jean4");
        return tabEmp;
    }
    @Fonction(nomMethod = "all_emp")
    @Auth(profil = "admin")
    public ModelView getAll() {
        HashMap<String,Object> data = new HashMap<String,Object>();
        ModelView mv = new ModelView("redirect.jsp",data);
        List<Emp> e =  new ArrayList<Emp>();
        e.add(new Emp("Jean"));
        e.add(new Emp("Soa"));
        mv.addItem("all_emp",e);
        System.out.println("all emploue");
        mv.setJson(true);

        List<String> lst =  new ArrayList<String>();
        lst.add("profil");
        lst.add("nom");
        mv.setInvalidateSession(true);
        mv.setRemoveSession(lst);
        System.out.println(mv.isInvalidateSession());
        return mv;
    }
    @Fonction(nomMethod = "login")
    public ModelView login(@Parametre(nomParametre = "Nom")String Nom , @Parametre(nomParametre = "Mdp")String Mdp){
        HashMap<String,Object> data = new HashMap<String,Object>();
        ModelView mv = new ModelView("result.jsp",data);
        mv.addSession("isConnected",true);
        mv.addSession("profil","admin");
        mv.addSession("nom",Nom);
        System.out.println("La voila : ");
        System.out.println(Mdp);
        System.out.println("Login ehh"+Nom+Mdp);
        return mv;
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
    public Emp() {
    }
}
