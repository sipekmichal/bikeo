<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<ul class="thumbnails">
	<c:forEach items="${videos}" var="video">
		<c:if test="${video.confirmed == true}">
			<li class="span3">
				<div class="thumbnail">
					<a href="/bikeo/watch?v=${video.id}"> <img
						src="http://i.ytimg.com/vi/${video.yid}/hqdefault.jpg"
						alt="${video.title}">
						<div class="caption">
							<p>
								<strong>${fn:substring(video.title, 0, 30)}...</strong>
							</p>
						</div>
					</a>
				</div>
			</li>
		</c:if>
	</c:forEach>
</ul>