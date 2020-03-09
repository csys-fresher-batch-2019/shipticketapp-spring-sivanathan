<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	int amount = (Integer) session.getAttribute("total");
	//String name = (String)request.getAttribute("statement");
	//Integer availableseats = (Integer) session.getAttribute("seats");
%>
<body>
	<center>
		<form action="Wallet">
			<br> <br>Enter the phone number:<input type="tel"
				id="phone" name="MobileNo" pattern="[0-9]{3}[0-9]{3}[0-9]{4}"
				placeholder="enter valid phone number" required> </br> <br>
			<br>Enter the merchant id:<input type="name" name="merchantId"
				placeholder="enter the valid merchant id" required> <br>
			<br>Enter the amount:<input type="number" name="amount"
				value="<%=amount%>" readonly> <br> <br>
			<button type="submit">submit</button>
	</center>
	</form>
</body>
</html>