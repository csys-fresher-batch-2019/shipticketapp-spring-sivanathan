<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<%
	int amount = (Integer) session.getAttribute("total");
	//String name = (String)request.getAttribute("statement");
	//Integer availableseats = (Integer) session.getAttribute("seats");
%>
<body>
<body style="background-color: Cyan;">

	<form onsubmit="call()">
		<center>
			<h1>total amount</h1>
			total amount:<input type="number" name="amount" value="<%=amount%>" readonly> <br><br>
			
			payment through:<br>
			<br>
			<input type="radio" name="cash" id="credit"  disabled value="credit" id="credit" required>credit card <br>
			<br>
			<input type="radio" name="cash" id="net" disabled value="net" required>net banking
			<br>
			<br>
			<input type="radio" name="cash" id="wallet" value="wallet" required>wallet <br>
			<br>
			

			<button type="submit">confirm</button>
	</form>

	<!-- <button onclick="call()">Confirm</button> -->



	<script>
		function call() {
			event.preventDefault();
			var option = document.getElementById("wallet").value;
			console.log(option);
			/* 
			if (option == "credit") {
				console.log("credit");
				//window.location.href = "credit.jsp";
			} else if (option == "netbanking") {
				console.log("netbanking");
				//window.location.href = "netbanking.jsp";
			} else */ 
			if (option == "wallet") {
				console.log("wallet");
				window.location.href = "wallet.jsp";
			}
		}
	</script>
</body>
</html>