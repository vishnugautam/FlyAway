<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>
<%@include file="header.html" %>
<form action="ValidationFilter" method="get">
	Enter the source: <input type="text" name="source"><br>
	Enter the destination: <input type="text" name="destination"><br>
	Enter departure date: <input type="date" name="departure"><br>
	<input type="submit" value="Submit">
</form>

<%@include file="footer.html" %>

</body>
</html>