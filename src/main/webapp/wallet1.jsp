<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Integer walamount1 = (Integer) request.getAttribute("api1");
	String walamount2 = (String) request.getAttribute("api2");
	String walamount3 = (String) request.getAttribute("api3");
	Integer userid = (Integer) session.getAttribute("logged");
	//String name = (String)request.getAttribute("statement");
	//Integer availableseats = (Integer) session.getAttribute("seats");
%>

<body>
	<form action="Wallet1">
		<br>
		<br>user_id:<input type="number" name="user_id"
			value="<%=userid%>"> <br>
		<br>transaction id:<input type="number" name="transaction_id"
			value="<%=walamount1%>"> <br>
		<br>status:<input type="text" name="status"
			value="<%=walamount2%>"> <br>
		<br>errorMessage:<input type="text" name="errorMessages"
			value="<%=walamount3%>">
			<button type="submit">confirm</button>
	</form>
</body>
</html>