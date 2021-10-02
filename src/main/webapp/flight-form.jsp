<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Fly Away Airline Flight Booking Application</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js"
	integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/"
	crossorigin="anonymous"></script>
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
		<br /> <br />
	</center>
	<center>
		<h5>
			<a href="/FlyAwayAirlineBookingProject/showAdminHome">Admin Home</a>
			&nbsp;&nbsp;&nbsp; <a
				href="/FlyAwayAirlineBookingProject/listAllFlightsAdmin">List
				All Flights</a>

		</h5>
		<br/><br/>
	</center>
	<div align="center">
		<c:if test="${flight != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${flight == null}">
			<form action="insert" method="post">
		</c:if>
		<caption>
			<h2>
				<c:if test="${flight != null}">
                        Edit Flight
                    </c:if>
				<c:if test="${flight == null}">
                        Add New Flight
                    </c:if>
			</h2>
		</caption>

		<table border="1" cellpadding="5">
			<c:if test="${flight != null}">
				<input type="hidden" name="id"
					value="<c:out value='${flight.id}' />" />
			</c:if>
			<tr>
				<th>Departure Date:</th>
				<td><input type="date" name="departureDate"
					value="<c:out value='${flight.departureDate}' />" />
				</td>
			</tr>

			<tr>
				<th>Airline:</th>
				<td><input type="text" name="airline" size="3"
					value="<c:out value='${flight.airline}' />" />
				</td>
			</tr>

			<tr>
				<th>Source:</th>
				<td><input type="text" name="source" size="3"
					value="<c:out value='${flight.sourceAirport}' />" />
				</td>
			</tr>
			<tr>
				<th>Destination:</th>
				<td><input type="text" name="destination" size="3"
					value="<c:out value='${flight.destinationAirport}' />" />
				</td>
			</tr>
			<tr>
				<th>Fare:</th>
				<td><input type="text" name="fare" size="10"
					value="<c:out value='${flight.fare}' />" /></td>
			</tr>
			<tr>
				<th>Available Seats:</th>
				<td><input type="text" name="availableSeats" size="3"
					value="<c:out value='${flight.numberAvailableSeats}' />" />
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					class="btn btn-primary mb-2" value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
