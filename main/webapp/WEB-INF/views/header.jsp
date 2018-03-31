<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Online Shopping</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<style>

/* Full-width input fields */
input[type=text],input[type=number], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
.container {
    padding: 16px;
}
 .container-fluid, #regForm,#addressForm,
 .form-control,.form-signin{
    font-style: oblique;
     font-family: Lucida Handwriting;
    font-weight: bold;
    font-size: 16px;
    }
    
    
.responsive {
    width: 100%;
    height: auto;
}
</style>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
			<a  class="navbar-brand"  class ="active" href="${pageContext.request.contextPath }/">Online Shopping <span class="glyphicon glyphicon-home" ></span></a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath }/Register">Register</a></li>
				<li><a href="${pageContext.request.contextPath }/Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<li><a href="${pageContext.request.contextPath }/Product">Product</a></li>

				<li><a href="${pageContext.request.contextPath }/Category">Category</a></li>
	


			</ul>
		</div>
	</nav>


</body>
</html>