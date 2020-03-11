<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>admin</title>
</head>
<center>
	<body>
	<body style="background-color: Cyan;">
		<h1>admin</h1>
		<form action="Admin">
			<br> <br>Enter admin Id : <input type="number"
				name="admin_id" placeholder="Enter number" required autofocus /> <br>
			<br>Enter password : <input type="password" name="password"
				placeholder="Enter password" required /> <br> <br>
			<button type="submit">Submit</button>
			<br> <br>
			<button type="reset">reset</button>
			<br>
			<%
				String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					out.println("<font color='red'>" + errorMessage + "</font>");
				}
			%>
		
</center>
</form>
</body>

</html>