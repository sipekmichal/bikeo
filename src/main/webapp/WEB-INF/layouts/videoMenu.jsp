<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="thumbnails">
	<c:forEach items="${videos}" var="video">
		<li class="span3">
				<a href="/bikeo/watch?v=${video.id}">
					<img src="http://i.ytimg.com/vi/${video.yid}/hqdefault.jpg"
						alt="${video.title}" width="60%" align="left">
				</a>
<%-- 				<strong>${fn:substring(video.title, 0, 30)}</strong> --%>
<%-- 				<p>${video.user.name}</p> --%>
<!-- 				<p><font size="1">890 zhlédnutí</font></p> -->
		</li>
	</c:forEach>
</div>

