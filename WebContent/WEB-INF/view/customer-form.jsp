<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Save Customer</title>
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
		<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
			<div id="container">
				<h3>Save Customer</h3>
				<form:form action="saveCustomer" modelAttribute="customer" method="POST">
					<table>
						<tbody>
							<tr>
								<td><label>First name:</label>
								<td><form:input path="firstName"/></td>
							</tr>
							<tr>
								<td><label>Last name:</label>
								<td><form:input path="lastName"/></td>
							</tr>
							<tr>
								<td><label>E-Mail:</label>
								<td><form:input path="email"/></td>
							</tr>
							<tr>
								<td><label></label>
								<td><input type="submit" value="Submit" class="save"/></td>
							</tr>
						</tbody>
					</table>
				</form:form>
				
				<div style="clear; both;"></div>
				
				<p>
					<a href="${pageContext.request.contextPage}/customer/list">Back to the list</a>
				</p>
				
			</div>
		</div>
	</body>
</html>