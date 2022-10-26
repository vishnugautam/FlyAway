<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Info</title>
</head>
<body>

<sql:setDataSource
        var="myDB"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/flyaway?useSSL=false"
        user="root" password="1Leanest!"
/>

<%
	String id = request.getParameter("id");

%>

<sql:query var="listItems" dataSource="${myDB}">
		SELECT * FROM flyaway.flightdetails
		WHERE id= '<%=id %>';
</sql:query>

	<div>
	
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Your trip details:</h2></caption>
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
    
		<form action="confirmationPage.jsp" method="post">
			Enter passenger name: <input type="text" name="passenger">
			Enter passenger age: <input type="number" name="age">
			Enter passenger email: <input type="email" name="email">
			Enter passenger address: <textarea rows="2" cols="2" name="address"></textarea>
			Enter payment method:
			<input type="radio" id="gpay">
			<label for="gpay">Google pay</label>
			<input type="radio" id="debitcard">
			<label for="debitcard">Debit card</label>
			<input type="radio" id="creditcard">
			<label for="creditcard">Credit card</label>
			<input type="submit" value="submit">
		</form>
	
	</div>
</body>
</html>