<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projet API REST - Administrateur</title>
</head>
<body>
	<c:if test="${accesRefuse == null && contenuDejaAchete == null}">
		<p>Achat du cours : ${titre } Prix : ${prix} €</p>
		<c:if test="${erreurTransaction != null }">
			<p style="color: red;">Erreur dans les informations bancaire
				entrées.</p>
		</c:if>
		<form method="post" action="./valide">
			<p>Numéro de carte bancaire :</p>
			<input type="text" name="numeroCarte" />
			<p>Date d'expiration :</p>
			<input type="text" name='dateExpiration' />
			<p>Code :</p>
			<input type="password" name="codeCarte" /> <input type="submit"
				value="Valider l'achat" />
		</form>
	</c:if>
	<c:if test="${accesRefuse != null }">
		<h2>Accès refusé. Vous n'avez pas accès à cette page !</h2>
	</c:if>
	<c:if test="${contenuDejaAchete != null }">
		<h2>Vous possédez déjà ce cours !</h2>
	</c:if>
</body>
</html>