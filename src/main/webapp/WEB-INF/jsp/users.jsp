<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglibs.jsp"%>

<!-- Message alerts -->
<c:if test="${param.success eq true}">
	<div class="alert alert-success">
		<a href="#" class="close" id="alert-message" data-dismiss="alert">&times;</a>
		<strong>Info: </strong> Uživatel byl úspěšně přidán.
	</div>
</c:if>
<c:if test="${param.remove eq true}">
	<div class="alert alert-success">
		<a href="#" class="close" id="alert-message" data-dismiss="alert">&times;</a>
		<strong>Info: </strong> Uživatel byl úspěšně odstraněn.
	</div>
</c:if>
<c:if test="${param.update eq true}">
	<div class="alert alert-success">
		<a href="#" class="close" id="alert-message" data-dismiss="alert">&times;</a>
		<strong>Info: </strong> Uživatel byl úspěšně aktualizován.
	</div>
</c:if>
<!-- End of message alerts -->


<div class="panel panel-default">
	<div class="panel-heading">
		<strong>Přidat uživatele</strong>
	</div>
	<div class="panel-body">
		<form:form commandName="user"
			cssClass="form-horizontal registrationForm">
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
					<form:input type="password" path="passwd" cssClass="form-control" />
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
				<label for="roles" class="col-sm-2 control-label">Role</label>
				<div class="col-sm-10">
					<form:select path="roles" items="${roles}" itemLabel="name"
						itemValue="id" multiple="true" cssClass="form-control" />
					<form:errors path="roles" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<input type="submit" value="Uložit"
						class="btn btn-lg btn-primary pull-right">
				</div>
			</div>
		</form:form>
	</div>
</div>


<div class="panel panel-default table-responsive">
	<table class="table table-hover table-striped">
		<thead>
			<tr>
				<th>Email</th>
				<th>Jméno</th>
				<th>Stav</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><a
						href='<spring:url value="/admin/uzivatele/detail.html?id=${user.id}"></spring:url>'>
							${user.email} </a></td>
					<td>${user.name}</td>
					<c:if test="${user.enabled == true}">
						<td><span class="label label-success">Aktivován</span></td>
					</c:if>
					<c:if test="${user.enabled == false}">
						<td><span class="label label-danger"> Deaktivován</span></td>
					</c:if>
					<td><a
						href="<spring:url value="/admin/uzivatele/upravit.html?id=${user.id}" />"
						class="btn btn-xs btn-default pull-right"><span
							class="glyphicon glyphicon-pencil"></span> Upravit </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>