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
							<li><a href='<spring:url value="changePassword"/>'><i
									class="fa fa-cogs"></i> <spring:message code="changePassword" /></a></li>
							<li class="active"><a
								href='<spring:url value="accountOrders"/>'><i
									class="fa fa-list"></i> <spring:message code="myOrders" /></a></li>
							<li><a href='<spring:url value="\rocknshop/signout"/>'><i
									class="fa fa-sign-out"></i> <spring:message code="logout" /></a></li>
						</ul>
					</div>

				</div>
				<!-- /.col-md-3 -->

				<!-- *** CUSTOMER MENU END *** -->
			</div>

			<div class="col-md-9" id="customer-orders">
				<div class="box">
					<h1>
						<spring:message code="myOrders" />
					</h1>

					<p class="lead">
						<spring:message code="ordersTxt" />
					</p>
					<hr>

					<c:if test="${empty orders}">
						<spring:message code="emptyOrders" />
					</c:if>

					<c:if test="${not empty orders}">
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th><spring:message code="order" /></th>
										<th><spring:message code="date" /></th>
										<th><spring:message code="paymentMethod" /></th>
										<th><spring:message code="status" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${orders}" var="order">
										<tr>
											<th>#${order.numberOrderShop}</th>
											<td><fmt:formatDate value="${order.dateOrderShop}"
													pattern="dd/MM/yy" /></td>
											<td>${order.typePayment}</td>
											<c:if test="${order.orderShopSent}">
												<td><span class="label label-success"><spring:message
															code="received" /></span>
											</c:if>
											<c:if test="${not order.orderShopSent}">
												<td><span class="label label-info"><spring:message
															code="prepared" /></span>
											</c:if>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:if>
				</div>
			</div>

		</div>
		<!-- /.container -->
	</div>


</body>
</html>