<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglibs.jsp"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<strong>Úprava kategorie</strong>
	</div>
	<div class="panel-body">
		<form:form commandName="categoryEdit"
			cssClass="form-horizontal registrationForm">
			<div class="form-group">
				<form:hidden path="id" class="form-control input-sm" />
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">Název</label>
				<div class="col-sm-6">
					<form:input path="name" cssClass="form-control" />
					<form:errors path="name" />
				</div>
				<div class="form-group">
					<form:hidden path="enabled" class="form-control input-sm" />
				</div>
				<div class="col-sm-2">
					<input type="submit" value="Upravit"
						class="btn btn-primary pull-right">
				</div>
			</div>
		</form:form>
	</div>
</div>