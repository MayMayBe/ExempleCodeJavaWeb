<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>



	<div id="content">
		<div class="container">



			<div class="col-md-3">
				<!-- *** CUSTOMER MENU ***
 _________________________________________________________ -->
				<div class="panel panel-default sidebar-menu">

					<div class="panel-heading">
						<h3 class="panel-title">
							<spring:message code="customerSection" />
						</h3>
					</div>

					<div class="panel-body">

						<ul class="nav nav-pills nav-stacked">
							<li><a href='<spring:url value="#"/>'><i
									class="fa fa-user"></i> <spring:message code="myAccount" /></a></li>
							<li class="active"><a
								href='<spring:url value="changePassword"/>'><i
									class="fa fa-cogs"></i> <spring:message code="changePassword" /></a></li>
							<li><a href='<spring:url value="accountOrders"/>'><i
									class="fa fa-list"></i> <spring:message code="myOrders" /></a></li>
							<li><a href='<spring:url value="\rocknshop/signout"/>'><i
									class="fa fa-sign-out"></i> <spring:message code="logout" /></a></li>
						</ul>
					</div>

				</div>
				<!-- /.col-md-3 -->

				<!-- *** CUSTOMER MENU END *** -->
			</div>

			<div class="col-md-9">
				<div class="box">
					<h1>
						<spring:message code="myAccount" />
					</h1>
					<p class="lead">
						<spring:message code="customerTxt" />
					</p>
					<h3>
						<spring:message code="changePassword" />
					</h3>
					<c:choose>
						<c:when test="${errorMessage eq '0'}">
							<p class="lead text-success">
								<spring:message code="passwordChangedSuccess" />
							</p>
						</c:when>
						<c:otherwise>
							<p class="lead text-danger">${errorMessage }</p>
						</c:otherwise>
					</c:choose>

					<form:form method="POST" action="/rocknshop/changePassword"
						modelAttribute="passwordChangeForm">
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<form:label path="oldPassword" for="oldPassword">
										<spring:message code="oldPassword" />
									</form:label>
									<form:input path="oldPassword" type="password"
										class="form-control" id="oldPassword" maxlength="65"
										minlength="8" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<form:label path="newPassword" for="newPassword">
										<spring:message code="newPassword" />
									</form:label>
									<form:input path="newPassword" type="password"
										class="form-control" id="newPassword" maxlength="65"
										minlength="8" />
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<form:label path="retypeNewPassword" for="retypeNewPassword">
										<spring:message code="retypePassword" />
									</form:label>
									<form:input path="retypeNewPassword" type="password"
										class="form-control" id="retypeNewPassword" maxlength="65"
										minlength="8" />
								</div>
							</div>
						</div>
						<!-- /.row -->
						<br>
						<div class="col-sm-12 text-center">
							<form:button type="submit" class="btn btn-primary">
								<i class="fa fa-save"></i>
								<spring:message code="saveNewPassword" />
							</form:button>
						</div>
					</form:form>
					<br> <br>
				</div>
			</div>

		</div>
		<!-- /.container -->
	</div>
	<!-- /#content -->


</body>
</html>