<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="pharmacyapp.productDetails.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pharmacyapp.productDetails.ProductImplementation"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="background-color: skyblue">
	<center>
		<h3>ProductList</h3>
	</center>
	<%
		ServiceShipTicket m4 = new ServiceShipTicket();
		ShipDetail s = new ShipDetail();
		String source = request.getParameter("sourceplace");
		String destination = request.getParameter("destinationplace");
		System.out.println(source + "-" + destination);
		s.setSourcePlace(source);
		s.setDestinationPlace(destination);

		List<shipdetails> list = m4.findAllShipDetailWithSourceAndDestination(s);
	%>
	<center>
		<table border="1">
			<thead>
				<tr>
					<th>S.no</th>
					<th>ProductId</th>
					<th>ProductName</th>
					<th>ProductType</th>
					<th>Cost</th>
					<th>Quantity</th>
					<th>ExpiryDate</th>
				</tr>
			</thead>
			<tbody>
				</center>
				<%
					int i = 1;

					for (Product p : list) {
				%>
				<tr>
					<td><%=i++%></td>
					<td><%=p.getProductId()%></td>
					<td><%=p.getProductName()%></td>
					<td><%=p.getProductType()%></td>
					<td><%=p.getCost()%></td>
					<td><%=p.getQuantity()%></td>
					<td><%=p.getExpiryDate()%></td>
					<td><input type="checkbox" name="pid"
						id="pid_<%=p.getProductId()%>"
						onchange="disable(<%=p.getProductId()%>)"
						value="<%=p.getProductId()%>"></td>
					<td><a href="placeorder.jsp?productId=<%=p.getProductId()%>">order</td>
					</a>
				</tr>


				<%
					}
				%>
				<!-- 
Enter ProductId: <input type="number" name="productId"placeholder="Enter productId" required/> -->
				<br />
				<br />
			</tbody>
		</table>
</body>
</html>