<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<c:forEach items="${videos}" var="video">
	<li class="span3">
 		<div class="thumbnail"> 
			<span>.</span> <img 
 				src="${pageContext.request.contextPath}/image/${video.id}.png"
				alt="${video.title}"> 

 			<div class="caption"> 
 				<h3>${video.title}</h3> 
 			</div> 
 		</div> 
 	</li>
</c:forEach> 

                    
<!-- <p>*asdasfsadf</p> -->

<%-- <c:forEach items="${videos}" var="video"> --%>
<!--                         <li class="span3"> -->
<!--                             <div class="thumbnail"> -->
<!--                                 <span>.</span> -->
<%--                                 <iframe width="500" height="300" src="${video.url}" --%>
<!--                                     frameborder="0" allowfullscreen> -->
<!--                                 <div class="caption"> -->
<%--                                     <h3>${video.title}</h3> --%>
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </li> -->
<!--                         </li> -->
<%--                     </c:forEach> --%>