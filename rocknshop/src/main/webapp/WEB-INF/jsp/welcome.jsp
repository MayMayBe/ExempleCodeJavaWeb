<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>


	<div id="all">
		<div id="content">

			<div class="container">
				<div class="col-md-12">
					<div id="main-slider">
						<div class="item">
							<img src='<spring:url value="/images/ibanez_slider.jpg"/>' alt=""
								class="img-responsive">
						</div>
						<div class="item">
							<img class="img-responsive"
								src='<spring:url value="/images/fender_slider.jpg"/>' alt="">
						</div>
						<div class="item">
							<img class="img-responsive"
								src='<spring:url value="/images/gibson_slider.jpg"/>' alt="">
						</div>
					</div>
					<!-- /#main-slider -->
				</div>
			</div>
			<div id="advantages">

				<div class="container">
					<div class="same-height-row">
						<div class="col-sm-4">
							<div class="box same-height">
								<div class="icon">
									<i class="fa fa-shopping-cart"></i>
								</div>

								<h3>
									<a href="#"><spring:message code="stock" /></a>
								</h3>
								<p>
									<spring:message code="stockTxt" />
								</p>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="box same-height">
								<div class="icon">
									<i class="fa fa-building-o" aria-hidden="true"></i>
								</div>

								<h3>
									<a href="#"><spring:message code="pickOrder" /></a>
								</h3>
								<p>
									<spring:message code="pickOrderTxt" />
								</p>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="box same-height">
								<div class="icon">
									<i class="fa fa-thumbs-up"></i>
								</div>

								<h3>
									<a href="#"><spring:message code="guarantee" /></a>
								</h3>
								<p>
									<spring:message code="guaranteeTxt" />
								</p>
							</div>
						</div>
					</div>
					<!-- /.row -->

				</div>
				<!-- /.container -->

			</div>
			<!-- /#advantages -->

			<div id="content">

				<div id="hot">

					<div class="box">
						<div class="container">
							<div class="col-md-12">
								<h2>
									<spring:message code="newProducts" />
								</h2>
							</div>
						</div>
					</div>

					<div class="container">
						<div class="product-slider">


							<c:forEach items="${model}" var="model">

								<div class="item">
									<div class="product">

										<div class="flip-container">
											<div class="flipper">
												<div class="front">
													<a
														href='<spring:url value="\rocknshop/details/${model.idModel}"/>'>
														<img
														src='<spring:url value="/images/full/${model.idModel}.jpg"/>'
														alt="" class="img-responsive">
													</a>
												</div>
												<div class="back">
													<a
														href='<spring:url value="\rocknshop/details/${model.idModel}"/>'>
														<img
														src='<spring:url value="/images/zoom/${model.idModel}.jpg"/>'
														alt="" class="img-responsive">
													</a>
												</div>
											</div>
										</div>
										<a
											href='<spring:url value="\rocknshop/details/${model.idModel}"/>'
											class="invisible"> <img
											src='<spring:url value="/images/full/${model.idModel}.jpg"/>'
											alt="" class="img-responsive">
										</a>
										<div class="text">
											<h3>
												<a
													href='<spring:url value="\rocknshop/details/${model.idModel}"/>'
													class="invisible">${model.nameModel}</a>
											</h3>
											<h3>${model.brand.nameBrand}</h3>
											<h3>${model.nameModel}</h3>
											<p class="price">
												<fmt:formatNumber value="${model.price}"
													minFractionDigits="2" maxFractionDigits="2" />
												€
											</p>


											<p class="buttons">
												<a
													href='<spring:url value="\rocknshop/details/${model.idModel}"/>'
													class="btn btn-default"><spring:message
														code="viewDetail" /></a> <a
													href='<spring:url value="\rocknshop/basket/newInstrument/${model.idModel}"/>'
													class="btn btn-primary"><i class="fa fa-shopping-cart"></i>
													<spring:message code="addCart" /></a>
											</p>
										</div>



										<div class="ribbon new">
											<div class="theribbon">
												<spring:message code="new" />
											</div>
											<div class="ribbon-background"></div>
										</div>
										<!-- /.ribbon -->




									</div>
								</div>
							</c:forEach>
							<!-- /.product -->


							<!-- /.product -->

						</div>
						<!-- /.product -->
					</div>

				</div>
				<!-- /.product-slider -->
			</div>
			<!-- /.container -->

		</div>
		<!-- /#hot -->

	</div>

	<!-- *** HOT END *** -->


</body>
</html>