<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Customers</title>
	
	<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>
	<div id="wrapper">
		<div id="header">
		<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<!--  Put new button: Add Customer -->
		<input type="button" value="Add Customer"
			onClick="window.location.href='showFormForAdd'; return false;"
			class="add-button"/>
			
		<!--  add a search box -->
        <form:form action="search" method="GET">
        	Search customer: <input type="text" name="theSearchName" />  
			<input type="submit" value="Search" class="add-button" />
		</form:form>
					
		<!-- Add out HTML table here -->
		
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>E-Mail</th>
				<th>Action</th>
			</tr>
			
			<!--  Loop over and print our customers -->
			<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- Construct an "update" link with customer id -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				
				<!-- Construct an "update" link with customer id -->
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					<td><a href="${updateLink}">Update
					|  
					<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
		
	</div>
</body>
</html>