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
	<c:if test="${session == null}">
	<p>Veuillez vous connecter ou vous inscrire.</p>
	<button onClick="window.location.href='connexion'">Se connecter</button>
	<button onClick="window.location.href='inscription'">S'inscrire</button>
	</c:if>
	<c:if test="${session != null}">
		<p>Vous êtes déjà connecté.</p>
	</c:if>
	<button onClick="window.location.href='cours'">Voir la liste des cours</button>
</body>
</html>