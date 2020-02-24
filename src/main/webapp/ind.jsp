<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<center><h1>WELCOME TO MY SHIPTICKET BOOKING</h1></center>
<style>
body {
  background-image: url('assets/images/maximilian-weisbecker-Esq0ovRY-Zs-unsplash.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 100% 100% ;
}

</style>

<body>

<h2>View ship details</h2>

<form action="Ind">

<p>ENTER THE SOURCE PLACE</p>
		<br>  <select source_place="sourceplace" name="sourceplace">
			<option value="select">select</option>
			<option value="amindivi">amindivi</option>
			<option value="lagoons">lagoons</option>
			<option value="kaavaratti">kaavaratti</option>
			<option value="minicoy">minicoy</option>
			<option value="corals">corals</option>
			<option value="arabiansea">arabiansea</option>
			<option value="lakshadeepsea">lakshadeepsea</option>
		</select>
		<datalist date1="from date">
			<option value="select">select</option>
			<option value="amindivi">amindivi</option>
			<option value="lagoons">lagoons</option>
			<option value="kaavaratti">kaavaratti</option>
			<option value="minicoy">minicoy</option>
			<option value="corals">corals</option>
			<option value="arabiansea">arabiansea</option>
			<option value="lakshadeepsea">lakshadeepsea</option>
		</datalist>
		

<p>ENTER THE DESTINATION PLACE</p>
		<br>  <select destination_place="destinationplace" name="destinationplace">
			<option value="select">select</option>
			<option value="amindivi">amindivi</option>
			<option value="lagoons">lagoons</option>
			<option value="kaavaratti">kaavaratti</option>
			<option value="minicoy">minicoy</option>
			<option value="corals">corals</option>
			<option value="arabiansea">arabiansea</option>
			<option value="lakshadeepsea">lakshadeepsea</option>
		</select>
		<datalist date1="from date">
			<option value="select">select</option>
			<option value="amindivi">amindivi</option>
			<option value="lagoons">lagoons</option>
			<option value="kaavaratti">kaavaratti</option>
			<option value="minicoy">minicoy</option>
			<option value="corals">corals</option>
			<option value="arabiansea">arabiansea</option>
			<option value="lakshadeepsea">lakshadeepsea</option>
		</datalist><br>				

<br>
<br
><button type="submit" >Submit</button>

<button type="reset" >reset</button>
<br><br><a href="index.jsp">next</a>

</form>
</body>
</html>

		
		