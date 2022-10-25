<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin content</title>
</head>
<body>

<h1>Admin contents:</h1>

<h2>Added package:</h2>
<form action="InsertValueServlet" method="post">
	Enter source:<input type="text" name="source">
	Enter destination:<input type="text" name="destination">
	Enter departure: <input type="date" name="departure">
	Enter price: <input type="number" name="price">
	Enter airline: <input type="text" name="airlines">
	<input type="submit" name="Submit">
</form>

<h2>Delete package:</h2>
<form action="DeleteDataServlet" method="get">
	Enter source:<input type="text" name="source">
	Enter destination:<input type="text" name="destination">
	Enter departure: <input type="date" name="departure">
	Enter price: <input type="number" name="price">
	Enter airline: <input type="text" name="airline">
	<input type="submit" name="Submit">
</form>

</body>
</html>