<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:form action="update" modelAttribute="edit">
		<table>
			<tr>
				<c:hidden path="pId" />
			</tr>
			<tr>
				Product Name:
				<c:input path="pName" />
			</tr>
			<br><br>
			<tr>
				Product Qunatity:
				<c:input path="quantity" />
			</tr>
			<br><br>
			<tr>
				Product Price:
				<c:input path="price" />
			</tr>
			</br><br>
			<tr>
				<input type="submit" value="update">
			</tr>
		</table>
	</c:form>
</body>
</html>