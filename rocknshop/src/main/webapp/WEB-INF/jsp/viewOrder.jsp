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

<div id="all">

        <div id="content">
            <div class="container">



                <div class="col-md-9" id="basket">

                    <div class="box">



								
                            <h1><spring:message code="shoppingCart" /></h1>
                            <c:set var="countInstrument" value="0" scope="page" />
                            <c:set var="countTotal" value="0" scope="page" />
                             <c:forEach items="${clientBasket.orderShopLines}" var="line">
                                    <c:set var="countInstrument" value="${countInstrument+line.value.quantity}" scope="page" />
                             </c:forEach>
                             
                             <form:form id="basketForm"
													method="POST"
													action="\rocknshop/basket/update"
													modelAttribute="clientBasket">
                            <p class="text-muted"><spring:message code="shoppingCartInfo_1" /> ${countInstrument} <spring:message code="shoppingCartInfo_2" /></p>
                            
	                       
                            
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th colspan="2"><spring:message code="product" /></th>
                                            <th><spring:message code="quantity" /></th>
                                            <th><spring:message code="unitPrice" /></th>
                                            <th><spring:message code="discount" /></th>
                                            <th colspan="2"><spring:message code="total" /></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    
                                    <c:forEach items="${clientBasket.orderShopLines}" var="line">
                                    
                                        <tr>
                                            <td>
                                                <a href='<spring:url value="\rocknshop/details/${line.value.model.idModel}"/>'>
                                                    <img src='<spring:url value="/images/zoom/${line.value.model.idModel}.jpg"/>' alt="hardcodé">
                                                </a>
                                            </td>
                                            <td><a href='<spring:url value="\rocknshop/details/${line.value.model.idModel}"/>'>${line.value.model.nameModel}</a>
                                            </td>
                                            
                                            		
                                            
                                            
                                            <td>
                                            	<form:input path="orderShopLines[${line.key}].quantity" value="${line.value.quantity}" class="form-control" id="quantity" min="1" max="10" type="number" style="width:75px"></form:input>
                                            	
                                            </td>
                                            
                                            
                                            <td><fmt:formatNumber value="${line.value.realPrice}" minFractionDigits="2" maxFractionDigits="2" /> €</td>
                                            <td><fmt:formatNumber value="${line.value.percentageDiscount*100}" minFractionDigits="0" maxFractionDigits="0" />%</td>
                                            <td><fmt:formatNumber value="${(line.value.realPrice*line.value.quantity)*(1-line.value.percentageDiscount)}" minFractionDigits="2" maxFractionDigits="2" /> €</td>
                                            <c:set var="countTotal" value="${countTotal+(line.value.realPrice*line.value.quantity)*(1-line.value.percentageDiscount)}" scope="page" />
                                            <td><a href="\rocknshop/basket/deleteInstrument/${line.value.model.idModel}"><i class="fa fa-trash-o"></i></a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <th colspan="5">Total</th>
                                            <th colspan="2"><fmt:formatNumber value="${countTotal}" minFractionDigits="2" maxFractionDigits="2" /> €</th>
                                        </tr>
                                    </tfoot>
                                </table>

                            </div>
                            <!-- /.table-responsive -->

                            <div class="box-footer">
                                
                                <div class="pull-right">
                                    <form:button type="submit" class="btn btn-default"><i class="fa fa-refresh"></i><spring:message code="updateBasket" /></form:button>
                                    
                                    </form:form>
                                    <a href='<spring:url value="/processCommand/payment"/>' class="btn btn-primary"><spring:message code="proceedCheckout" /><i class="fa fa-chevron-right"></i>
                                    </a>
                                </div>
                            </div>
						</div>
                        </div>

                    </div>
                    <!-- /.box -->


                            <!-- /.product -->
                        
                            <!-- /.product -->

                <!-- /.col-md-9 -->



                <!-- /.col-md-3 -->


            <!-- /.container -->


</body>
</html>