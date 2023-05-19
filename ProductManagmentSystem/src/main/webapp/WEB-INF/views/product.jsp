<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>

	<p>${msg}</p>

	<c:form action="./register" modelAttribute="pro">

Product Name    <c:input path="pName" />
		<br>
		<br>
Product quantity <c:input path="quantity" />
		<br>
		<br>
Product Price	<c:input path="price" />
		<br>
		<br>
		<input type="submit" value="Insert">
	</c:form>
	<br>
	<br>
	<a href="viewrecords">View All Products</a>

</body>
</html>