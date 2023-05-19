<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<center>
		<h1>
			<u>Student List</u>
		</h1>
	</center>
	<hr />
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th colspan="2" align="center">Action</th>
		</tr>
		<c:forEach var="student" items="${students}" varStatus="status">
			<tr>
				<td>${status.index +1 }</td>
				<td>${student.studentName}</td>
				<td>${student.studentAddress}</td>
				<td><a href="./edit?id=${student.studentId}" class="btn btn-primary">Update</a></td>
				<td><a href='./delete?id=${student.studentId}' class="btn btn-danger">Delete</a></td>
				
				
			</tr> 
		</c:forEach>
	</table>
	<a href="./" class="btn btn-primary">Back</a>
	</div>
</body>
</html>