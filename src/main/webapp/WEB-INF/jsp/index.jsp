<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<html lang="en">
<head>
<meta charset="utf-8">
<title>bikeo.cz</title>
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
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">bikeo.cz</a>
				<div class="nav-collapse collapse">
					<ul class="nav">
						<li class="active"><a href="#">Filmy</a></li>
						<li><a href="#about">Videa</a></li>
						<li><a href="#contact">Seriály</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Kategorie <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="404.htm">404 Page</a></li>
								<li><a href="signin.htm">Sign In Page</a></li>
								<li><a href="signup.htm">Sign Up Page</a></li>
							</ul></li>
					</ul>
					<ul class="nav pull-right">

						<li><a id="example" rel="popover" data-placement="bottom"
							data-content='Content Goes Here'
							data-original-title="User Settings"><div class="fs1"
									aria-hidden="true" data-icon="&#xe041;"></div></a></li>
						<li><a class="dropdown-toggle" data-toggle="dropdown"><div
									class="fs1" aria-hidden="true" data-icon="&#xe04f;"></div>
								<ul class="dropdown-menu">
									<li><a href="index.htm">Profile Settings </a></li>
									<li><a href="#">Account Settings</a></li>
									<li><a href="#">Privacy Controls</a></li>
									<li class="divider"></li>
									<li><a href="#">Log out</a></li>
								</ul></a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
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


		<!-- Start Left Sidebar  -->

		<div class="row">
			<div class="span3">
				<div class="sidebar-nav">
					<div class="base">
						<ul class="nav nav-list">
							<li class="nav-header">Kategorie</li>
							<li><a href="#">Cross Country</a></li>
							<li><a href="#">Downhill</a></li>
							<li><a href="#">Road cycling</a></li>
							<li><a href="#">Freestyle</a></li>
							<li><a href="#">BMX</a></li>
							<li class="divider"></li>
						</ul>

						<ul class="nav nav-list">
							<li class="nav-header">Filtr</li>
							<li><a href="#">Nejnovější</a></li>
							<li><a href="#">Nejlepší hodnocení</a></li>
							<li><a href="#">Nejvíce sledované</a></li>
							<li class="divider"></li>

							<li class="divider"></li>
							<div class="">
								<div id="other-colors" class="hide" style="display: block;">

								</div>
							</div>
						</ul>
					</div>
				</div>
			</div>

			<!-- End Left Sidebar  -->
			<!-- Start Right Section  -->

			<div class="span9">
				<ul class="thumbnails">
					<li class="span3">
						<div class="thumbnail">
							<span>kategorie</span> <img data-src="holder.js/300x200"
								alt="300x200" style="width: 300px; height: 200px;"
								src="img/h-3.jpg">
							<div class="caption">
								<h3>popisek</h3>
							</div>
						</div>
					</li>
				</ul>
				<p>
					<button type="submit" class="btn btn-large btn-block btn-blue"
						data-original-title="">Load More</button>
				</p>
			</div>
		</div>


		<!-- End Right Section  -->


	</div>
	<!-- End Main Content -->


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
					<ul class="footer-links">
						<li><a href="#">Filmy</a></li>
						<li class="muted">·</li>
						<li><a href="#">Videa</a></li>
						<li class="muted">·</li>
						<li><a href="#">Seriály</a></li>

						<li class="muted">·</li>
						<li><a href="#">Features</a></li>
						<li class="muted">·</li>

						<li><div class="btn-group">
								<button rel="tooltip" title="Follow us on Twitter"
									class="btn btn btn-small">
									<div class="fs1" aria-hidden="true" data-icon="&#xe0e6;"></div>
								</button>
								<button rel="tooltip" title="Like us on Facebook"
									class="btn btn btn-small">
									<div class="fs1" aria-hidden="true" data-icon="&#xe0e3;"></div>
								</button>
								<button rel="tooltip" title="Share us on Google+"
									class="btn btn-small">
									<div class="fs1" aria-hidden="true" data-icon="&#xe0df;"></div>
								</button>
							</div></li>
					</ul>
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