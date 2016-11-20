<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<html lang="en">
<head>
<meta charset="utf-8">
<title><tiles:getAsString name="pageTitle"></tiles:getAsString></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Include Stylesheets -->

<spring:url value="/resources/css/bootstrap.css" var="bootstrapCss" />
<spring:url value="/resources/css/app.css" var="appCss" />
<spring:url value="/resources/css/animate.css" var="animateCss" />
<spring:url value="/resources/css/style.css" var="styleCss" />
<spring:url value="/resources/css/prettyCheckable.css"
	var="prettyCheckableCss" />
<spring:url value="/resources/css/bootstrap-responsive.css"
	var="bootstrapResponsiveCss" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${appCss}" rel="stylesheet" />
<link href="${animateCss}" rel="stylesheet" />
<link href="${styleCss}" rel="stylesheet" />
<link href="${prettyCheckableCss}" rel="stylesheet" />
<link href="${bootstrapResponsiveCss}" rel="stylesheet" />

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<body>
	<!-- Start Header/Navbar  -->
	<div class="navbar navbar-static-top">
		<div class="navbar-inner">
			<div class="container">
				<tiles:insertAttribute name="navbar" />
			</div>
		</div>
	</div>
	<!-- End Header/Navbar  -->

	<!-- Start Main Content  -->
	<div class="container">
		<!-- Start Search Section  -->
		<div id="search-section">
			<div class="row">
				<div class="span12">
					<form action="" class="form-inline">
						<input type="text" class="span9 search-input" id="search"
							data-provide="typeahead"
							placeholder="Hledej dle klíčového slova..." data-items="4" />
						<button type="submit" class="btn btn-blue">Hledej</button>
					</form>
				</div>
			</div>
		</div>

		<!-- End Search Section  -->
		<div class="row">
			<div class="span8">
				<tiles:insertAttribute name="bodyContent" />
			</div>
			<div class="span4">
				<div class="sidebar-nav">
					<div class="base">
						<tiles:insertAttribute name="categoryMenu" />
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Start Footer -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="span6">
					<p>
						<strong>&copy; bikeo.cz</strong> - Travel Deals Theme - Crafted by
						Themestrap
					</p>
				</div>
				<div class="span6">
					<tiles:insertAttribute name="footer" />
				</div>
			</div>

		</div>

	</footer>
	<!-- End Footer -->



	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<spring:url value="/resources/js/main.js" var="mainJs" />

	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.6.2/modernizr.min.js"></script>
	<script
		src="http:////cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>

	<script src="${mainJs}"></script>


</body>
</html>