	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
		<center>
			<h1 style="color:red">Update Student Form</h1>
		</center>
		<hr />
		 
		<h2 style="color: red">${msg}</h2>
		<a href="./list" class="btn btn-warning">Student List</a>
		<hr />

		<form:form action="updateStudent" method="post" modelAttribute="student">
			<table class="table table-striped">
				<tr>
					Student Id:
					<form:input path="studentId" class="form-control" />
				</tr>
				<tr>
					Student Name:
					<form:input path="studentName" class="form-control" />
				</tr>
				<tr>
					Student Address:
					<form:input path="studentAddress" class="form-control" />
				</tr>
				<tr>
					<input type="submit" value="Update" class="btn btn-primary"
						style="margin: 10px">
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>