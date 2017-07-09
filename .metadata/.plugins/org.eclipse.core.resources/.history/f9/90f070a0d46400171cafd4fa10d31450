<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

        <div id="content">
            <div class="container">

               
				 <div class="col-sm-10 col-sm-offset-1">
                    <div class="box">
                        <h1><spring:message code="login" /></h1>

                        <p class="lead"><spring:message code="alreadyCustomer" /></p>

	  <p class="lead text-danger">${errorMessage }</p>
                        <hr>

                        <form:form id="login" method="POST" action="/rocknshop/login" modelAttribute="clientLogin">
                            <div class="form-group">
                                 <form:label path="email"><spring:message code="email" /></form:label>
                                <form:input path="email" class="form-control" id="email"/>
                            </div>
                            <div class="form-group">
                                <form:label path="password"><spring:message code="password" /> <spring:message code="minLengthPassword"/></form:label>
                                <form:input type="password" path="password" class="form-control" id="password"/>
                            </div>
                            <div class="text-center">
                            <form:button type="submit" class="btn btn-primary"><i class="fa fa-sign-in"></i><spring:message code="login" /></form:button>
                            </div>
                        </form:form>
						
						<hr>
				
                    </div>
                </div>

            </div>
            <!-- /.container -->
        </div>
        <!-- /#content -->

</body>
</html>