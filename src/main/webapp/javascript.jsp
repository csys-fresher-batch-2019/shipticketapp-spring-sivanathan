<html>
<head>
<body>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
	
<form onsubmit="viewShip()"> 
<p>ENTER THE SOURCE PLACE</p>
		<br>  <select source_place="sourceplace" name="sourceplace" id="source">
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
		<br>  <select destination_place="destinationplace" name="destinationplace" id="destination">
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
		<button type="submit" >Search</button>
		
</form>
<div id="container">
    <h3>List Ship API</h3>
<table border="1" class="table table-bordered">
	<thead><tr><th>S.No</th><th>ShipNumber</th><th>Shipname</th><th>sourceplace</th><th>destinationplace</th><th>Seats</th><th>classes</th><th>amount</th></tr></thead>
	<tbody id="ShipTbl">
	</tbody>
</table>
</div>
<script>
	function viewShip(){
		event.preventDefault();
		//Step 1: Get form values 
		var source = document.getElementById("source").value;
		var destination = document.getElementById("destination").value;
		alert("viewShip" + source + destination );
		
		//Step 2: Perform ajax call
		//let url = "http://localhost:9000/api/getShip?destination=lagoons&source=amindivi";
		let url = "http://localhost:9000/api/getShip?destination="+destination+"&source="+source;
		console.log(url);
		$.getJSON(url, function(response) {
			var ShipList = response;
			alert(JSON.stringify(response));
			getShip(ShipList);
		});
		return true;
	}
	function getShip(ShipList){
		$("#ShipTbl").empty();
		var row = "";
		var j=1;
		for ( var i=0; i<ShipList.length; i++) {
			j=j+1;
			var shipObj = ShipList[i];
			row = row + "<tr><td>"+j+"</td><td>" + shipObj.shipId + "</td><td>" + shipObj.shipName + "</td><td>" + shipObj.sourcePlace + "</td><td>" + shipObj.destinationPlace + "</td><td>" + shipObj.noOfSeats + "</td><td>" + shipObj.amount + "</td><td>" +shipObj.classes +"</td></tr>";
				
			}
		alert(row);
		$("#ShipTbl").append(row);
	}
</script>
</body>
</head>
</html>