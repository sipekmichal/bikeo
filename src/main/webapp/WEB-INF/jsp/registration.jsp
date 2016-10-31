<%@ include file="../layouts/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form:form commandName="user"
	cssClass="form-horizontal registrationForm">
	<div class="form-group">
		<form:hidden path="id" class="form-control input-sm" />
	</div>
	<div class="form-group">
		<label for="url">Uživatelské jméno</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" />
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="email">E-mail</label>
		<div class="col-sm-10">
			<form:input path="email" id="email" type="text" name="email"
				cssClass="form-control" />
			<form:errors path="email" />
		</div>
	</div>
	<div class="form-group">
		<label for="title">Heslo</label>
		<div class="col-sm-10">
			<form:input path="passwd" id="passwd" type="password" name="passwd"
				cssClass="form-control" />
			<form:errors path="passwd" />
		</div>
	</div>
	<div class="form-group">
		<label for="content">Heslo znovu</label>
		<div class="col-sm-10">
			<form:input path="confirmPasswd" type="password" name="confirmPasswd"
				id="confirmPasswd" cssClass="form-control" />
			<form:errors path="confirmPasswd" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Registrovat" class="btn btn-primary">
			<input type="reset" value="Reset" class="btn btn-blue">
		</div>
	</div>
</form:form>




