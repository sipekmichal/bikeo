<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<c:forEach items="${videos}" var="video">
	<li class="span3">
		<div class="thumbnail">
			<span>.</span> <img
				src="${pageContext.request.contextPath}/image/${video.id}.jpg"
				alt="${video.title}">
			</td>
			<div class="caption">
				<h3>${video.title}</h3>
			</div>
		</div>
	</li>
</c:forEach>