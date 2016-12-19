<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<html>
<body>

	<div align='center'>
		<img src="<c:url value="/resources/img/bike.jpg" />" />
		<c:if test="${(not empty errCode) and (not empty errMsg)}">
			<h1>Chyba: ${errCode}</h1>
			<h2>${errMsg}</h2>
		</c:if>

		<c:if test="${(empty errCode) or (empty errMsg)}">
			<h1>Neznámá chyba serveru. Omlouváme se :-(</h1>
		</c:if>
		<a href="/bikeo">Vrátit se domů</a>
	</div>
</body>
</html>