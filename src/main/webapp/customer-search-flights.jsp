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
		<h2>Customer Booking</h2>
		<br />
		<h3>Search for Flights</h3>
		<br />
	</center>


	<form action="findFlights" method="get">
	 
			<div class="form-group row">
				<label for="departureDate" class="col-sm-2 col-form-label">Departure Date (mm/dd/yyyy):</label>
				<div class="col-sm-10">
				 	<input type="date" id="departureDate" name="departureDate" /> <br />
				</div>
			</div>
			<div class="form-group row">
				<label for="departureCity" class="col-sm-2 col-form-label">Departure Airport:</label>
				<div class="col-sm-10">
					<input type="text" id="departureCity" name="departureCity" length=3 /> <br />
				</div>
			</div>
			<div class="form-group row">
				<label for="destinationCity" class="col-sm-2 col-form-label">Destination Airport:</label>
				<div class="col-sm-10">
			 		<input type="text" id="destinationCity" name="destinationCity" length=3 /> <br />
			 	</div>	
			</div>
			<div class="form-group row">
				<label for="numberTraveling" class="col-sm-2 col-form-label">Number Traveling:</label>
				<div class="col-sm-10">
			 		<input type="text" id="numberTraveling" name="numberTraveling" /> <br />
			 	</div>	
			</div>

		  <div class="form-group row">
		    <div class="col-sm-10">
		      <button type="submit" class="btn btn-primary">Find Flights</button>
		    </div>
		  </div>
 

	</form>
</body>
</html>
