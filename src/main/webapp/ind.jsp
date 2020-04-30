<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>INDEX</title>
</head>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">

	<a class="navbar-brand" href="ind.jsp">HOME</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="register.jsp">REGISTRATION<span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item"><a class="nav-link" href="login.jsp">LOGIN</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="admin.jsp">ADMIN</a>
			</li>
			<li class="nav-item"><a class="nav-link disabled" href="#">CONTACT
					NUMBER</a></li>
		</ul>
	</div>
</nav>
<div id="carouselExampleIndicators" class="carousel slide"
	data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#carouselExampleIndicators" data-slide-to="0"
			class="active"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
		<div class="carousel-item active">
			<img class="d-block w-100"
				src="assets/images/ship_sea_sky_sail_wave_96342_3840x2400.jpg"
				alt="First slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="assets/images/369448.jpg"
				alt="Second slide">
		</div>
		<div class="carousel-item">
			<img class="d-block w-100" src="assets/images/842292.jpg"
				alt="Third slide">
		</div>
	</div>
	<a class="carousel-control-prev" href="#carouselExampleIndicators"
		role="button" data-slide="prev"> <span
		class="carousel-control-prev-icon" aria-hidden="true"></span> <span
		class="sr-only">Previous</span>
	</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
		role="button" data-slide="next"> <span
		class="carousel-control-next-icon" aria-hidden="true"></span> <span
		class="sr-only">Next</span>
	</a>
</div>
<center>
	<h1>WELCOME TO MY SHIPTICKET BOOKING</h1>
</center>
<!-- <style>
body {
	background-image:
		url('assets/images/ship_sea_sky_sail_wave_96342_3840x2400.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}
</style> -->

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
<body style="background-color: Cyan;">
	<form onsubmit="viewShip()">

		<h5>ENTER THE SOURCE PLACE:</h5>
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


		<h5>
			<br>ENTER THE DESTINATION PLACE:
		</h5>
		<select name="destinationplace" id="destination">
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


	<div id="alert" class="alert alert-warning alert-dismissible fade show"
		role="alert">
		<strong>WELCOME!..</strong><br> You should check in on some of
		those fields below.
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div id="container">


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
	<!-- <div
		style="position: absolute; top: 0; right: 0; width: 200px; text-align: center;">

		<h1>
			<button  onclick=<a href="index.jsp">main</a>></button>
			<button class="btn btn-primary btn-lg btn-block" onclick="index()">main</button>
			<br>
		</h1>
	
 -->

	<!-- java script -->
	<script>
		function index()

		{
			window.location.href = "index.jsp";
		}

		/* 		
		 * it is used for not to go back to front page
		 window.history.forward();

		 function noBack() {
		 window.history.forward();
		 } */

		function nextpage() {
			window.location.replace("http://localhost:9000/index.jsp")
		}
		$("#alert").hide();
		$("#container").hide();
		function viewShip() {
			event.preventDefault();
			$("#container").hide();
			//Step 1: Get form values 
			var source = $("#source").val();//using jquery
			// var source = document.getElementById("source").value;
			var destination = document.getElementById("destination").value;//using javascript

			if ((source == "")) {
				alert("enter the correct source place ");
				//$("#container").hide();

			} else if ((destination == "")) {
				alert("enter the correct destination place ");
			} else if (source == destination) {
				alert("invalid selection");
				alert("sourceplace and destinationplace should not be same");
			} else {
				$("#alert").show();
				//alert("viewShip" + source + destination );

				//Step 2: Perform ajax call
				//let url = "http://localhost:9000/api/getShip?destination=lagoons&source=amindivi";
				let url = "http://localhost:9000/api/getShip?destination="
						+ destination + "&source=" + source;
				//console.log(url);
				$.getJSON(url, function(response) {//for get method this is used
					//$.post(url,function(response)) for post method this is used
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

				row = row + "<tr><td>" + j + "</td><td>" + shipObj.shipId
						+ "</td><td>" + shipObj.shipName + "</td><td>"
						+ shipObj.sourcePlace + "</td><td>"
						+ shipObj.destinationPlace + "</td><td>"
						+ shipObj.amount + "</td><td>" + shipObj.classes
						+ "</td></tr>";
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