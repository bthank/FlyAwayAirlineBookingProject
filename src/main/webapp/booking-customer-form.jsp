<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<h2>Register:</h2>

		<form
			action="http://localhost:8080/FlyAwayAirlineBookingProject/addCustomer"
			method="post">
			<div class="form-group">
				First Name: <input type="text" name="firstName" /> <br />
				Last Name: <input type="text" name="lastName" /> <br />		
				Address Line 1: <input type="text" name="addressLine1" /> <br />
				Address Line 2: <input type="text" name="addressLine2" /> <br />
				City: <input type="text" name="city" /> <br />
				State: <input type="text" name="state" /> <br />
				Zip Code: <input type="text" name="zipCode" /> <br />	
				Phone No: <input type="text" name="phoneNo" /> <br />			
				# of Travelers: <input type="number" name="noOfTravelers" /> <br />
			</div>
			<input	type="submit" class="btn btn-primary mb-2" value="Register" />
		</form>
	</center>
</body>
</html>