<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Test</title>
</head>
<body>
    <form action="save" method="get">
        Nom :
        <input type="text" name="Nom">
        <br><br>
        Age :
        <input type="number" name="Age" id=""><br><br>
        <input type="submit" value="Okey">
    </form>
    <a href="getId?id=5">Test du Lien (Sprint 8)</a>
    <hr>
    <h3>Upload fichier</h3>
    <form action="saveFile" method="POST" enctype="multipart/form-data">
        Nom : 
        <p><input type="text" name="Nom"></p>
        Photo de profil : 
        <p><input type="file" name="Pdp"></p>
        <input type="submit" value="Upload fichier">
    </form>
    <hr>
    <h3>Login</h3>
    <form action="login">
        <p><input type="text" name="Nom"></p>
        <p><input type="text" name="Mdp"></p>
        <p><input type="submit" value="Confirmer"></p>
    </form>
</body>
</html>


