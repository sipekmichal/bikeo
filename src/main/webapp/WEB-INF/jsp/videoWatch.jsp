<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>
<h1>${video.title}</h1>
<br>
<p>${video.content}</p>
<center>
	<iframe width="854px" height="480px" allowfullscreen="allowfullscreen"
		mozallowfullscreen="mozallowfullscreen"
		msallowfullscreen="msallowfullscreen"
		oallowfullscreen="oallowfullscreen"
		webkitallowfullscreen="webkitallowfullscreen"
		src="https://www.youtube.com/embed/${video.yid}">
	</iframe>
</center>
</html>
