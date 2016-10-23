<%@ include file="../layouts/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<spring:url value="/register" var="userActionUrl" />
	<form:form method="post" action="${userActionUrl}"
		modelAttribute="userForm">
		<center>
			<table width="80%" cellpadding="5">
				<thead>
					<tr>
						<h3>Registrace</h3>
					</tr>
				</thead>
				<tbody>
					<form:hidden path="id" />
					<spring:bind path="name">
						<tr>
							<td>Uživatelské jméno</td>
							<td><form:input path="name" id="name" type="text"
									name="name" value="" /></td>
							<td style="color: #FF0000"><form:errors path="name" /></td>
						</tr>
					</spring:bind>
					<spring:bind path="email">
						<tr>
							<td>E-mail</td>
							<td><form:input path="email" id="email" type="text"
									name="email" value="" /></td>
							<td style="color: #FF0000"><form:errors path="email" /></td>
						</tr>
					</spring:bind>
					<spring:bind path="passwd">
						<tr>
							<td>Heslo</td>
							<td><form:input path="passwd" id="passwd" type="password"
									name="passwd" value="" /></td>
							<td style="color: #FF0000"><form:errors path="passwd" /></td>
						</tr>
					</spring:bind>
					<spring:bind path="confirmPasswd">
						<tr>
							<td>Heslo znovu</td>
							<td><form:input path="confirmPasswd" type="password"
									name="confirmPasswd" id="confirmPasswd" value="" /></td>
							<td style="color: #FF0000"><form:errors path="confirmPasswd" /></td>
						</tr>
					</spring:bind>
					<tr>
						<td></td>
						<td><input type="submit" value="Registrovat"
							class="btn btn-blue" style="font-weight: bold;" /> <input
							type="reset" value="Reset" class="btn btn-blue" /></td>
					</tr>
					<tr>
						<td colspan="2">Již registrován? <a href="#">Přihlaš se</a></td>
					</tr>
				</tbody>
			</table>
		</center>
	</form:form>
</body>

</html>