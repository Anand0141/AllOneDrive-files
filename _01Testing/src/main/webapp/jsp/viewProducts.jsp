<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	id name authorname bookprice edit delete

	<c:forEach items="${getProducts}" var="b">

${b.productId}
${b.productName}
${b.productQty}
${b.productPrice}

<a href="editBook?id=${b.productId}">Edit</a>
		<br>

		<a href="deleteBook?id=${b.productId}">Delete</a>
		<br>


	</c:forEach>

</body>
</html>