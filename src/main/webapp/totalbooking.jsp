<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<%
Integer value=(Integer)request.getAttribute("totalbooking");
%>
<h3>booking details</h3>
<form >
<body style="background-color: Cyan;">
<br>
<p>amount is <%= value%></p>				


</form>
</body>
<jsp:include page="logout.jsp"/>
</html>					  
