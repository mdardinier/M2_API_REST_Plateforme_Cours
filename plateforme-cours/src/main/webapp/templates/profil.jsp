<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projet API REST - Utilisateur</title>
</head>
<body>
	<c:if test="${inscription != null }">
		<p>Bienvenue, ${nom} ${prenom}, votre inscription a bien été
			validé.</p>
		<p>
			Voici votre profil, pour parcourir la liste des cours existant
			cliquez ici :
			<button
				onClick="window.location.pathname='api/cours'">Liste
				des cours</button>
		</p>
	</c:if>
	<h2>Profil :</h2>
	<div>
		<p>Nom : ${nom}</p>
		<p>Prénom : ${prenom}</p>
		<p>Email : ${email}</p>
	</div>
	<div>
	<button onClick="window.location.pathname='api/bibliotheque'">Voir la bibliothèque de vos cours</button>
	</div>
</body>
</html>