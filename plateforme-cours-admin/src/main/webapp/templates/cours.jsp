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
	<h1>Titre du cours : ${titre}</h1>
	<div>
		<p>Description : ${description}</p>
		<div>
			<p>Prix : ${prix} €</p>
			<c:if test="${session != null }">
				<c:if test="${possede != null }">
					<b style="color: green;">Vous possédez ce cours.</b>
				</c:if>
				<c:if test="${possede == null }">
					<button onClick="window.location.pathname='/api/cours/${id}/achat'">Acheter
						le cours</button>
				</c:if>
			</c:if>
			<c:if test="${session == null }">
				<button onClick="window.location.pathname='/api/connexion'">Acheter
					le cours</button>
			</c:if>
		</div>
		<h2>Contenu du cours : </h2>
		<p>Nombre d'épisodes : ${episodes.size()}</p>
		<h3>Liste des épisodes :</h3>
		<table>
			<c:forEach items="${episodes}" var="e">
				<tr>
					<td><h4>${e.nom}:</h4></td>
					<c:if test="${possede != null }">
						<td><a href="${e.getLinks().getLink("self").get().getHref()}">Voir
								l'épisode</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>