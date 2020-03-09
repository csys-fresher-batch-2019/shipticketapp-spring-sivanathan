<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
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
	<center>
		<h1>login</h1>

		<h2>
			<br>
			<br>
			<a href="register.jsp">create a new registration</a> <br>
			<br>
			<a href="admin.jsp">admin login</a>
			<!-- <br><br><br><a href="wallet.jsp">wallet</a> -->
		</h2>
		<br>
		<br>

		<form action="Login">
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
	</center>
	</form>
</body>
</head>
</html>