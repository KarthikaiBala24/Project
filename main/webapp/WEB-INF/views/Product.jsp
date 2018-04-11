<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8" class="container">
				<spring:form action="${pageContext.request.contextPath}/getProduct"
					method="POST" modelAttribute="product"
					enctype="multipart/form-data">
					<div>

						<spring:hidden path="id" />


						<spring:label path="pname">ProductName:</spring:label>
						<spring:input path="pname" class="form-control"
							placeholder="Enter productName" name="pname" />
							<spring:errors path="pname" class="message" />
						<br />




						<spring:label path="pdesc">ProductDescription:</spring:label>
						<spring:input path="pdesc" class="form-control"
							placeholder="Enter productDesc" name="pdesc" />
							<spring:errors path="pdesc" class="message" />
						<br />



						<spring:label path="price">Price:</spring:label>
						<spring:input path="price" class="form-control"
							placeholder="Enter price" name="price" />
							<spring:errors path="price" class="message" />
						<br />


						<spring:label path="category">
							<b>Category:</b>
						</spring:label>
						<br />

						<spring:select path="category.id" class="form-control">

							<spring:option value="0" label="---Select categories---" />

							<spring:options items="${categories}" itemValue="id"
								itemLabel="cname" />
								<spring:errors path="category" class="message" />
						</spring:select>
						<br /> <br />

						<div class="btn-group-vertical">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>

					</div>
				</spring:form>

			</div>
			<div class="col-sm-2"></div>
		</div>

	</div>

	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Image Upload</h4>
				</div>
				<div class="modal-body">
					<div class="container">
						<%@ include file="upload.jsp"%>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

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
				<c:forEach items="${products}" var="pro">
					<tr>
						<td>${pro.pname}</td>
						<td>${pro.pdesc}</td>
						<td>${pro.price}</td>
						<td>${pro.category.cname}</td>
						<td><img class="img-thumbnail" alt=""
							src="${pageContext.request.contextPath}/resources/images/${pro.id}.jpg">
						</td>
						<td><a
							href="${pageContext.request.contextPath}/getProductForEdit/${pro.id}"
							class="btn btn-primary">Edit</a> <a
							href="${pageContext.request.contextPath}/getProductForDelete/${pro.id}"
							class="btn btn-primary">Delete</a> <a class="btn btn-info"
							href="${pageContext.request.contextPath}/getProductFor/Upload/${pro.id}">Add Image</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$(setTimeout(function() {
				var path = window.location.href;
				if (path.indexOf('Upload') > -1) {
					$('#myModal').modal('show');
				}
			}, 800));
		});
	</script>
</body>
</html>
