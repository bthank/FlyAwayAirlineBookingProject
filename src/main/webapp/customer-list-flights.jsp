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
		<h2>Customer Booking</h2>
		<br />
	</center>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h3>List of Available Flights</h3></caption>
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
                        <a href="/book?id=<c:out value='${flight.id}' />">Book Flight</a>            
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>