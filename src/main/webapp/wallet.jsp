<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Wallet">
Enter the phone number:<input type="tel" id="phone" name="MobileNo"
      pattern="[0-9]{3}[0-9]{3}[0-9]{4}"
      required> </br>
 Enter the merchant id:<input type="name" name="merchantId"  placeholder="enter the valid merchant id" required>
 Enter the amount:<input type="number" name="amount" placeholder="enter the amount" required>
 <button type="submit">submit</button>
</form>
</body>
</html>