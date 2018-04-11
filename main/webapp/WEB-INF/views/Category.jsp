<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<title>Category</title>
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



	<spring:form action="${pageContext.request.contextPath}/getCategory"
		method="POST" modelAttribute="category">
		<div class="container">


			<spring:hidden path="id" />


			<spring:label path="cname">CategoryName:</spring:label>

			<spring:input path="cname" class="form-control"
				placeholder="Enter categoryName" name="cname" />
				<spring:errors path="cname" class="message" />
			<br>
			<spring:label path="cdesc">CategoryDescription:</spring:label>
			<spring:input path="cdesc" class="form-control"
				placeholder="Enter category description" name="cdesc" />
				<spring:errors path="cdesc" class="message" />
			<br>
			<div class="btn-group-vertical">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>

		</div>
	</spring:form>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>

				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categories}" var="cat">
				<tr>
					<td>${cat.cname}</td>
					<td>${cat.cdesc}</td>

					<td><a
						href="${pageContext.request.contextPath}/getCategoryForEdit/${cat.id}"
						class="btn btn-primary">Edit</a> <a
						href="${pageContext.request.contextPath}/getCategoryForDelete/${cat.id}"
						class="btn btn-primary">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


</body>
</html>
