<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<a class="btn btn-navbar" data-toggle="collapse"
	data-target=".nav-collapse"><span class="icon-bar"></span><span
	class="icon-bar"></span> <span class="icon-bar"></span></a>
<a class="brand" href="/bikeo">bikeo.cz</a>
<form role="form"
	action='<spring:url value="j_spring_security_check"></spring:url>'
	method="POST">
	<div class="nav-collapse collapse">
		<ul class="nav">
			<li class="active"><a href="${pageContext.request.contextPath}">Videa</a></li>
			<li><a href="${pageContext.request.contextPath}/pridat-video">Přidat
					video</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">Kategorie <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<c:forEach items="${categories}" var="category">
						<c:if test="${category.enabled == true}">
							<li><a
								href="${pageContext.request.contextPath}/kategorie?id=${category.id}">${category.name}</a></li>
						</c:if>
					</c:forEach>
				</ul></li>
		</ul>
		<ul class="nav pull-right">
			<security:authorize access="isAnonymous()">
				<li><a id="example" rel="popover" data-html="true"
					data-placement="bottom"
					data-content='
							<input type="text" name="j_username" class="form-control"
							placeholder="E-mail" required autofocus> <input
							type="password" name="j_password" class="form-control"
							placeholder="Heslo" required>
							<button class="btn btn-blue btn-block" type="submit">Přihlásit se</button>
							<a href="register">Registrovat </a>
					'
					data-original-title="Přihlášení"><div class="fs1"
							aria-hidden="true" data-icon="&#xe041;"></div></a></li>
			</security:authorize>

			<security:authorize access="isAuthenticated()">
				<li><a class="dropdown-toggle" data-toggle="dropdown"><div
							class="fs1" aria-hidden="true" data-icon="&#xe04f;"></div>
						<ul class="dropdown-menu">
							<security:authorize ifAnyGranted="ROLE_ADMIN">
								<li><a href="${pageContext.request.contextPath}/admin">Administrace</a></li>
							</security:authorize>
							<li><a
								href="${pageContext.request.contextPath}/videa/pridat">Přidat
									video</a></li>
							<li><a href="#">Můj profil</a></li>
							<li class="divider"></li>
							<li><a href='<spring:url value="/logout"></spring:url>'>Odhlásit
									se</a></li>
						</ul></a></li>
			</security:authorize>
		</ul>
	</div>
</form>
