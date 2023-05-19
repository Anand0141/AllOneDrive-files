<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</head>
<body>
${msg}
	<h2><center>Welcome To E-Seva Birth Certificate Registration</center></h2>
	<div class="container">
	<form:form action="data" modelAttribute="registration">
		<div class="mb-3">
			<label for="firstName" class="form-label">First Name</label>
			<form:input path="firstName" class="form-control" />
		</div>
		<div class="mb-3">
			<label for="secondName" class="form-label">Second Name</label>
			<form:input path="secondName" class="form-control" />
		</div>
		<div class="mb-3">
			<label for="age" class="form-label">Age</label>
			<form:input path="age" class="form-control" />
		</div>
		<div class="mb-3">
			<label for="dob" class="form-label">Date Of Birth</label>
			<form:input path="dob" class="form-control" type="date" />
		</div>
		<div class="mb-3">
			<label for="city" class="form-label">City</label>
			<form:input path="city" class="form-control" />
		</div>

		<div class="mb-3">
			<input type="submit" value="submit" />
		</div>
		</form:form>
	</div>

</body>
</html>