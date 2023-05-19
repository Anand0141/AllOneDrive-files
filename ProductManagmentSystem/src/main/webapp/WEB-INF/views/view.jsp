<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- jquery links -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
 -->
<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css"></link>
<script>
	$(document).ready(function() {
		$('#protab').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>
<br>
<script>
	function deleteCofirm() {
		return confirm("Are you sure, you want to delete?");
	}
</script>
</head>
<body>
	<H3>
		<a href="export-to-excel">export-to-excel</a>&nbsp&nbsp<a
			href="export-to-pdf">export-to-pdf</a>
	</H3>
	<a href="loadform">Add new Product</a>
	<table border=2 id="protab">
		<thead>
			<tr>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Quantity</th>
				<th>Product Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${viewAllProducts}" var="p">
				<br>
				<tr>
					<td>${p.pId}</td>
					<td>${p.pName}</td>
					<td>${p.quantity}</td>
					<td>${p.price}</td>
					<td><a href="edit?pId=${p.pId}">Edit</a></td>
					<td><a href="delete?pId=${p.pId}" onclick="deleteConfirm()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>