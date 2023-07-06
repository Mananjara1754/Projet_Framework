
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
import note.Singleton;

NB:

- les liens doivent correspondre au nom du fonction annotee 
- Et les fonctions doivent retourner un view 
- Dans une formulaire les noms des input doivent etre le meme
aux attributs d'une classe forme
- Si on veut sessioner on l'introduis la cle et la valeur du variable a sessione dans l'hashmap session de mv
<String,Objetc>
- Il faut etre connete et avoir l'autorisation si on veut appeler certaines fonctions
specifiques.
- Si une fonction retourne une view et si on veut en tant que json les donnees hashmap<String , Object> data 
du mv , on utilise isJson = true
- Si une fonction retourne une tableau d'objet et si l' on veut en json on doit l'annoter par RestAPI 
- Si on veut supprimer une session on fait invalidateSession du mv en true et si on veut specifier le session a 
supprime on mets dans le removeSession une list de String , les cles des sessions a supprime .
