<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${msg}

<form:form action="register" modelAttribute="product">
Product Name : <form:input path="pname"/><br>
product Qty  : <form:input path="qty"/><br>
Product Price : <form:input path="price"/><br>

<input type="submit" value="Insert"/>
</form:form>
<a href="viewrecords">ViewProducts</a>
</body>
</html>