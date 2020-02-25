<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	
</head>
<body>
<form action="Admin7">
				<br>
				<br>shipid: <input type="number" name="shipid" required
					autofocus> <br>
				<br>journeyid : <input type="name" name="journeyid" required />
				<br>
				<br>sourcedate : <input type="date" name="sourcedate"
					required /> <br>
				<br>destinationdate : <input type="date"
					name="destinationdate" required /> <br>
				
				<button type="submit">conform</button>

				<br>
				<br>
				<button type="reset">reset</button>

			</form>

</body>
<jsp:include page="adminlogout.jsp" /></center>
</html>