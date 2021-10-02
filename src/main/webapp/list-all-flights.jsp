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
		body {
			background-color: lightblue;
		}
	</style>    
</head>
<body>
	<center>
		<h1>Fly Away Airline Flight Booking</h1>
		<h2>Admin Page</h2>
		<br />
	</center>
    <center>
        <h5>
            <a href="/FlyAwayAirlineBookingProject/showAdminHome">Admin Home</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/FlyAwayAirlineBookingProject/new">Add New Flight</a>
             
        </h5>
        <br/><br/>
    </center>
    <div align="center">
        <caption><h2>List of Flights</h2></caption>
        <table border="1" cellpadding="5" class="table">
 
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
                        <a href="/FlyAwayAirlineBookingProject/edit?id=<c:out value='${flight.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/FlyAwayAirlineBookingProject/delete?id=<c:out value='${flight.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>