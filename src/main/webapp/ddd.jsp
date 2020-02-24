<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<center>
<form action="ddd" >
<body style="background-color: Cyan;">
<p>ENTER THE JOURNEY DATE  </p>
<br>		journey date: <select date="from date" name="booking">
					<option value="select">select</option>
					<option value="10505">04-01-2020</option>
					<option value="10606">14-01-2020</option>
					</select>
<datalist date="from date">
					<option value="select">select</option>
					<option value="10505">04-01-2020</option>
					<option value="10606">14-01-2020</option>
</datalist>
<!--  <p>ENTER THE JOURNEY DATE TO BOOKING</p>
<br>		select: <select journey from date="from date">
					<option value="select">select</option>
					<option value="02-01-2020">02-01-2020-10202</option>
					<option value="07-01-2020">07-01-2020-10707</option>
					</select>
<datalist date="from date">
					<option value="select">select</option>
					<option value="02-01-2020">02-01-2020-10202</option>
					<option value="07-01-2020">07-01-2020-10707</option>
</datalist>

<br>-->
<br>
	shipid: <input type="number" name="shipid" value="117788" readonly><br>
  <input type="submit" value="Submit">
</form>

</body>
<jsp:include page="logout.jsp"/></center>
</html>

