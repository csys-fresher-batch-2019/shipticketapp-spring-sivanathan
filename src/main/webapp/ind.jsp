
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<center>
	<h1>WELCOME TO MY SHIPTICKET BOOKING</h1>
</center>
<style>
body {
	background-image:
		url('assets/images/ship_sea_sky_sail_wave_96342_3840x2400.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style>

<body>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
		crossorigin="anonymous">
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

	<form onsubmit="viewShip()">
		<p><br><br><h5>ENTER THE SOURCE PLACE</h5></p>
		<br> <select name="sourceplace" id="source">
			<!--  <option <!-- <span id="span"></span> value="">select</option>-->
			<option value="">select</option>
			<option value="amindivi">amindivi</option>
			<option value="lagoons">lagoons</option>
			<option value="kaavaratti">kaavaratti</option>
			<option value="minicoy">minicoy</option>
			<option value="corals">corals</option>
			<option value="arabiansea">arabiansea</option>
			<option value="lakshadeepsea">lakshadeepsea</option>
		</select>


		<p><br><br><h5>ENTER THE DESTINATION PLACE</h5></p>
		<br> <select name="destinationplace" id="destination">
			<option value="">select</option>
			<option value="amindivi">amindivi</option>
			<option value="lagoons">lagoons</option>
			<option value="kaavaratti">kaavaratti</option>
			<option value="minicoy">minicoy</option>
			<option value="corals">corals</option>
			<option value="arabiansea">arabiansea</option>
			<option value="lakshadeepsea">lakshadeepsea</option>
		</select>

		<button type="submit">Search</button>
		<button type="reset">reset</button>

	</form>


	<div id="container">
		<h3>SHIP LIST</h3>

		<table border="1" class="table table-bordered">
			<thead>
				<tr>
					<th><h2>S.No</h2></th>
					<th><h2>ShipNumber</h2></th>
					<th><h2>Shipname</h2></th>
					<th><h2>sourceplace</h2></th>
					<th><h2>destinationplace</h2></th>
					<th><h2>amount</h2></th>
					<th><h2>classes</h2></th>
				</tr>
			</thead>
			<tbody id="ShipTbl">
			</tbody>
		</table>
	</div>
	<div
		style="position: absolute; bottom: 0; right: 0; width: 100px; text-align: right;">

		<h1>
			<!-- <button  onclick=<a href="index.jsp">main</a>></button> -->
			<button onclick="index()">main</button>
			<br>
		</h1>
	</div>


	<!-- java script -->
	<script>
		function index() {
			window.location.href = "index.jsp";
		}

		window.history.forward();

		function noBack() {
			window.history.forward();
		}

		function nextpage() {
			window.location.replace("http://localhost:9000/index.jsp")
		}
		$("#container").hide();
		function viewShip() {
			event.preventDefault();
			$("#container").hide();
			//Step 1: Get form values 
			var source = $("#source").val();//using jquery
			// var source = document.getElementById("source").value;//using javascript
			var destination = document.getElementById("destination").value;

			if ((source == "")) {
				alert("enter the correct source place ");
				//$("#container").hide();

			} else if ((destination == "")) {
				alert("enter the correct destination place ");
			} else if (source == destination) {
				alert("invalid selection");
				alert("sourceplace and destinationplace should not be same");
			} else {
				//alert("viewShip" + source + destination );

				//Step 2: Perform ajax call
				//let url = "http://localhost:9000/api/getShip?destination=lagoons&source=amindivi";
				let url = "http://localhost:9000/api/getShip?destination="
						+ destination + "&source=" + source;
				//console.log(url);
				$.getJSON(url, function(response) {
					$("#container").show();
					var ShipList = response;
					//alert(JSON.stringify(response));
					getShip(ShipList);
				});
				return true;
			}
		}
		function getShip(ShipList) {

			$("#ShipTbl").empty();
			var row = "";
			var j = 1;
			for (var i = 0; i < ShipList.length; i++) {

				var shipObj = ShipList[i];

				row = row + "<tr><td><h3>" + j + "</h3></td><td><h3>"
						+ shipObj.shipId + "</h3></td><td><h3>"
						+ shipObj.shipName + "</h3></td><td><h3>"
						+ shipObj.sourcePlace + "</h3></td><td><h3>"
						+ shipObj.destinationPlace + "</h3></td><td><h3>"
						+ shipObj.amount + "</h3></td><td><h3>"
						+ shipObj.classes + "</h3></td></tr><h3>";
				j = j + 1;

			}
			//alert(row);
			$("#ShipTbl").append(row);
		}

		/* 		function btnDisable(){
		 $("#span").append("diabled");
		 } */
	</script>

</body>
</html>