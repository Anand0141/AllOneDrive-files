<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

    <%@page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
 --><link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script>

$(document).ready(function() {
	$('#protab').DataTable({
		"pagingType" : "full_numbers"
	});
});
</script>
<script>
	function deleteConfirm(){
		return confirm("Are you sure, you want to delete?");
	}
</script>
</head>
<body>
	<H3><a href="export-to-excel">export-to-excel</a>&nbsp&nbsp<a href="export-to-pdf">export-to-pdf</a></H3>

	<a href="loadForm">Add New Product</a>
	<table border="2" id="protab">
		<thead>
			<tr>
				<th>ProductId</th>
				<th>Product Name</th>
				<th>product Qty</th>
				<th>product Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${listProducts}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.pname}</td>
					<td>${p.qty}</td>
					<td>${p.price}</td>
			
  <td><a href="editstu?id=${p.id}">Edit</a></td>
     <td><a href="deletestu?id=${p.id}" onclick="deleteConfirm()">Delete</a>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>