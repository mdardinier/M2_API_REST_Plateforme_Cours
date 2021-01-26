<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projet API REST - Administrateur</title>
</head>
<body>
	<c:if test="${refuse == null}">
		<h2>${nom}</h2>
		<p>Lien vidéo pour l'épisode : <a href="${lien}">${lien}</a></p>
	</c:if>
	<c:if test="${refuse != null }">
	<h2>Accès refusé. Vous n'avez pas accès à ce cours !</h2>
	</c:if>
</body>
</html>