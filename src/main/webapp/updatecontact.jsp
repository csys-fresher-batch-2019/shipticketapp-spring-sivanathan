<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<body>
	<center>
		<h1>update contact number</h1>
		<br>
		<br>

		<form action="UpdateContactNumber">
			<br>Enter userId : <input type="number" name="userid"
				placeholder="Enter valid userId" min="1000" required autofocus /><br>
			<br>Enter contact number : <input type="number" name="contactnumber"
				placeholder="Enter valid phone number" required min ="1111111111" and max="9999999999" /><br> <br>
			
			<br>
			<button type="submit">Submit</button>
			<br> <br>
			<button type="reset">reset</button>
	</center>
	</form>
</body>
</head>
</html>