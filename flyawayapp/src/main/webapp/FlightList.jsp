<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flights List</title>
</head>
<body>
<sql:setDataSource
        var="myDB"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/flyaway?useSSL=false"
        user="root" password="1Leanest!"
/>
    
    
<%
	 String source = request.getParameter("source");
	 String destination = request.getParameter("destination");
%>

<sql:query var="listItems" dataSource="${myDB}">
		SELECT * FROM flyaway.flightdetails
		WHERE SOURCE= '<%=source %>';
</sql:query>

<h1>Flights list are as follows:</h1>

<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of destinations:</h2></caption>
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
    
<div>
	<form action="UserInfo.jsp" method="get">
		Enter id to select the trip:<input type="number" name="id">
		<input type="submit" name="submit">
	</form>

</div>


</body>
</html>