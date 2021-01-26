<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projet API REST - Administrateur</title>
</head>
<body>
	<p>Page de formulaire d'inscription</p>
	<form method="post" action="inscription/valide">
		<p>Nom :</p>
		<input type="text" name="nom"/>
		<p>Prénom :</p>
		<input type="text" name='prenom'/>
		<p>Email :</p>
		<input type="email" name="email"/>
		<input type="submit" value="S'inscrire"/>
	</form>
</body>
</html>