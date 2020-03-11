<%@page import="com.chainsys.shipticketbooking.model.Journey"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<head>
<title>next</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<center>
	<body>
		<h2>ship details</h2>

		<table border="1">
			<thead>
				<tr>
					<th>S.no</th>
					<th>journey ID</th>
					<th>source date</th>
					<th>destination</th>
					<th>shipId</th>
					<th>seat</th>
			</thead>
			<tbody>
				<%
					ArrayList<Journey> list = (ArrayList<Journey>) session.getAttribute("journey12");

					if (list != null) {
						int i = 1;

						for (Journey ship : list) {
				%>

				<tr>
					<td><%=i++%></td>
					<td><%=ship.getJourneyId()%></td>
					<td><%=ship.getSourceDate()%></td>
					<td><%=ship.getDestinationDate()%></td>
					<td><%=ship.getShipId()%></td>
					<td><a
						href="Next1?journeyid=<%=ship.getJourneyId()%>&shipid=<%=ship.getShipId()%>">click</a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	
	<body style="background-color: Cyan;">




		<br>
		<br>
		<a href="forget.jsp">Reset Password </a>


	</body>
</center>
<div
	style="position: absolute; top: 0; right: 0; width: 100px; text-align: right;">

	<jsp:include page="logout.jsp" />
	</center>
</div>

</html>