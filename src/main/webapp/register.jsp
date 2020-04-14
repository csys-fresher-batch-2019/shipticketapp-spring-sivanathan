<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>registration</title>
</head>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">

	<a class="navbar-brand" href="ind.jsp">HOME</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="register.jsp">REGISTRATION<span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="login.jsp">LOGIN</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="admin.jsp">ADMIN</a>
			</li>
			<li class="nav-item"><a class="nav-link disabled" href="#">CONTACT
					NUMBER</a></li>
		</ul>
	</div>
</nav>

<body>
	<center>
		<h1>Registration</h1>
	</center>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
		crossorigin="anonymous">
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
<body style="background-color: Cyan;">
	<form action="registration">
		<br> <br>Enter Name : <input type="text" name="name"
			placeholder="Enter Name" required autofocus /> <br> <br>Enter
		userId : <input type="number" name="userId" placeholder="Enter number"
			min="1000" required autofocus /> <br> <br>Enter dob : <input
			type="date" name="dob" placeholder="Enter dob" min="1950-01-01"
			max="2020-02-01" /> <br> <br>Enter contact number : <input
			type="tel" id="phone" name="contactnumber"
			pattern="[0-9]{3}[0-9]{3}[0-9]{4}" required> </br> <br> <br>Enter
		gender : <input type="radio" name="gender" value="M" required>male
		<input type="radio" name="gender" value="F" required>female <br>
		<br>Enter password : <input type="password" name="password"
			placeholder="Enter password" required /> <br> <br>Enter
		email : <input type="email" name="email" placeholder="Enter email"
			required /> <br> <br>
		<button type="submit">Submit</button>
		<br> <br>
		<button type="reset">reset</button>
		<br> <br>
	</form>
</body>
</html>