<%@page import="com.chainsys.journey.Journey"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
	<h2>ship details</h2>

<table border="1">
<thead><tr><th>S.no</th> <th>journey ID</th> <th>source date</th> <th>destination</th> <th>shipId</th> <th>seat</th></thead>
<tbody>
<%
ArrayList<Journey>list=(ArrayList<Journey>)session.getAttribute("journey12");

if (list != null){
	%>


<%
int i=1;

for(Journey ship: list)
{%>	
	
	<tr>
	<td><%= i++ %></td>
	<td><%=ship.getJourneyId()%></td>
	<td><%=ship.getSourceDate()%></td>
	<td><%=ship.getDestinationDate()%></td>
	<td><%=ship.getShipId()%></td>
	<td><a href="Next1?journeyid=<%=ship.getJourneyId()%>&shipid=<%=ship.getShipId()%>">click</a></td>
	</tr>
	<%}%> 	
	</tbody>
</table>
<%} %>

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
  <br><a href="forget.jsp">Reset Password
</a>


</body>
<jsp:include page="logout.jsp"/></center>
</html>