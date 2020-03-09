<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<center>
		<h3>admin</h3>
		<body style="background-color: Cyan;">
			<form action="Admin6">
				<br> <br>shipid: <input type="number" name="shipid"
					required autofocus> <br> <br>shipname : <input
					type="name" name="shipname" required /> <br> <br>sourceplace
				: <input type="name" name="sourceplace" required /> <br> <br>destinationplace
				: <input type="name" name="destinationplace" required /> <br>
				<br>total_no_of_seats: <input type="number"
					name="totalnoofseats" required /> <br> <br>classes:<input
					type="name" name="classes" required /> <br> <br>amount:<input
					type="number" name="amount" required /> <br> <br>
				<button type="submit">conform</button>

				<br> <br>
				<button type="reset">reset</button>

			</form>
		</body>
		<jsp:include page="adminlogout.jsp" /></center>
</html>