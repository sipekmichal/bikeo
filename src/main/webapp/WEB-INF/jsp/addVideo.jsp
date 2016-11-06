<%@ include file="../layouts/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:if test="${param.success eq true}">
	<div class="alert alert-success">Video bylo přidáno.</div>
</c:if>

<form:form commandName="video"
	cssClass="form-horizontal registrationForm" enctype="multipart/form-data">
	<div class="form-group">
		<form:hidden path="id" class="form-control input-sm" />
	</div>
	<div class="form-group">
		<label for="url" class="col-sm-2 control-label">URL</label>
		<div class="col-sm-10">
			<form:input path="url" cssClass="form-control" />
			<form:errors path="url" />
		</div>
	</div>
	<div class="form-group">
		<label for="categories" class="col-sm-2 control-label">Kategorie</label>
		<div class="col-sm-10">
			<form:select path="categories" items="${categories}" itemLabel="name"
				itemValue="id" multiple="true" cssClass="form-control" />
			<form:errors path="categories" />
		</div>
	</div>
	<div class="form-group">
		<label for="title" class="col-sm-2 control-label">Titulek</label>
		<div class="col-sm-10">
			<form:input path="title" cssClass="form-control" />
			<form:errors path="title" />
		</div>
	</div>
	<div class="form-group">
		<label for="content" class="col-sm-2 control-label">Popis</label>
		<div class="col-sm-10">
			<form:textarea path="content" cssClass="form-control" rows="3" />
			<form:errors path="content" />
		</div>
	</div>
	<div class="form-group">
		<label for="user" class="col-sm-2 control-label">Uživatel</label>
		<div class="col-sm-10">
			<form:select path="user.id" items="${users}" itemLabel="name"
				itemValue="id" cssClass="form-control" />
			<form:errors path="user.id" />
		</div>
	</div>

<!-- 
	<div class="form-group">
		<label for="user" class="col-sm-2 control-label">Obrázek</label>
		<div class="col-sm-10">
			<form:input type="file" name="image" id="image" path="image"/>
			<form:errors path="image" />
		</div>
	</div>
 -->
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Nahrát" class="btn btn-primary">
		</div>
	</div>
</form:form>


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
<!-- /.blog-post -->

