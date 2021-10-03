<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<br /> <br />
		<h2>Confirm and Submit Booking Details</h2>
		<br />
		<br />







		<form action="bookFlight" method="post">

			<h4>Customer Information</h4>
			<table border="1" cellpadding="5">
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName" size="20"
						value="<c:out value='${customer.firstName}' />" readonly /></td>
				</tr>

				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName" size="20"
						value="<c:out value='${customer.lastName}' />" readonly /></td>
				</tr>

				<tr>
					<th>Address Line 1:</th>
					<td><input type="text" name="addressLine1" size="20"
						value="<c:out value='${customer.addressLine1}' />" readonly /></td>
				</tr>
				<tr>
					<th>Address Line 2:</th>
					<td><input type="text" name="addressLine2" size="20"
						value="<c:out value='${customer.addressLine2}' />" readonly /></td>
				</tr>
				<tr>
					<th>City:</th>
					<td><input type="text" name="city" size="20"
						value="<c:out value='${customer.city}' />" readonly /></td>
				</tr>
				<tr>
					<th>State:</th>
					<td><input type="text" name="state" size="20"
						value="<c:out value='${customer.state}' />" readonly /></td>
				</tr>
				<tr>
					<th>Zip Code:</th>
					<td><input type="text" name="zipCode" size="5"
						value="<c:out value='${customer.zipCode}' />" readonly /></td>
				</tr>
				<tr>
					<th>Phone No:</th>
					<td><input type="text" name="phoneNo" size="10"
						value="<c:out value='${customer.phoneNo}' />" readonly /></td>
				</tr>
				<tr>
					<th># of Travelers:</th>
					<td><input type="number" name="noOfTravelers" size="5"
						value="<c:out value='${customer.noOfTravelers}' />" readonly /></td>
				</tr>
			</table>

			<br />
			<br />
			<h4>Payment Information</h4>
			<table border="1" cellpadding="5">
				<tr>
					<th>Payment Type (1=CC,2=Debit):</th>
					<td><input type="number" name="paymentType" size="20"
						value="<c:out value='${paymentDetail.paymentType}' />" readonly /></td>
				</tr>

				<tr>
					<th>Card No:</th>
					<td><input type="text" name="cardNo" size="20"
						value="<c:out value='${paymentDetail.cardNo}' />" readonly /></td>
				</tr>

				<tr>
					<th>Exp Month:</th>
					<td><input type="number" name="cardExpirationMonth" size="20"
						value="<c:out value='${paymentDetail.cardExpirationMonth}' />"
						readonly /></td>
				</tr>
				<tr>
					<th>Exp Year:</th>
					<td><input type="number" name="cardExpirationYear" size="20"
						value="<c:out value='${paymentDetail.cardExpirationYear}' />"
						readonly /></td>
				</tr>
				<tr>
					<th>CVV Code:</th>
					<td><input type="text" name="cardCvvCode" size="20"
						value="<c:out value='${paymentDetail.cardCvvCode}' />" readonly /></td>
				</tr>
			</table>
			<br />
			<br />

			<h4>Billing Information</h4>
			<table border="1" cellpadding="5">
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="billingFirstName" size="20"
						value="<c:out value='${paymentDetail.billingFirstName}' />"
						readonly /></td>
				</tr>

				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="billingLastName" size="20"
						value="<c:out value='${paymentDetail.billingLastName}' />"
						readonly /></td>
				</tr>

				<tr>
					<th>Address Line 1:</th>
					<td><input type="text" name="billingAddressLine1" size="20"
						value="<c:out value='${paymentDetail.billingAddressLine1}' />"
						readonly /></td>
				</tr>
				<tr>
					<th>Address Line 2:</th>
					<td><input type="text" name="billingAddressLine2" size="20"
						value="<c:out value='${paymentDetail.billingAddressLine1}' />"
						readonly /></td>
				</tr>
				<tr>
					<th>City:</th>
					<td><input type="text" name="billingCity" size="20"
						value="<c:out value='${paymentDetail.billingCity}' />" readonly /></td>
				</tr>
				<tr>
					<th>State:</th>
					<td><input type="text" name="billingState" size="20"
						value="<c:out value='${paymentDetail.billingState}' />" readonly /></td>
				</tr>
				<tr>
					<th>Zip Code:</th>
					<td><input type="text" name="billingZipCode" size="5"
						value="<c:out value='${paymentDetail.billingZipCode}' />" readonly /></td>
				</tr>
				<tr>
					<th>Phone No:</th>
					<td><input type="text" name="billingPhoneNo" size="10"
						value="<c:out value='${paymentDetail.billingPhoneNo}' />" readonly /></td>
				</tr>

			</table>


			<br />
			<br />
			<button type="submit" class="btn btn-primary">Submit Booking
			</button>


		</form>
	</center>
</body>
</html>