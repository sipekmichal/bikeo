<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<h1>${video.title}</h1>
<br>
<center>
	<iframe width="870px" height="490px" allowfullscreen="allowfullscreen"
		mozallowfullscreen="mozallowfullscreen"
		msallowfullscreen="msallowfullscreen"
		oallowfullscreen="oallowfullscreen"
		webkitallowfullscreen="webkitallowfullscreen"
		src="https://www.youtube.com/embed/${video.yid}">
	</iframe>
</center>
<p>${video.content}</p>
<div>Zveřejněno: <b>${fn:substring(video.publishDate, 0, 10)}</b></div>