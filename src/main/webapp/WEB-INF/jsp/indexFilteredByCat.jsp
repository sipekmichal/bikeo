<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<ul class="thumbnails">
	<c:forEach items="${category.videos}" var="video">
		<li class="span3">
			<div class="thumbnail">
				<img src="http://i.ytimg.com/vi/${video.yid}/hqdefault.jpg"
					alt="${video.title}">

				<div class="caption">
					<h3>${video.title}</h3>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>