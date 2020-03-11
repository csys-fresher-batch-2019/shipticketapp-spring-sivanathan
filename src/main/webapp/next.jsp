<%@page import="com.chainsys.shipticketbooking.model.ShipDetail"%>
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
		<p>ENTER THE SEAT FOR BOOKING</p>
		<h2>shipdetails</h2>


		<table border="1">
			<thead>
				<tr>
					<th>S.NO</th>
					<th>SHIP ID</th>
					<th>SHIP NAME</th>
					<th>SOURCE PLACE</th>
					<th>DESTINATION PLACE</th>
					<th>CLASSES</th>
					<th>AMOUNT</th>
					<th>SEAT</th>
			</thead>
			<tbody>
				<c:forEach var="p" items="${ship}">
					<%
						//ArrayList<ShipDetail> list = (ArrayList<ShipDetail>) session.getAttribute("ship");
							ArrayList<ShipDetail> list = new ArrayList<ShipDetail>();
							if (list != null) {

								int i = 1;

								//		for (ShipDetail ship : list) 
								//{
					%>

					<tr>
						<td><%=i++%></td>
						<td>${p.getShipId()}</td>
						<td>${p.getShipName()}</td>
						<td>${p.getSourcePlace()}</td>
						<td>${p.getDestinationPlace()}</td>
						<td>${p.getClasses()}</td>
						<td>${p.getAmount()}</td>
						<td><a href="Next?shipid=${p.getShipId()}">click</a></td>
					</tr>
					<%
						}
					%>
				
			</tbody>
			</c:forEach>
		</table>
	<body style="background-color: Cyan;">



		<!--  	
<table style="width:100%">
  <tr>
    <th>SHIP ID</th>
    <th>SHIP NAME</th> 
    <th>SOURCE PLACE</th>
    <th>DESTINATION PLACE</th>
    <th>TOTAL NO OF SEATS</th>
    <th>CLASSES</th>
    <th>AMOUNT</th>
    
  </tr>
  <tr>
    <td><a href="aaa.jsp?shipid=112233">112233</td>
    <td>aaa ship</td>
    <td>amindivi</td>
    <td>lagoons</td>
    <td>200</td>
    <td>first class</td>
    <td>5000</td>
  </tr>
  <tr>
    <td><a href="bbb.jsp?shipid=114455">114455</a></td>
    <td>bbb ship</td>
    <td>kaavaratti</td>
    <td>minicoy</td>
    <td>100</td>
    <td>vip</td>
    <td>6000</td>  </tr>
  <tr>
    <td><a href="ccc.jsp?shipid=116677">116677</td>
    <td>ccc ship</td>
    <td>corals</td>
    <td>arabiansea</td>
    <td>150</td>
    <td>second class</td>
    <td>4000</td>
  </tr>
  <tr>
    <td><a href="ddd.jsp?shipid=117788">117788</td>
    <td>ddd ship</td>
    <td>amindivi</td>
    <td>arabiansea</td>
    <td>200</td>
    <td>second class</td>
    <td>3000</td>
  </tr>
  <br>
  
</table>-->
		<br>
		<a href="updatecontact.jsp">update contact number</a>
		<br>
		<br>
		<a href="forget.jsp">Reset Password </a>


	</body>
	<jsp:include page="logout.jsp" />
</center>
</html>