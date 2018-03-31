
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<style>

	.container,table {
    font-style: oblique;
    font-weight: bold;
    font-size: 16px;
    }

 .container{
	  position: relative;
	  font-size: 16px;
	  height: 380px;
	   max-width: 320px;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	} 
</style>
	<%@ include file="header.jsp"%>
	


	<spring:form action="${pageContext.request.contextPath}/getCategory" method="POST" modelAttribute="category">
		<div class="container">
		
			
				<spring:hidden path="id"/>
			
			
				<spring:label path="cname">CategoryName:</spring:label>
				
				 <spring:input  path="cname" /><br>
			<spring:label path="cdesc">CategoryDescription:</spring:label>
					<spring:input path="cdesc" /> <br>
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
			
				<td>
					<a href="${pageContext.request.contextPath}/getCategoryForEdit/${cat.id}" class="btn btn-primary">Edit</a>
					<a href="${pageContext.request.contextPath}/getCategoryForDelete/${cat.id}" class="btn btn-primary">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>
