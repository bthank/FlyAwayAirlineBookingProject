<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fly Away Airline Flight Booking Application</title>
</head>
<body>
	<center>
		<h1>Fly Away Airline Flight Booking</h1>
		<h2>Admin Page</h2>
		<br />
	</center>
    <center>
        <h3>
            <a href="/FlyAwayAirlineBookingProject/showAdminHome">Admin Home</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/FlyAwayAirlineBookingProject/new">Add New Flight</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/FlyAwayAirlineBookingProject/listAllFlightsAdmin">List All Flights</a>
             
        </h3>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Master List of Airports</h2></caption>
            <tr>
                <th>Airport</th>
            </tr>
            <c:forEach var="airport" items="${setAirports}">
                <tr>
                    <td><c:out value="${airport}" /></td>                    
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>