<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddBook</title>
</head>
<body>
	<p>${msg}</p>
	<form:form action="./addProducts" modelAttribute="eshwar">
		ProductName:<form:input path="productName" />
		<br>
		ProductQty:<form:input path="productQty" />
		<br>
		ProductPrice:<form:input path="productPrice" />
		<br>
		<input type="submit" value="addBook">
	</form:form>
	<a href="viewProducts">viewAllProducts</a>
</body>
</html>