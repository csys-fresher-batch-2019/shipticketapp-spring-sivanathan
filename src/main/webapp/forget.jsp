<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>forgetpassword
</title>
</head>
<body>
	<h3>forget password</h3>
<body style="background-color: Cyan;">
	<%
		Integer user_id = (Integer) session.getAttribute("logged");
		Integer journey = (Integer) session.getAttribute("name");
		Integer shipid = (Integer) session.getAttribute("sid");
		Integer availableseats = (Integer) session.getAttribute("seats");
	%>
	<form action="Forget">
		<br>Enter userId : <input type="number" name="userid"
			value="<%=user_id%>" required autofocus /> <br>Enter set
		password : <input type="password" name="password"
			placeholder="Enter new password" required /> <br>
		<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
		%>
		<button type="submit">Submit</button>
		<button type="reset">reset</button>
	</form>
</body>

</html>