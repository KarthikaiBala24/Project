<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Product</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<style>
	.container,table {
    font-style: oblique;
   
    font-weight: bold;
    font-size: 16px;
    }
 /* .container {
	font-family: Lucida Handwriting;
	font-size: 16px;
	color: #6699CC;
	font-weight: bold;
} */
 .container{
	  position: relative;
	  font-size: 16px;
	  height: 470px;
	   max-width: 320px;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}  
	.btn-group-vertical{
	
	width: 300px
	}
	
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
} 
</style>
	<%@ include file="header.jsp"%>





	<spring:form action="${pageContext.request.contextPath}/getProduct"
		method="POST" modelAttribute="product" enctype="multipart/form-data">
		<div class="container">

			<spring:hidden path="id" />


			<spring:label path="pname">ProductName:</spring:label>
			<spring:input path="pname" placeholder="Enter productName"
				name="pname" />
			<br/>




			<spring:label path="pdesc">ProductDescription:</spring:label>
			<spring:input path="pdesc" placeholder="Enter productDesc"
				name="pdesc" />
			<br/>



			<spring:label path="price">Price:</spring:label>
			<spring:input path="price" placeholder="Enter price" name="price" />
			<br/>
			
			
			<spring:label path="category">
				<b>Category:</b>
			</spring:label>
			<br />
			
			<spring:select path="category.id">

				<spring:option value="0" label="---Select categories---" />

				<spring:options items="${categories}" itemValue="id"
					itemLabel="cname" />
			</spring:select>
			<br />
	<%@ include file="upload.jsp"%>
	<br/>
	
			<div class="btn-group-vertical">
				<button type="submit" class="btn btn-primary btn-lg" >Submit</button>
			</div>

		</div>
	</spring:form>



	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>price</th>
				<th>Category</th>
				<th>file</th>

				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="pro">
				<tr>
					<td>${pro.pname}</td>
					<td>${pro.pdesc}</td>
					<td>${pro.price}</td>
					<td>${pro.category.cname}</td>
					<td>${pro.file}</td>

					<td><a
						href="${pageContext.request.contextPath}/resources/images/${pro.file}.jpg" /></td>
					<td><a
						href="${pageContext.request.contextPath}/getProductForEdit/${pro.id}"
						class="btn btn-primary">Edit</a> <a
						href="${pageContext.request.contextPath}/getProductForDelete/${pro.id}"
						class="btn btn-primary">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
