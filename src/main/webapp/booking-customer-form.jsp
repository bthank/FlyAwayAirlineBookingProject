<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
		<h2>Customer Booking</h2>
		<br />
		<h2>Register:</h2>




		<div align="center">

			<form action="addCustomer" method="post">

				<table border="1" cellpadding="5">

					<tr>
						<th>First Name:</th>
						<td><input type="text" name="firstName" size="20" /></td>
					</tr>

					<tr>
						<th>Last Name:</th>
						<td><input type="text" name="lastName" size="20" /></td>
					</tr>

					<tr>
						<th>Address Line 1:</th>
						<td><input type="text" name="addressLine1" size="20" /></td>
					</tr>
					<tr>
						<th>Address Line 2:</th>
						<td><input type="text" name="addressLine2" size="20" /></td>
					</tr>
					<tr>
						<th>City:</th>
						<td><input type="text" name="city" size="20" /></td>
					</tr>
					<tr>
						<th>State:</th>
						<td><input type="text" name="state" size="20" /></td>
					</tr>
					<tr>
						<th>Zip Code:</th>
						<td><input type="text" name="zipCode" size="5" /></td>
					</tr>
					<tr>
						<th>Phone No:</th>
						<td><input type="text" name="phoneNo" size="10" /></td>
					</tr>
					<tr>
						<th># of Travelers:</th>
						<td><input type="number" name="noOfTravelers" size="5" /></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"
							class="btn btn-primary mb-2" value="Register" /></td>
					</tr>
				</table>
			</form>
		</div>


	</center>
</body>
</html>