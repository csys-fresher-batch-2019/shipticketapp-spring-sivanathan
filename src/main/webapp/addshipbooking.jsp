<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
      <style>
         body {
            background-image: url("assets/images/BLUEPRINT.jpg");
         }
      </style>
</head>

<body>
<h3>shipbooking</h3>
<form >
<body style="background-color: Cyan;">
<img src="assets/images/shiip.jpg"
width="500" height="200"
alt="darbar"
/>
<br>
<br>Enter user_id :  <input type="number" name="user_id" placeholder="Enter number" required />
<br>Enter ship_id :  <input type="number" name="ship_id" placeholder="Enter number" required />
<br>Enter booking_ticket :  <input type="number" name="booking_ticket" placeholder="Enter number" required min="1" max="5"/>
<br>select source_place:  <select name="source_place">
					<option value="select">select</option>
					<option value="corals">corals</option>
					<option value="kaavaratti">kaavaratti</option>
					<option value="amindivi">amindivi</option>
					</select>
<br>select destination_place:  <select name="destination_place">
					<option value="select">select</option>
					<option value="lagoons">lagoons</option>
					<option value="minicoy">minicoy</option>
					<option value="arabiansea">arabiansea</option>
					</select>
<datalist id="source_station list">
<option value="corals"></option>
<option value="kaavaratti">	</option>
<option value="amindivi"></option>
	</datalist>
<datalist id="destination_station list">
<option value="lagoons"></option>
<option value="minicoy">	</option>
<option value="arabiansea"></option>
	</datalist>	   
  

<br>Enter classes : <input type="radio" name="classes" value="VIP"required >VIP 
					<input type="radio" name="classes" value="FIRST_CLASS"required>FIRST_CLASS
					<input type="radio" name="classes" value="SECOND_CLASS"required >SECOND_CLASS 
					  
<br>

<img src="assets/images/ship.jpg"
width="200" height="200"
alt="darbar"
/>
<br>
<button type="submit" >Submit</button>

<button type="reset" >reset</button>

</form>
</body>
<jsp:include page="logout.jsp"/>
</html>