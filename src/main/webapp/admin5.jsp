<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<center>
		<h3>admin</h3>
		<body style="background-color: Cyan;">
			<form action="Admin5">
				<br> <br>shipid: <input type="number" name="shipid"
					required autofocus> <br>
				<br>availableseats : <input type="number" name="availableseats"
					required /> <br>
				<br>
				<button type="submit">conform</button>

				<br>
				<br>
				<button type="reset">reset</button>

			</form>
		</body>
		<jsp:include page="adminlogout.jsp" /></center>
</html>