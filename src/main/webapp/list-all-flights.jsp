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
             
        </h3>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Flights</h2></caption>
            <tr>
                <th>Id</th>
                <th>Departure Date</th>
                <th>Airline</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Price</th>
                <th>Available Seats</th>
                <th>Action</th>
            </tr>
            <c:forEach var="flight" items="${listFlight}">
                <tr>
                    <td><c:out value="${flight.id}" /></td>
                    <td><c:out value="${flight.departureDate}" /></td>
                    <td><c:out value="${flight.airline}" /></td>
                    <td><c:out value="${flight.sourceAirport}" /></td>
                    <td><c:out value="${flight.destinationAirport}" /></td>
                    <td><c:out value="${flight.fare}" /></td>
                    <td><c:out value="${flight.numberAvailableSeats}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${flight.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${flight.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>