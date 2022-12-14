<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin content</title>
</head>
<body>

<sql:setDataSource
        var="myDB"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/flyaway?useSSL=false"
        user="root" password="1Leanest!"
    />
    
<sql:query var="listItems" dataSource="${myDB}">
        SELECT * FROM flyaway.flightdetails;
</sql:query>

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
<form action="DeleteValueServlet" method="post">
	Enter row id:<input type="number" name="id">
	<input type="submit" name="Submit">
</form>

 <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of destinations</h2></caption>
            <tr>
                <th>ID</th>
                <th>SOURCE</th>
                <th>DESTINATION</th>
                <th>DEPARTURE</th>
                <th>PRICE</th>
                <th>AIRLINES</th>
            </tr>
            <c:forEach var="item" items="${listItems.rows}">
            	
                <tr>
                    <td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.SOURCE}" /></td>
                    <td><c:out value="${item.DESTINATION}" /></td>
                    <td><c:out value="${item.DEPARTURE}" /></td>
                    <td><c:out value="${item.PRICE}" /></td>
                    <td><c:out value="${item.AIRLINES}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>



</body>
</html>