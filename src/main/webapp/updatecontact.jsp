<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>updatecontactnumber</title>
</head>
<body>
	<center>
		<h1>update contact number</h1>
		<br> <br>
		<%
			Integer user_id = (Integer) session.getAttribute("logged");
			Integer journey = (Integer) session.getAttribute("name");
			Integer shipid = (Integer) session.getAttribute("sid");
			Integer availableseats = (Integer) session.getAttribute("seats");
		%>
		<form action="UpdateContactNumber">
			<br>Enter userId : <input type="number" name="userid"
				value="<%=user_id%>" /><br> <br>Enter contact number : <input
				type="number" name="contactnumber"
				placeholder="Enter valid phone number" required min="1111111111" and
				max="9999999999" /><br> <br> <br>
			<button type="submit">Submit</button>
			<br> <br>
			<button type="reset">reset</button>
	</center>
	</form>
</body>

</html>