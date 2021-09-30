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
		<h3>Search for Flights</h3>
		<br />
	</center>


	<form action="findFlights" method="get">
		Departure Date (mm/dd/yyyy): <input type="date" name="departureDate" /> <br />
		Departure Airport: <input type="text" name="departureCity" length=3 /> <br />
		Destination Airport: <input type="text" name="destinationCity" length=3 /> <br />
		Number Traveling: <input type="text" name="numberTraveling" /> <br />
		<input type="submit" value="Find Flights" />
	</form>
</body>
</html>
