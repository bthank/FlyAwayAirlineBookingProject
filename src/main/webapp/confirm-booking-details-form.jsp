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
		<br />
		<h2>Confirm Booking Details</h2>
		<br/><br/>
		<h4>Payment Information:</h4>

		<form
			action="http://localhost:8080/FlyAwayAirlineBookingProject/addPaymentDetails"
			method="post">

			<div class="form-group row">
				<label for="paymentType" class="col-sm-2 col-form-label">Payment
					Type (1=CC,2=Debit):</label>
				<div class="col-sm-10">
					<input type="number" name="paymentType" id="paymentType"
						class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="cardNo" class="col-sm-2 col-form-label">Card No:</label>
				<div class="col-sm-10">
					<input type="number" name="cardNo" id="cardNo" class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="cardExpirationMonth" class="col-sm-2 col-form-label">Exp
					Month:</label>
				<div class="col-sm-10">
					<input type="number" name="cardExpirationMonth"
						id="cardExpirationMonth" class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="cardExpirationYear" class="col-sm-2 col-form-label">Exp
					Year:</label>
				<div class="col-sm-10">
					<input type="number" name="cardExpirationYear"
						id="cardExpirationYear" class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="cardCvvCode" class="col-sm-2 col-form-label">CVV
					Code:</label>
				<div class="col-sm-10">
					<input type="number" name="cardCvvCode" id="cardCvvCode"
						class="form-control" readonly />
				</div>
			</div>

			<h4>Billing Address:</h4>
			
			<div class="form-group row">
				<label for="billingFirstName" class="col-sm-2 col-form-label">First
					Name:</label>
				<div class="col-sm-10">
					<input type="text" name="billingFirstName" id="billingFirstName"
						class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingLastName" class="col-sm-2 col-form-label">Last
					Name:</label>
				<div class="col-sm-10">
					<input type="text" name="billingLastName" id="billingLastName"
						class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingAddressLine1" class="col-sm-2 col-form-label">Address
					Line 1:</label>
				<div class="col-sm-10">
					<input type="text" name="billingAddressLine1"
						id="billingAddressLine1" class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingAddressLine2" class="col-sm-2 col-form-label">Address
					Line 2:</label>
				<div class="col-sm-10">
					<input type="text" name="billingAddressLine2"
						id="billingAddressLine2" class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingCity" class="col-sm-2 col-form-label">City:</label>
				<div class="col-sm-10">
					<input type="text" name="billingCity" id="billingCity"
						class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingState" class="col-sm-2 col-form-label">State:</label>
				<div class="col-sm-10">
					<input type="text" name="billingState" id="billingState"
						class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingZipCode" class="col-sm-2 col-form-label">Zip
					Code:</label>
				<div class="col-sm-10">
					<input type="text" name="billingZipCode" id="billingZipCode"
						class="form-control" readonly />
				</div>
			</div>
			<div class="form-group row">
				<label for="billingPhoneNo" class="col-sm-2 col-form-label">Phone
					No:</label>
				<div class="col-sm-10">
					<input type="text" name="billingPhoneNo" id="billingPhoneNo"
						class="form-control" readonly />
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-10">
					<button type="submit" class="btn btn-primary">Submit
						Payment Info</button>
				</div>
			</div>

		</form>
	</center>
</body>
</html>