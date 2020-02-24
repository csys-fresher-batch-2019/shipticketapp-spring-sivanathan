<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

<body>
<h3>forget password</h3>
<body style="background-color: Cyan;">
<form action="Forget">
<br>Enter userId :  <input type="number" name="userid" placeholder="Enter valid userId" required autofocus />
<br>Enter set password :  <input type="password" name="password" placeholder="Enter new password" required />
<br>
<%
String errorMessage=request.getParameter("errorMessage");
if(errorMessage!=null)
{
	out.println("<font color='red'>"+errorMessage+"</font>");
}
%>
 <button type="submit" >Submit</button>
<button type="reset" >reset</button>
</form>
</body>
</head>
</html>