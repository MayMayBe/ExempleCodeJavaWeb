<%@ include file="../include/importTags.jsp"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<spring:url var="localeFr" value="">
	<spring:param name="locale" value="fr" />
</spring:url>
<spring:url var="localeEn" value="">
	<spring:param name="locale" value="en" />
</spring:url>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>${titlePage}</title>

<meta name="keywords" content="">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100'
	rel='stylesheet' type='text/css'>

<!-- styles -->
<link href="<spring:url value='/css/font-awesome.css' />"
	rel="stylesheet">
<link href="<spring:url value='/css/bootstrap.min.css' />"
	rel="stylesheet">
<link href="<spring:url value='/css/animate.min.css' />"
	rel="stylesheet">
<link href="<spring:url value='/css/owl.carousel.css' />"
	rel="stylesheet">
<link href="<spring:url value='/css/owl.theme.css' />" rel="stylesheet">

<!-- theme stylesheet -->
<link href="<spring:url value='/css/style.red.css' />" rel="stylesheet"
	id="theme-stylesheet">

<!-- your stylesheet with modifications -->
<link href="<spring:url value='/css/custom.css' />" rel="stylesheet">

<script src="<spring:url value='/js/respond.min.js' />"></script>

<link rel="shortcut icon"
	href="<spring:url value='/images/favicon.png' />">



</head>

<body>

	<!-- *** TOPBAR ***
 _________________________________________________________ -->
	<div id="top">
		<div class="container">
			<div class="col-md-6 offer" data-animate="fadeInDown">
				<a href='<spring:url value="/catalog/promotions"/>'
					class="btn btn-success btn-sm" data-animate-hover="shake"><spring:message
						code="offer" /></a>

				<c:if test="${client.idClient != 0}">
					<a href='<spring:url value="/changePassword"/>'><spring:message
							code="userMsg" /> ${client.firstName} ${client.lastName}</a>
				</c:if>

			</div>
			<div class="col-md-6" data-animate="fadeInDown">
				<ul class="menu">
					<li><a href='<spring:url value="/login"/>'><spring:message
								code="login" /></a></li>
					<li><a href='<spring:url value="/register"/>'><spring:message
								code="register" /></a></li>
					<li><a href="${localeFr}" class="btn btn-link btn-sm"><img
							src="<spring:url value='/images/france.png' />" /></a></li>
					<li><a href="${localeEn}" class="btn btn-link btn-sm"><img
							src="<spring:url value='/images/uk.png' />" /></a></li>
					<li><a class="btn btn-link" href='<spring:url value="#"/>'>
							<i class="fa fa-shopping-cart"></i> <span class="hidden-xs">
								<spring:message code="yourBasket" />
						</span>
					</a></li>
				</ul>
			</div>
		</div>


	</div>

	<!-- *** TOP BAR END *** -->

	<!-- *** NAVBAR ***
 _________________________________________________________ -->

	<div class="navbar navbar-default yamm" role="navigation" id="navbar">
		<div class="container">
			<div class="navbar-header">

				<a class="navbar-brand home" href='<spring:url value="/welcome"/>'
					data-animate-hover="bounce"> <img
					src="<spring:url value='/images/logo.png' />" class="hidden-xs">
					<img src="<spring:url value='/images/logo-small.png' />"
					class="visible-xs"><span class="sr-only">Rock'n'Shop</span>

				</a>

				<div class="navbar-buttons">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navigation">
						<span class="sr-only">Toggle navigation</span> <i
							class="fa fa-align-justify"></i>
					</button>
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#search">
						<span class="sr-only">Toggle search</span> <i class="fa fa-search"></i>
					</button>
				</div>

			</div>
			<!--/.navbar-header -->

			<div class="navbar-collapse collapse" id="navigation">

				<ul class="nav nav-pills nav-justified">
					<c:forEach items="${categories.categories}" var="category">
						<li><a
							href='<spring:url value="\rocknshop/catalog/${category.categoryEquivalent.idCategory}"/>'>
								${category.nameCategory} </a></li>
					</c:forEach>

				</ul>

			</div>
			<!--/.nav-collapse -->


		</div>
		<!-- /.container -->
	</div>
	<!-- /#navbar -->

	<!-- *** NAVBAR END *** -->


	<div>
		<tiles:insertAttribute name="main-content" />
	</div>


	<!-- *** FOOTER ***
 _________________________________________________________ -->
	<div id="footer" data-animate="fadeInUp">
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<h4>
						<spring:message code="pages" />
					</h4>

					<ul>
						<li><a href='<spring:url value="#"/>'><spring:message
									code="about" /></a></li>
						<li><a href='<spring:url value="/login"/>'><spring:message
									code="login" /></a></li>
						<li><a href='<spring:url value="/register"/>'><spring:message
									code="register" /></a></li>
					</ul>

					<hr>

					<hr class="hidden-md hidden-lg hidden-sm">

				</div>
				<!-- /.col-md-3 -->

				<hr>

				<h4>
					<spring:message code="inTouch" />
				</h4>

				<p class="social">
					<a href="#" class="facebook external" data-animate-hover="shake"><i
						class="fa fa-facebook"></i></a> <a href="#" class="twitter external"
						data-animate-hover="shake"><i class="fa fa-twitter"></i></a> <a
						href="#" class="instagram external" data-animate-hover="shake"><i
						class="fa fa-instagram"></i></a> <a href="#" class="gplus external"
						data-animate-hover="shake"><i class="fa fa-google-plus"></i></a> <a
						href="#" class="email external" data-animate-hover="shake"><i
						class="fa fa-envelope"></i></a>
				</p>


			</div>
			<!-- /.col-md-3 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- /#footer -->

	<!-- *** FOOTER END *** -->




	<!-- *** COPYRIGHT ***
 _________________________________________________________ -->
	<div id="copyright">
		<div class="container">
			<div class="col-md-6">
				<p class="pull-left">� 2016 Rock'n'Shop</p>

			</div>
			<div class="col-md-6">
				<p class="pull-right">
					Template by <a href="http://bootstrapious.com/e-commerce-templates">Bootstrapious</a>
					with support from <a href="https://kakusei.cz">Kakusei</a>
					<!-- Not removing these links is part of the licence conditions of the template. Thanks for understanding :) -->
				</p>
			</div>
		</div>
	</div>
	<!-- *** COPYRIGHT END *** -->




	<!-- /#all -->




	<!-- *** SCRIPTS TO INCLUDE ***
 _________________________________________________________ -->
	<script src="<spring:url value='/js/jquery-1.11.0.min.js' />"></script>
	<script src="<spring:url value='/js/bootstrap.min.js' />"></script>
	<script src="<spring:url value='/js/jquery.cookie.js' />"></script>
	<script src="<spring:url value='/js/waypoints.min.js' />"></script>
	<script src="<spring:url value='/js/modernizr.js' />"></script>
	<script src="<spring:url value='/js/bootstrap-hover-dropdown.js' />"></script>
	<script src="<spring:url value='/js/owl.carousel.min.js' />"></script>
	<script src="<spring:url value='/js/front.js' />"></script>


</body>

</html>