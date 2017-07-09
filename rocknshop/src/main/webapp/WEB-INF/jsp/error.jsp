<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE htm>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="all">

		<div id="content">
			<div class="container">

				<div class="col-md-12">


					<div class="row" id="error-page">
						<div class="col-sm-6 col-sm-offset-3">
							<div class="box">

								<p class="text-center">
									<img src='<spring:url value="/images/logo.png"/>' />
								</p>

								<h4 class="text-muted">
									<spring:message code="error404" />
								</h4>

								<p class="buttons">
									<a href="/rocknshop/welcome" class="btn btn-primary"><i
										class="fa fa-home"></i>
									<spring:message code="gotoHomepage" /></a>
								</p>
							</div>
						</div>
					</div>


				</div>
				<!-- /.col-md-9 -->
			</div>
			<!-- /.container -->
		</div>
		<!-- /#content -->
</body>
</html>