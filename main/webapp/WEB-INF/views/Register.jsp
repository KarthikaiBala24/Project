<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Register Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<style>


body { 
  background: url('http://www.publicdomainpictures.net/pictures/50000/velka/flower-meadow.jpg') no-repeat center center fixed; 
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}

.btn-group-vertical{
	
	width: 200px;

	}
   
form{
  max-width: 400px;
  padding: 15px 35px 45px;
  margin: 0 auto;
  background-color: #fff;
  border: 1px solid rgba(0,0,0,0.1);  

  }
 #regForm,#addressForm {
	  position: relative;
	  font-size: 16px;
	  height: 410px;
	   max-width: 320px;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 2;
		}
	}  


</style>
	<%@ include file="header.jsp"%>

	<spring:form action="getData" method="POST"
		modelAttribute="userdetails">
		<div class="container">

			<div id="regForm">
			
			<center> <h3>For New Users!!!</h3></center>

				<spring:label path="username" >Username: </spring:label>
				<spring:input path="username" placeholder="Enter Your UserName"
					name="username" />
				<br>


				<spring:label path="password">Password:</spring:label>
				<spring:input path="password" placeholder="Enter Password"
					name="password" type="password"  />
				<br>

				<spring:label path="Confirmpassword">Confirm Password:</spring:label>
				<spring:input path="Confirmpassword"
					placeholder="Enter Password again" name="Confirmpassword" type="password" />
				<br>


				<spring:label path="emailid">emailid:</spring:label>
				<spring:input path="emailid" placeholder="Enter Your EmailId"
					name="emailid" />
				<br>
				
				<button id="addressBtn" type="button" class="btn btn-info">Click to Enter Address</button>

				<spring:hidden path="id" />
</div>
			
			
			
			<div id="addressForm">
				<spring:label path="address.door">Door No:</spring:label>
				<spring:input path="address.door" placeholder="Enter Your door no"
					name="door" required="true" />

				<spring:label path="address.street">street:</spring:label>
				<spring:input path="address.street"
					placeholder="Enter Your street name" name="street" />
				<spring:label path="address.state">state:</spring:label>
				<spring:input path="address.state" placeholder="Enter Your state"
					name="state" />
				<spring:label path="address.pin">Pin code:</spring:label>
				<spring:input path="address.pin" placeholder="pin code" name="pin" />




				<div class="btn-group-vertical">
					<button type="submit" class="btn btn-primary">Register</button>
				</div>

			</div>
		</div>

	</spring:form>

	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#addressForm').fadeOut();
			
			$('#addressBtn').on('click',function(){
				$('#regForm').hide();
				$('#addressForm').fadeIn(700);
			});
			
		});
	</script>

</body>
</html>