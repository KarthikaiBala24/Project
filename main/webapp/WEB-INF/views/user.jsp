<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product Display</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<%@ include file="header.jsp"%>
	
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>price</th>
					<th>Category</th>
					<th>Image</th>
					<th>Action</th>
				</tr>
			</thead>
			<col width="10%">
			<col width="15%">
			<col width="10%">
			<col width="10%">
			<col width="25%">
			<col width="30%">
			<tbody>

				<tr>
					<td>${pro.pname}</td>
					<td>${pro.pdesc}</td>
					<td>${pro.price}</td>
					<td>${pro.category.cname}</td>
					<td><img class="img-thumbnail" alt=""
						src="${pageContext.request.contextPath}/resources/images/${pro.id}.jpg">
					</td>
					<td><a
						href="${pageContext.request.contextPath}/viewProduct/${pro.id}"
						class="btn btn-primary">Add To Cart</a></td>
						<td><a
						href="${pageContext.request.contextPath}/viewProduct/${pro.id}"
						class="btn btn-primary">Delete From Cart</a></td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>