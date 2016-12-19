<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="videoWrapper">
	<iframe allowfullscreen="allowfullscreen"
		mozallowfullscreen="mozallowfullscreen"
		msallowfullscreen="msallowfullscreen"
		oallowfullscreen="oallowfullscreen"
		webkitallowfullscreen="webkitallowfullscreen"
		src="https://www.youtube.com/embed/${video.yid}">
	</iframe>
</div>
<div id="video-panel-section">
	<h3>
		<c:set var="videoTitle" value="${video.title}" />
		${fn:toUpperCase(videoTitle)}
	</h3>
	<p>
		Vložil: <a href="">${video.user.name}</a>
	</p>
	<hr>
	<h4 class="text-right">${video.views} zhlédnutí</h4>
</div>
<div id="video-panel-section">
	<strong>Publikováno <fmt:formatDate
			value="${video.publishDate}" pattern="dd.MM.yyyy" /></strong>
	<p>${video.content}</p>
</div>
<div id="video-panel-section">
	<a href="">TODO: Nahlásit nefunkční video</a>
</div>