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



				<!-- *** MENUS AND FILTERS ***
 _________________________________________________________ -->


				<!-- *** MENUS AND FILTERS END *** -->



				<div class="row" id="productMain">
					<div class="col-md-4">
						<div id="mainImage">
							<img
								src='<spring:url value="/images/full/${model.idModel}.jpg"/>'
								alt="" class="img-responsive">
						</div>

					</div>
					<div class="col-md-8">
						<div class="box">
							<h1 class="text-center">${model.nameModel}</h1>
							<h1 class="text-center">${brand.nameBrand}</h1>
							<p class="goToDescription">
								<a href="#details" class="scroll-to"><spring:message
										code="scrollTo" /></a>
							</p>
							<p class="price">
								<c:choose>

									<c:when test="${not empty promotedPrice}">

										<fmt:formatNumber value="${promotedPrice}"
											minFractionDigits="2" maxFractionDigits="2" /> € <br>
										<br>
										<del>
											<fmt:formatNumber value="${model.price}"
												minFractionDigits="2" maxFractionDigits="2" />
											€
										</del>

									</c:when>
									<c:otherwise>

										<fmt:formatNumber value="${model.price}" minFractionDigits="2"
											maxFractionDigits="2" /> €
								    	
								    </c:otherwise>
								</c:choose>
							</p>

							<p class="text-center buttons">
								<a
									href='<spring:url value="#"/>'
									class="btn btn-primary"><i class="fa fa-shopping-cart"></i>
									<spring:message code="addCart" /></a>

							</p>


						</div>
					</div>

				</div>


				<div class="box" id="details">
					<p>
					<h4>
						<spring:message code="productDetails" />
					</h4>
					<p></p>
					<p>
						<spring:message code="brand" />
						: ${brand.nameBrand}
					</p>
					<p>
						<spring:message code="country" />
						: ${brand.country.countryName}
					</p>
					<p>
						<spring:message code="fretless" />
						: ${fretlessModel}
					</p>
					<p>
						<spring:message code="numStrings" />
						: ${numStrings}
					</p>
					<p>
						<spring:message code="description" />
						: ${description.description}
					</p>
					<hr>
					<div class="social">
						<h4>
							<spring:message code="showIt" />
						</h4>
						<p>
							<a href="#" class="external facebook" data-animate-hover="pulse"><i
								class="fa fa-facebook"></i></a> <a href="#" class="external gplus"
								data-animate-hover="pulse"><i class="fa fa-google-plus"></i></a>
							<a href="#" class="external twitter" data-animate-hover="pulse"><i
								class="fa fa-twitter"></i></a> <a href="#" class="email"
								data-animate-hover="pulse"><i class="fa fa-envelope"></i></a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>