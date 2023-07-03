
Les annotations : 

Annotation d'une fonction : @Fonction(nomMethod = "nom_du_methode")
Anotation d'une parametre d'une fonction : @Parametre(nomParametre="nom_du_parametre")
Annotation d'une classe si c'est Singleton(Une seule instance) : @Singleton()
Annotation d'une fonction si c'est une RestAPI : @RestAPI()

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

Importation : 

import modelview.*;
import note.Fonction;
import fileUpload.FileUpload;
import note.Parametre;
import note.Auth;
import note.RestAPI;

NB:

- les liens doivent correspondre au nom du fonction annotee 
- Et les fonctions doivent retourner un view 
- Dans une formulaire les noms des input doivent etre le meme
aux attributs d'une classe forme
- Il faut etre connetee si on veut specifier les autorisations a une foncction specifique