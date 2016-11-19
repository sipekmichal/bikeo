<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<ul class="nav nav-list">
	<li class="nav-header">Kategorie</li>
	<c:forEach items="${categories}" var="category">
		<c:if test="${category.enabled == true}">
			<li><a href="/bikeo/kategorie?id=${category.id}">${category.name}</a></li>
		</c:if>
	</c:forEach>
	<li class="divider"></li>
</ul>

<ul class="nav nav-list">
	<li class="nav-header">Filtr</li>
	<li><a href="#">Nejnovější</a></li>
	<li><a href="#">Nejlepší hodnocení</a></li>
	<li><a href="#">Nejvíce sledované</a></li>
	<li class="divider"></li>
</ul>