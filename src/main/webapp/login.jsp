<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
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

<style>
body {
	background-image:
		url('assets/images/alonso-reyes-Ca4XZM3xABg-unsplash.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>
<body>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
		crossorigin="anonymous">
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

	<center>
		<h1>login</h1>
	</center>

	<!-- <h2>
			<br> <br> <a href="register.jsp">create a new
				registration</a> <br> <br> <a href="admin.jsp">admin login</a>
			<br><br><br><a href="wallet.jsp">wallet</a>
		</h2> -->
	<br>
	<br>

	<form action="Login" method="POST">
		<br>Enter userId : <input type="number" name="userid"
			placeholder="Enter valid userId" min="1000" required autofocus /><br>
		<br>Enter password : <input type="password" name="password"
			placeholder="Enter password" required /><br> <br>
		<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
		%>

		<br>
		<button type="submit">Submit</button>
		<br> <br>
		<button type="reset">reset</button>
	</form>


</body>

</html>