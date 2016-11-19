<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="row">
	<div class="col-sm-4">
		<h1>
			<strong>${category.name}</strong>
		</h1>
		<!-- Button trigger modal -->
		<button class="btn btn-danger btn-xs" data-toggle="modal"
			data-target="#removeModal">
			<span class="glyphicon glyphicon-trash"></span> Odstranit kategorii
		</button>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="removeModal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Zavřít</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<strong>Odstranit kategorii</strong>
				</h4>
			</div>
			<div class="modal-body">Opravdu chcete tuto kategorii
				odstranit?</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Storno</button>
				<a
					href="<spring:url value="/admin/kategorie/odstranit?id=${category.id}" />"
					class="btn btn-danger">Odstranit kategorii</a>
			</div>
		</div>
	</div>
</div>