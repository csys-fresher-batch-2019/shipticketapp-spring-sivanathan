<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<body style="background-color: Cyan;">
	<form action="aaa">
		<center>
			<p>ENTER THE JOURNEY DATE</p>
			<br> journey date: <select date1="from date" name="booking">
				<option value="select">select</option>
				<option value="10202">01-01-2020</option>
				<option value="10707">11-01-2020</option>
			</select>
			<datalist date1="from date">
				<option value="select">select</option>
				<option value="10202">01-01-2020</option>
				<option value="10707">11-01-2020</option>
			</datalist>
			<!--  
  <p>ENTER THE JOURNEY DATE TO BOOKING</p>
<br>		select: <select date2="from date">
					<option value="select">select</option>
					<option value="2020-01-02">02-01-2020-10202</option>
					<option value="2020-01-12">12-01-2020-10707</option>
					</select>
<datalist date2="from date">
					<option value="select">select</option>
					<option value="2020-01-02">02-01-2020-10202</option>
					<option value="2020-01-12">12-01-2020-10707</option>
</datalist>

<br>-->
			<br>
			<br> shipid: <input type="number" name="shipid" value="112233"
				readonly><br>
			<br> <input type="submit" value="Submit">
	</form>

</body>
<jsp:include page="logout.jsp" /></center>
</html>

