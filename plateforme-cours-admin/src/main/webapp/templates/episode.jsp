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
		<p>Lien vid�o pour l'�pisode : <a href="${lien}">${lien}</a></p>
	</c:if>
	<c:if test="${refuse != null }">
	<h2>Acc�s refus�. Vous n'avez pas acc�s � ce cours !</h2>
	</c:if>
</body>
</html>