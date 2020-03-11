<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>totalbooking</title>
</head>
<body>
	<%
		Integer value = (Integer) request.getAttribute("totalbooking");
	%>
	<h3>booking details</h3>
	<form>
		<body style="background-color: Cyan;">
			<br>
			<p>
				amount is
				<%=value%></p>
	</form>
</body>
<jsp:include page="logout.jsp" />
</html>
