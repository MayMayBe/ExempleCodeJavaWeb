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
	<div id="all">

		<div id="content">
			<div class="container">

				<c:if test="${processCommand.inPayment }">

					<div class="col-md-9" id="checkout">

						<div class="box">

							<h1>
								<spring:message code="paymentTitle" />
							</h1>
							<ul class="nav nav-pills nav-justified">
								<li class="active"><a href="#"><i class="fa fa-money"></i><br>
										<spring:message code="paymentMethod" /></a></li>
								<li class="disabled"><a href="checkout4.html"><i
										class="fa fa-eye"></i><br> <spring:message
											code="orderReview" /></a></li>


							</ul>

							<form:form id="paymentForm" method="POST"
								action="\rocknshop/processCommand/pickPayment"
								modelAttribute="orderShop">

								<div class="content">
									<div class="row">
										<div id="paypal-button">
											<div class="col-sm-6">
												<div class="box payment-method">

													<h4>
														<spring:message code="paypal" />
													</h4>

													<p>
														<spring:message code="paypalComing" />
													</p>

													<div class="box-footer text-center"></div>
												</div>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="box payment-method">

												<h4>
													<spring:message code="cash" />
												</h4>

												<p>
													<spring:message code="cashInfo" />
												</p>

												<div class="box-footer text-center">

													<form:radiobutton path="typePayment" value="Cash"
														checked="checked" name="selectPayment" />
												</div>
											</div>
										</div>
									</div>
									<!-- /.row -->

								</div>
								<!-- /.content -->


								<div class="box-footer">

									<div class="pull-right">

										<form:button type="submit" class="btn btn-primary">
											<spring:message code="continueConfirmOrder" />
											<i class="fa fa-chevron-right"></i>
										</form:button>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</c:if>
				<c:if test="${not processCommand.inPayment }">


					<div class="col-md-9" id="checkout">

						<div class="box">

							<h1>${orderShop.numberOrderShop }</h1>
							<ul class="nav nav-pills nav-justified">
								<li class="disabled"><a href="#"><i class="fa fa-money"></i><br>
										<spring:message code="paymentMethod" /></a></li>
								<li class="active"><a href="checkout4.html"><i
										class="fa fa-eye"></i><br> <spring:message
											code="orderReview" /></a></li>


							</ul>

							<div class="content">

								<div class="alert alert-success">
									<spring:message code="orderInSystem" />
								</div>


								<!-- /.content -->

							</div>
							</div>
							</div>
				</c:if>

			</div>
		</div>
	</div>

	

</body>
</html>