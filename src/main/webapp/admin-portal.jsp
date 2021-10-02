<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
		<h2>Admin Portal:</h2>
		<br />
		<hr>
		<a href="/FlyAwayAirlineBookingProject/showUpdateUserPasswordForm"><h5>Update Password</h5></a> <br/>
		
		<a href="/FlyAwayAirlineBookingProject/new"><h5>Add Flight</h5></a> 
		<a href="/FlyAwayAirlineBookingProject/listAllFlightsAdmin"><h5>List All Flights</h5></a> 			
		<a href="/FlyAwayAirlineBookingProject/displayMasterListofAirlinesAdmin"><h5>Master List of Airlines</h5></a> 				
		<a href="/FlyAwayAirlineBookingProject/displayMasterListofAirportsAdmin"><h5>Master List of Airports</h5></a> 				

	</center>
</body>
</html>