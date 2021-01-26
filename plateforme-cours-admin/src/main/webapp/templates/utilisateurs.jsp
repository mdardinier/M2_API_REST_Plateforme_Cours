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
<table>
<c:forEach items="${utilisateurs}" var="utilisateur">
<tr> 
	<td><h3>Utilisateur numéro ${utilisateur.id} : </h3></td>
	<td>Nom :  ${utilisateur.nom}</td>
	<td>Prénom : ${utilisateur.prenom}</td>
	<td>Email : ${utilisateur.getEmail()}</td>
	<td><a href="${utilisateur.getLinks().getLink("self").get().getHref()}">Voir l'utilisateur</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>