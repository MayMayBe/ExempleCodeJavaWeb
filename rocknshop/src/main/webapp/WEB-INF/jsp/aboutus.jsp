<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAsWUNujE3_b644Vav4dxmIq2sQ5xPBjeE "
		type="text/javascript"></script>

	<div id="all">
		<div class="col-md-3">
			<div class="panel panel-default sidebar-menu">

				<div class="panel-heading">
					<h3 class="panel-title">Pages</h3>
				</div>

				<div class="panel-body">
					<ul class="nav nav-pills nav-stacked">
						<li><a href="#contact"><spring:message code="contact" /></a></li>
						<li><a href="#crew"><spring:message code="theCrew" /></a></li>

					</ul>

				</div>
			</div>
		</div>

		<div id="content">
			<div class="container">
				<div class="col-md-9">


					<div class="box" id="contact">
						<h1><spring:message code="contact" /></h1>

						<p class="lead"><spring:message code="contactExplanation" /></p>

						<hr>
						<h2><spring:message code="schedule" /></h2>
						<hr>

						<div class="row">
							<div class="col-sm-4">
								<h3>
									<i class="fa fa-map-marker"></i> <spring:message code="address" />
								</h3>
								<p>
									rue Joseph Calozet 19<br>5580 Namur 
									<br> <strong>Belgique</strong>
								</p>
							</div>
							<!-- /.col-sm-4 -->
							<div class="col-sm-4">
								<h3>
								
									<i class="fa fa-phone"></i> <spring:message code="phone" />
								</h3>
								<p>
									<strong>+32 81 46 85 00</strong>
								</p>
							</div>
							<!-- /.col-sm-4 -->
							<div class="col-sm-4">
								<h3>
									<i class="fa fa-envelope"></i> <spring:message code="email" />
								</h3>
								<p>
								
									<strong><a href="mailto:">info@rocknshop.be</a></strong>
									
								</p>
							</div>
							<!-- /.col-sm-4 -->
						</div>
						<!-- /.row -->


						<hr>

						<div id="map"></div>

						<hr>					

					<!-- May & Arthur -->
					<div class="row" id="crew">
					<h1><spring:message code="theCrew" /></h1>
					<p class="lead"><spring:message code="crewExplanation" /></p>

						<hr>
						<div class="col-md-6 .offset-md-3">
							<p class="text-center">
								<img src='<spring:url value="/images/may.jpg"/>'
									class="img-circle img-responsive" alt="">
							</p>
							<p>
							<h3 class="text-center">May</h3>
							</p>
						</div>

						<div class="col-md-6 .offset-md-3">
							<p class="text-center">
								<img src='<spring:url value="/images/arthur.jpg"/>'
									class="img-circle img-responsive" alt="">
							</p>
							<p>
							<h3 class="text-center">Arthur</h3>
							</p>
						</div>
					</div>

					<!-- May & Arthur END -->
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.col-md-9 -->



	<script src="<spring:url value='/js/googleMap.js' />"></script>
</body>
</html>