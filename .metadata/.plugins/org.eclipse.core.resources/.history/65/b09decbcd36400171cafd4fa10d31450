<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
        <div id="content">
            <div class="container">

                <div class="col-md-12">
                        	
                        	<c:if test="${empty allCatalog}">
                        	<div class="box">
                        		<c:choose>
                        			<c:when test="${hasExecutedSearch}">
                        				<h1><spring:message code="noResults" /></h1>
                        			</c:when>
                        			<c:otherwise>
                        				<h1><spring:message code="emptyCatalog" /></h1>
                        			</c:otherwise>
                        		</c:choose>
                        		  </div>
                        	</c:if>

        

                    

                    <div class="row products">
						<c:set var="count" value="0" scope="page" />
						<c:forEach items="${allCatalog}" var="model">
							
							<div class="col-md-3 col-sm-4">
                            <div class="product">
                                <div class="flip-container">
                                    <div class="flipper">
                                        <div class="front">
                                            <a href='<spring:url value="\rocknshop/details/${model.idModel}"/>'>
                                                <img src='<spring:url value="/images/full/${model.idModel}.jpg"/>' alt="" class="img-responsive">
                                            </a>
                                        </div>
                                        <div class="back">
                                            <a href='<spring:url value="\rocknshop/details/${model.idModel}"/>'>
                                                <img src='<spring:url value="/images/zoom/${model.idModel}.jpg"/>' alt="" class="img-responsive">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <a href='<spring:url value="\rocknshop/details/${model.idModel}"/>' class="invisible">
                                    <img src='<spring:url value="/images/full/${model.idModel}.jpg"/>' alt="" class="img-responsive">
                                </a>
                                <div class="text">
                                    <h3><a href='<spring:url value="\rocknshop/details/${model.idModel}"/>'>${model.nameModel}</a></h3>
                                    <h3>${model.brand.nameBrand}</h3>
                                    <p class="price">
                                    
                                   
                                   <c:choose>
                                    	<c:when test="${not empty promotionList}">
                                    	<c:set var="priceHasBeenShown" value="false"/>
	                               		 	<c:forEach items="${promotionList}" var="promo">
	                               		 		<c:if test="${!priceHasBeenShown}">
													<c:choose>     
													    <c:when test="${promo.brand.nameBrand == model.brand.nameBrand}">
													    	
													    	<fmt:formatNumber value="${model.price * (1-promo.percentageReduction)}" minFractionDigits="2" maxFractionDigits="2" /> €
													    	<br>
													    	<del><fmt:formatNumber value="${model.price}" minFractionDigits="2" maxFractionDigits="2" /> €</del>
													    	<c:set var="priceHasBeenShown" value="true"/>
													    </c:when>
						                            </c:choose>
						                        </c:if>
			                            	</c:forEach>
			                            	<c:if test="${!priceHasBeenShown}">
			                            		<br>
						                          <fmt:formatNumber value="${model.price}" minFractionDigits="2" maxFractionDigits="2" /> €
						                    </c:if>
                                    	</c:when>
                                    	<c:otherwise>
                                    		<fmt:formatNumber value="${model.price}" minFractionDigits="2" maxFractionDigits="2" /> €
                                    	</c:otherwise>
                                    </c:choose>
                                   
		                            </p>

                                    <p class="buttons">
                                    	<a href='<spring:url value="\rocknshop/details/${model.idModel}"/>' class="btn btn-default"><spring:message code="viewDetail" /></a>
                                        <a href='<spring:url value="\rocknshop/basket/newInstrument/${model.idModel}"/>' class="btn btn-primary"><i class="fa fa-shopping-cart"></i><spring:message code="addCart" /></a>
                                    </p>
                                </div>

							
							<c:if test="${count < 10}" >
								<div class="ribbon new">
                                    <div class="theribbon"><spring:message code="new" /></div>
                                    <div class="ribbon-background"></div>
                                </div>
								<!-- /.ribbon -->
								<c:set var="count" value="${count+1}" scope="page" />
							</c:if>
							
							<c:forEach items="${promotionList}" var="promo">
								<c:if test="${promo.brand.nameBrand == model.brand.nameBrand}">
								    <div class="ribbon sale">
	                                    <div class="theribbon"><spring:message code="sale" /></div>
	                                    <div class="ribbon-background"></div>
	                                </div>							 
	                            </c:if>
                            </c:forEach>

								</div>		
								</div>				
						</c:forEach>
                            <!-- /.product -->
                            
						<!-- ElectricGuitars -->
						<c:forEach items="${electricGuitars}" var="model">
							
							<div class="col-md-3 col-sm-4">
                            <div class="product">
                                <div class="flip-container">
                                    <div class="flipper">
                                        <div class="front">
                                            <a href='<spring:url value="\rocknshop/details/${model.idModel}"/>'>
                                                <img src='<spring:url value="/images/full/${model.idModel}.jpg"/>' alt="" class="img-responsive">
                                            </a>
                                        </div>
                                        <div class="back">
                                            <a href='<spring:url value="\rocknshop/details/${model.idModel}"/>'>
                                                <img src='<spring:url value="/images/zoom/${model.idModel}.jpg"/>' alt="" class="img-responsive">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                                <a href='<spring:url value="/details"/>' class="invisible">
                                    <img src='<spring:url value="/images/full/${model.idModel}.jpg"/>' alt="" class="img-responsive">
                                </a>
                                <div class="text">
                                    <h3><a href='<spring:url value="\rocknshop/details/${model.idModel}"/>'>${model.nameModel}</a></h3>
                                    <p class="price">                            
                                     <fmt:formatNumber value="${model.price}" minFractionDigits="2" maxFractionDigits="2" /> €</p>
                                    <p class="buttons">
                                        <a href='<spring:url value="\rocknshop/details/${model.idModel}"/>' class="btn btn-default"><spring:message code="viewDetail" /></a>
                                        <a href='<spring:url value="\rocknshop/basket/newInstrument/${model.idModel}"/>' class="btn btn-primary"><i class="fa fa-shopping-cart"></i><spring:message code="addCart" /></a>
                                    
                                    </p>
                                </div>
								</div>		
								</div>				
						</c:forEach>
                            <!-- /.product -->
                            
                        </div>

                       


                </div>
                <!-- /.col-md-9 -->

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

</body>
</html>