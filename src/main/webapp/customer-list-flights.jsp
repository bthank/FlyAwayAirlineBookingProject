<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fly Away Airline Flight Booking Application</title>
       
     <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    
    <style>
    	.align-right {
    		text-align: right;
    	}
    </style>
	<style>
		body {
			background-color: lightblue;
		}
	</style>
    
</head>
<body>
	<center>
		<h1>Fly Away Airline Flight Booking</h1>
		<h2>Customer Booking</h2>
		<br />
	</center>

    <div align="center">
     <caption><h3>List of Available Flights</h3></caption>
        <table border="1" cellpadding="5" class="table">
           
            <thead class="thead-dark">
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
            </thead>
            <c:forEach var="flight" items="${listFlight}">
                <tr>
                    <td><c:out value="${flight.id}" /></td>
                    <td><c:out value="${flight.departureDate}" /></td>
                    <td><c:out value="${flight.airline}" /></td>
                    <td><c:out value="${flight.sourceAirport}" /></td>
                    <td><c:out value="${flight.destinationAirport}" /></td>
                    <td class="align-right"><c:out value="$${flight.fare}" /></td>
                    <td class="align-right"><c:out value="${flight.numberAvailableSeats}" /></td>
                    <td>
                        <a href="/FlyAwayAirlineBookingProject/displayBookingCustomerForm?id=<c:out value='${flight.id}' />">Book</a>            
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>