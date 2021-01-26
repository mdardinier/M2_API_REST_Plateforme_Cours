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
	<h2>Liste des cours :</h2>
	<c:if test="${accesRefuse == null}">
		<table>
			<c:forEach items="${cours}" var="c">
				<tr>
					<td style="width: 25%;"><h3>${c.titre}</h3></td>
					<td style="width: 60%;">Description : ${c.description}</td>
					<td style="width: 8%;">Prix : ${c.prix} €</td>
					<td><a href='${c.getLinks().getLink("self").get().getHref()}'>Voir
							le cours</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${accesRefuse != null}">
		<p>Accès refusé, vous devez être connecté.</p>
	</c:if>
</body>
</html>