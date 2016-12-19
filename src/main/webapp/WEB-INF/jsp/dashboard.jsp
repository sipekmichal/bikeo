<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-sm-12 col-md-12">
	<div class="col-sm-3 col-md-3">
		<div class="well well-lg">
			<p>Videa neschválená:</p>
			<h1>
				<a href="${pageContext.request.contextPath}/admin/videa/neschvalena">${countUnconfirmedVideos}</a>
			</h1>
		</div>
	</div>
	<div class="col-sm-3 col-md-3">

		<div class="well well-lg">
			<p>Videí cekem:</p>
			<h1>
				<a href="${pageContext.request.contextPath}/admin/videa">${countEnabledVideos}</a>
			</h1>
		</div>
	</div>
	<div class="col-sm-3 col-md-3">

		<div class="well well-lg">
			<p>Uživatelů celkem:</p>
			<h1>
				<a href="${pageContext.request.contextPath}/admin/uzivatele">${countUsers}</a>
			</h1>
		</div>
	</div>
	<div class="col-sm-3 col-md-3">

		<div class="well well-lg">
			<p>Kategorií celkem:</p>
			<h1>
				<a href="${pageContext.request.contextPath}/admin/kategorie">${countCategories}</a>
			</h1>
		</div>
	</div>
</div>