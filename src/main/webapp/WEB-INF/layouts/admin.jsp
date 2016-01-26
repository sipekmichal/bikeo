<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<tilesx:useAttribute name="current" />

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.0/jquery.validate.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="pageTitle"></tiles:getAsString></title>
</head>

<div class="navbar navbar-default" role="navigation">
	<div class="container">
		<tiles:insertAttribute name="adminNavbar" />
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-3 col-md-2">
			<div class="list-group">
				<a href='<spring:url value="/admin/dashboard.html"></spring:url>'
					class="list-group-item ${current == 'dashboard'?'active':'' }"><span
					class="glyphicon glyphicon-dashboard"></span> Rychlý přehled</a> <a
					href='<spring:url value=""></spring:url>'
					class="list-group-item ${current == 'articles'?'active':'' }"><span
					class="glyphicon glyphicon-file"></span> Videa</a> <a
					href='<spring:url value=""></spring:url>'
					class="list-group-item ${current == 'categories'?'active':'' }"><span
					class="glyphicon glyphicon-th-list"></span> Kategorie</a>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<a href='<spring:url value=""></spring:url>'
						class="list-group-item ${current == 'users'?'active':'' }"><span
						class="glyphicon glyphicon-user"></span> Uživatelé</a>
				</security:authorize>
				<a href='<spring:url value=""></spring:url>'
					class="list-group-item ${current == 'settings'?'active':'' }"><span
					class="glyphicon glyphicon-cog"></span> Nastavení</a>
			</div>
		</div>
		<div class="col-sm-9 col-md-10">
			<tiles:insertAttribute name="bodyContent" />
		</div>
	</div>
</div>
<!-- end container -->
</html>


<!-- JavaScript for fading and sliding message alerts -->
<script type="text/javascript">
	$(document).ready(function() {

		window.setTimeout(function() {
			$(".alert").fadeTo(1500, 0).slideUp(500, function() {
				$(this).remove();
			});
		}, 3000);

	});
</script>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".registrationForm")
								.validate(
										{
											rules : {
												name : {
													required : true,
													minlength : 3,
													maxlength : 20
												},
												email : {
													required : true,
													email : true
												},
												password : {
													required : true,
													minlength : 3,
													maxlength : 20
												},
												password_again : {
													required : true,
													minlength : 3,
													maxlength : 20,
													equalTo : "#password"
												},
												title : {
													required : true,
													minlength : 3,
													maxlength : 250
												},
												content : {
													required : true,
													minlength : 3
												},
												categories : {
													required : true
												},
												users : {
													required : true
												},
												roles : {
													required : true
												},
												perex : {
													required : true,
													minlength : 3
												}
											},
											messages : {
												name : {
													required : "Pole nesmí být prázdné!",
													minlength : "Musíte zadat alespoň 3 znaky!",
													maxlength : "Je povoleno nejvýše 20 znaků!"
												},
												email : {
													required : "Pole nesmí být prázdné!",
													email : "Zadán špatný tvar emailu!"
												},
												password : {
													required : "Pole nesmí být prázdné!",
													minlength : "Musíte zadat alespoň 3 znaky!",
													maxlength : "Je povoleno nejvýše 20 znaků!",
												},
												password_again : {
													equalTo : "Heslo není stejné!",
													required : "Pole nesmí být prázdné!",
													minlength : "Musíte zadat alespoň 3 znaky!",
													maxlength : "Je povoleno nejvýše 20 znaků!"
												},
												title : {
													required : "Pole nesmí být prázdné!",
													minlength : "Musíte zadat alespoň 3 znaky!",
													maxlength : "Je povoleno nejvýše 250 znaků!"
												},
												content : {
													required : "Pole nesmí být prázdné!",
													minlength : "Musíte zadat alespoň 3 znaky!",
												},
												categories : {
													required : "Musíte označit alespoň jednu kategorii!",
												},
												users : {
													required : "Musíte označit alespoň jednoho uživatele!",
												},
												roles : {
													required : "Musíte přiřadit alespoň jednu roli!",
												},
												perex : {
													required : "Pole nesmí být prázdné!",
													minlength : "Musíte zadat alespoň 3 znaky!"
												}
											},

											highlight : function(element) {
												$(element).closest(
														'.form-group')
														.removeClass(
																'has-success')
														.addClass('has-error');
											},
											unhighlight : function(element) {
												$(element)
														.closest('.form-group')
														.removeClass(
																'has-error')
														.addClass('has-success');
											}
										});

					});
</script>
