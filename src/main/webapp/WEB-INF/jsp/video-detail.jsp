<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="col-sm-9 col-md-9">
	<form:input path="video.title" cssClass="form-control" />
	<br>
	<form:textarea path="video.content" cssClass="form-control" rows="5" />
	<br>
	<iframe width="100%" height="360" src="${video.url}" frameborder="0" allowfullscreen></iframe>
</div>

<div class="col-sm-3 col-md-3">
	<div class="panel panel-default">
		<div class="panel-heading">Více</div>
		<div class="panel-body">
			<span class="glyphicon glyphicon-tags"></span>
			<c:forEach items="${video.categories}" var="category">
				${category.name}
			</c:forEach>
			<p class="blog-post-meta">
				<span class="glyphicon glyphicon-user"></span> ${video.user.name}<br>
				<span class="glyphicon glyphicon-calendar"></span>
				<fmt:formatDate value="${video.publishDate}"
					pattern="dd.MM.yyyy HH:mm" />
			</p>
		</div>
		<button type="button" class="btn btn-default">
			<span class="glyphicon glyphicon-pencil"></span>
		</button>
	</div>
	<input type="submit" formaction="" value="Uložit"
		class="btn btn-success btn-lg btn-block">
	<button type="button"
		onclick="location.href='<spring:url value="/admin/videa/odstranit?id=${video.id}"></spring:url>'"
		class="btn btn-default btn-lg btn-block">Odstranit</button>
</div>

<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script type="text/javascript">
	tinymce
			.init({
				selector : "textarea",
				theme : "modern",
				plugins : [
						"advlist autolink lists link image charmap print preview hr anchor pagebreak",
						"searchreplace wordcount visualblocks visualchars code fullscreen",
						"insertdatetime media nonbreaking save table contextmenu directionality",
						"emoticons template paste textcolor colorpicker textpattern" ],
				toolbar1 : "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
				toolbar2 : "print preview media | forecolor backcolor emoticons",
				image_advtab : true,
				templates : [ {
					title : 'Test template 1',
					content : 'Test 1'
				}, {
					title : 'Test template 2',
					content : 'Test 2'
				} ]
			});
</script>