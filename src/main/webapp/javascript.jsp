
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
		url('assets/images/353381.jpg');
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
		<p>ENTER THE SOURCE PLACE</p>
		<br> <select name="sourceplace" id="source">
			<option value="">select</option>
			<option value="amindivi">amindivi</option>
			<option value="lagoons">lagoons</option>
			<option value="kaavaratti">kaavaratti</option>
			<option value="minicoy">minicoy</option>
			<option value="corals">corals</option>
			<option value="arabiansea">arabiansea</option>
			<option value="lakshadeepsea">lakshadeepsea</option>
		</select>


		<p>ENTER THE DESTINATION PLACE</p>
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
		<h1>
			<br>
			<br>
			<a href="index.jsp">next</a>
		</h1>

	</form>

	<div id="container">
		<h3>List Ship API</h3>
		<table border="1" class="table table-bordered">
			<thead>
				<tr>
					<th>S.No</th>
					<th>ShipNumber</th>
					<th>Shipname</th>
					<th>sourceplace</th>
					<th>destinationplace</th>
					<th>amount</th>
					<th>classes</th>
				</tr>
			</thead>
			<tbody id="ShipTbl">
			</tbody>
		</table>
	</div>



	<script>
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
				p
				{
					color: blue;
					row = row + "<tr><td>" + j + "</td><td>" + shipObj.shipId
							+ "</td><td>" + shipObj.shipName + "</td><td>"
							+ shipObj.sourcePlace + "</td><td>"
							+ shipObj.destinationPlace + "</td><td>"
							+ shipObj.amount + "</td><td>" + shipObj.classes
							+ "</td></tr>";
					j = j + 1;
				}
			}
			//alert(row);
			$("#ShipTbl").append(row);
		}
	</script>

</body>
</html>