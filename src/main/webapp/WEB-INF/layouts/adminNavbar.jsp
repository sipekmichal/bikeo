<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="navbar-header">
	<button type="button" class="navbar-toggle" data-toggle="collapse"
		data-target=".navbar-collapse">
		<span class="sr-only">Toggle Nav</span> <span class="icon-bar"></span>
		<span class="icon-bar"></span> <span class="icon-bar"></span>
	</button>
	<a class="navbar-brand" href="<spring:url value="/"></spring:url>">bikeo.cz</a>
</div>
<div class="navbar-collapse collapse">
	<ul class="nav navbar-nav">
		<li class="active"><a href="<spring:url value=""></spring:url>">Administrace</a></li>
		<li><a
			href="<spring:url value="/pridat-video.html"></spring:url>"><span
				class="glyphicon glyphicon-plus"></span></a></li>
		<li><a href='<spring:url value="/logout"></spring:url>'>Odhlásit
				se</a></li>
	</ul>
	<form class="navbar-form navbar-right" method="get" action="#"
		role="form">
		<div class="form-group">
			<input type="text" placeholder="Vyhledávání..." name="s"
				class="form-control">
		</div>
	</form>
</div>
<!--/.nav-collapse -->