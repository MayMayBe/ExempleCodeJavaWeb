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

	<div id="content">
		<div class="container">

			<div class="col-md-12">

				<ul class="breadcrumb">
					<li><a href='<spring:url value="/welcome"/>'><spring:message
								code="home" /></a></li>
					<li><spring:message code="newAccount" /> / <spring:message
							code="signIn" /></li>
				</ul>

			</div>

			<div class="col-md-6">
				<div class="box">
					<h1>
						<spring:message code="login" />
					</h1>

					<p class="lead">
						<spring:message code="alreadyCustomer" />
					</p>

					<hr>

					<form:form id="login" method="POST"
						action="/rocknshop/loginRegister/login"
						modelAttribute="clientLogin">
						<div class="form-group">
							<form:label path="email">
								<spring:message code="email" />
							</form:label>
							<form:input path="email" class="form-control" id="email" />
						</div>
						<div class="form-group">
							<form:label path="password">
								<spring:message code="password" />
								<spring:message code="minLengthPassword" />
							</form:label>
							<form:input type="password" path="password" class="form-control"
								id="password" />
						</div>
						<div class="text-center">
							<form:button type="submit" class="btn btn-primary">
								<i class="fa fa-sign-in"></i>
								<spring:message code="login" />
							</form:button>
						</div>
					</form:form>

					<hr>

				</div>
			</div>



			<div class="col-md-6">
				<div class="box">
					<h1>
						<spring:message code="newAccount" />
					</h1>

					<p class="lead">
						<spring:message code="notCustomer" />
					</p>



					<form:form id="inscription" method="POST"
						action="/rocknshop/loginRegister/send" modelAttribute="newClient">
						<div class="form-group required">
							<form:label path="lastName" class="control-label">
								<spring:message code="lastName" />
							</form:label>
							<form:input path="lastName" class="form-control" id="lastName"
								maxlength="50" />
							<input type="hidden" name="lastName"
								value="${newClient.lastName}">
						</div>
						<div class="form-group required">
							<form:label path="firstName" class="control-label">
								<spring:message code="firstName" />
							</form:label>
							<form:input path="firstName" class="form-control" id="firstName"
								maxlength="50" />
							<input type="hidden" name="firstName"
								value="${newClient.firstName}">
						</div>
						<div class="form-group required">
							<form:label path="email" class="control-label">
								<spring:message code="email" />
							</form:label>
							<form:input path="email" class="form-control" id="email"
								type="email" />
							<input type="hidden" name="email" value="${newClient.email}">
						</div>
						<div class="form-group required">
							<form:label path="password" class="control-label">
								<spring:message code="password" />
								<spring:message code="minLengthPassword" />
							</form:label>
							<form:input type="password" path="password" class="form-control"
								id="password" maxlength="65" minlength="8" />
						</div>
						<div class="form-group required">
							<form:label path="confirmPassword" class="control-label">
								<spring:message code="confirmPassword" />
							</form:label>
							<form:input type="password" path="confirmPassword"
								class="form-control" id="confirmPassword" maxlength="65"
								minlength="8" data-validation-length="8-65" />
						</div>
						<div class="form-group required">
							<form:label path="telephoneNumber" class="control-label">
								<spring:message code="telephoneNumber" />
							</form:label>
							<form:input path="telephoneNumber" class="form-control"
								id="phone" maxlength="25" />
							<input type="hidden" name="telephoneNumber"
								value="${newClient.telephoneNumber}">
						</div>
						<div class="form-group">
							<form:label path="mobileNumber">
								<spring:message code="mobile" />
							</form:label>
							<form:input path="mobileNumber" class="form-control" id="mobile"
								maxlength="36" />
							<input type="hidden" name="mobileNumber"
								value="${newClient.mobileNumber}">
						</div>
						<div class="form-group required">
							<form:label path="streetName" class="control-label">
								<spring:message code="streetName" />
							</form:label>
							<form:input path="streetName" class="form-control"
								id="streetName" maxlength="25" />
							<input type="hidden" name="streetName"
								value="${newClient.streetName}">
						</div>
						<div class="form-group required">
							<form:label path="streetNumber" class="control-label">
								<spring:message code="streetNumber" />
							</form:label>
							<form:input path="streetNumber" class="form-control"
								id="streetNumber" maxlength="8" />
							<input type="hidden" name="streetNumber"
								value="${newClient.streetNumber}">
						</div>
						<div class="form-group required">
							<form:label path="zipcode" class="control-label">
								<spring:message code="zipcode" />
							</form:label>
							<form:input path="zipcode" class="form-control" id="zipcode"
								maxlength="8" />
							<input type="hidden" name="zipcode" value="${newClient.zipcode}">
						</div>
						<div class="form-group required">
							<form:label path="city" class="control-label">
								<spring:message code="city" />
							</form:label>
							<form:input path="city" class="form-control" id="city"
								maxlength="50" />
							<input type="hidden" name="city" value="${newClient.city}">
						</div>
						<div class="form-group required">
							<form:label path="country" class="control-label">
								<spring:message code="country" />
							</form:label>
							<form:select path="country" type="text" class="form-control"
								id="city">
								<form:options path="country" items="${countries.countryList}"
									itemValue="countryName" itemLabel="countryName" />
								<input type="hidden" name="country" value="${newClient.country}">
							</form:select>
						</div>
						<div id="requiredFields">
							<h4>
								*
								<spring:message code="requiredFields" />
							</h4>
						</div>
						<div class="text-center">
							<form:button type="submit" class="btn btn-primary">
								<i class="fa fa-user"></i>
								<spring:message code="register" />
							</form:button>
						</div>
					</form:form>
				</div>
			</div>


		</div>
		<!-- /.container -->
	</div>
	<!-- /#content -->

</body>
</html>