<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<center>
		<h3>admin</h3>
		<form action="Admin4">
			<body style="background-color: Cyan;">
				<br>Enter cost method :
				<input type="radio" name="cost" value="max" required>maximum
				amount
				<br>
				<br>
				<input type="radio" name="cost" value="min" required>minimum
				amount
				<br>
				<br>
				<input type="radio" name="cost" value="avg" required>average
				amount
				<br>
				<br>
				<input type="radio" name="cost" value="sum" required>total
				amount

				<br>
				<br>
				<button type="submit">Submit</button>

				<br>
				<br>
				<button type="reset">reset</button>
		</form>
</body>
<jsp:include page="adminlogout.jsp" /></center>
</html>
