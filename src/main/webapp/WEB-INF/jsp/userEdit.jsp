<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglibs.jsp"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<strong>Úprava uživatele</strong>
	</div>
	<div class="panel-body">
		<form:form commandName="user"
			cssClass="form-horizontal  registrationForm">
			<div class="form-group">
				<form:hidden path="id" class="form-control input-sm" />
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Jméno</label>
				<div class="col-sm-10">
					<form:input path="name" cssClass="form-control" />
					<form:errors path="name" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" cssClass="form-control" />
					<form:errors path="email" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Heslo</label>
				<div class="col-sm-10">
					<form:password path="passwd" cssClass="form-control" />
					<form:errors path="passwd" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">Heslo
					znovu</label>
				<div class="col-sm-10">
					<input type="password" name="password_again" id="password_again"
						class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="role" class="col-sm-2 control-label">Role</label>
				<div class="col-sm-10">
					<form:select path="roles" items="${roles}" itemLabel="name"
						itemValue="id" multiple="true" cssClass="form-control" />
					<form:errors path="roles" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<input type="submit" value="Upravit"
						class="btn btn-lg btn-success pull-right">
				</div>
			</div>
		</form:form>
	</div>
</div>