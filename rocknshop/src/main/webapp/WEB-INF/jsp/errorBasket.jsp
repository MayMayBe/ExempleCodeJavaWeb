<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

                                <h3><spring:message code="errorBasketWarning" /></h3>

                                <p class="text-center"><spring:message code="errorBasketMsg" /></p>

                                <p class="buttons"><a href='<spring:url value="/loginRegister"/>' class="btn btn-primary"><i class="fa fa-user"></i><spring:message code="errorBasketGoTo" /></a>
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