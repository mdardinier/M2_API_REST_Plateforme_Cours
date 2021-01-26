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
	<form method="post" action="connexion/check">
		<p>Email :</p>		
		<p><input type="email" name="email" />
		<c:if test="${erreur != null}">
		<p style="color:red;">Erreur : mauvaise adresse email.</p>
		</c:if>
		</p>
		<p>Mot de passe :</p>
		<input type="password" />
		<input type="submit" value="Se connecter" />
	</form>
</body>
</html>