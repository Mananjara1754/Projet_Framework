
Les annotations : 
Annotation d'une fonction : @Fonction(nomMethod = "nom_du_methode")

Creation d'un view :
*Avec parametre 
	ModelView mv = new ModelView("nom_view.jsp",data);
*Sans parametre 
	ModelView mv = new ModelView("nom_view.jsp");

Web.xml :
<servlet>
      <servlet-name>test</servlet-name>
      <servlet-class>etu1754.framework.servlet.FrontServlet</servlet-class>
  </servlet>
<servlet-mapping>
        <servlet-name>test</servlet-name>
        <url-pattern>/</url-pattern>
</servlet-mapping>

importation : 
import modelview.*;
import note.Fonction;

NB:
- les liens doivent correspondre au nom du fonction annotee 
- Et les fonctions doivent retourner un view 
- Dans une formulaire les noms des input doivent etre le meme
aux attributs d'une classe formee