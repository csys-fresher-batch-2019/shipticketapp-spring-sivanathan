<%@page import="com.chainsys.shipticketbooking.model.ShipDetail"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>index
</title>
</head>
<body>
<body style="background-color: Cyan;">
	<%
		ArrayList<ShipDetail> list = (ArrayList<ShipDetail>) request.getAttribute("id");

		if (list != null) {
	%>
	<center>
		<table border="1">
			<thead>
				<tr>
					<th>S.no</th>
					<th>SHIP ID</th>
					<th>SHIP NAME</th>
					<th>SOURCE PLACE</th>
					<th>DESTINATION PLACE</th>
					<th>TOTAL NO OF SEATS</th>
					<th>CLASSES</th>
					<th>AMOUNT</th>
			</thead>
			<tbody>
				</center>
				<%
					int i = 1;

						for (ShipDetail ship : list) {
				%>

				<tr>
					<td><%=i++%></td>
					<td><%=ship.getShipId()%></td>
					<td><%=ship.getShipName()%></td>
					<td><%=ship.getSourcePlace()%></td>
					<td><%=ship.getDestinationPlace()%></td>
					<td><%=ship.getNoOfSeats()%></td>
					<td><%=ship.getClasses()%></td>
					<td><%=ship.getAmount()%></td>





				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	
</body>
<br>
<a href="index.jsp">next content 
</html>
