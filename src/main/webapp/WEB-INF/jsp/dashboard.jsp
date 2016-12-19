<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="col-sm-12 col-md-12">
	<div class="col-sm-3 col-md-3">
		<div class="well well-lg">
			<p>Videa neschválená:</p>
			<a href="${pageContext.request.contextPath}/admin/videa/neschvalena"><h1>${countUnconfirmedVideos}</h1></a>
		</div>
	</div>
	<div class="col-sm-3 col-md-3">

		<div class="well well-lg">
			<p>Videí cekem:</p>
			<a href="${pageContext.request.contextPath}/admin/videa"><h1>${countEnabledVideos}</h1></a>
		</div>
	</div>
	<div class="col-sm-3 col-md-3">

		<div class="well well-lg">
			<p>Uživatelů celkem:</p>
			<h1>${countUsers}</h1>
		</div>
	</div>
	<div class="col-sm-3 col-md-3">

		<div class="well well-lg">
			<p>Kategorií celkem:</p>
			<h1>${countCategories}</h1>
		</div>
	</div>
</div>