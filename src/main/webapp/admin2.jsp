<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<body>
<center>
	<h3>admin</h3>
	<%
		HttpSession session1 = request.getSession();
		Integer booking = (Integer) session1.getAttribute("count");
	%>
	<form>
	<body style="background-color: Cyan;">
		<br><br>total no of booking:<input type="number" name="booking"
			value="<%=booking%>" readonly />


	</form>
</body>
</head>
<jsp:include page="adminlogout.jsp"/></center>
</html>