<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<center>
	<h1>booking</h1>
	<%
		Integer user_id = (Integer)session.getAttribute("logged");
		Integer journey = (Integer) session.getAttribute("name");
		Integer shipid = (Integer) session.getAttribute("sid");
		Integer availableseats = (Integer) session.getAttribute("seats");
	%>
	<form action="Booking2">
	<body style="background-color: Cyan;">
		<br><br>userid: <input type="number" name="userid" value="<%=user_id%>" readonly> 
		<br><br>journeyid: <input type="number" name="journeyid" value="<%=journey%>" readonly>
		<br><br>shipid: <input type="number" name="shipid" value="<%=shipid%>" readonly>
		<br><br>cost_per_ticket : <input type="number" name="cost_per_ticket" value="6000" readonly /> 
		<br><br>ticket_status: <input type="name" name="status" value="pending" readonly />
		<br><br>availableseats : <input type="number" name="availableseats" value="<%=availableseats%>" readonly />
		<br><br>Enter the bookingseats:<input type="number" name="bookingseats" placeholder="Enter the number" required autofocus min="1" max="10" />
<%
String errorMessage=request.getParameter("errorMessage");
if(errorMessage!=null)
{
	out.println("<font color='red'>"+errorMessage+"</font>");
}
%>


		<!--  <br>total_cost : <input type="number" name="total_cost" value="     " readonly />-->

		<br><button type="submit">conform</button>

		<button type="reset">reset</button>

	</form>
</body>
<jsp:include page="logout.jsp"/></center>
</html>