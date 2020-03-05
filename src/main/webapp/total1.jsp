<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<%int amount=(Integer)request.getAttribute("total");
//String name = (String)request.getAttribute("statement");
//Integer availableseats = (Integer) session.getAttribute("seats");
%>
<body>
<body style="background-color: Cyan;">
<form action="ordered1.jsp">
<center>
<h1>total amount</h1>
total amount:<input type="number" name="amount" value="<%=amount %>" readonly >
<br><br>payment through:<br><br><input type="radio" name="cash"value="cc"required autofocus>credit card
				<br><br><input type="radio" name="cash"value="nb"required>net banking
				<br><br><input type="radio" name="cash"value="w"required>wallet
				
<br><br> <button type="submit" >conform</button>
				
</form>
<div
	style="position: absolute; top: 0; right: 0; width: 100px; text-align: right;">

	<jsp:include page="logout.jsp" /></center>
</div>

</body>
</html>