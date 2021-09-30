<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fly Away Airline Flight Booking Application</title>
</head>
<body>
	<center>
		<h1>Fly Away Airline Flight Booking</h1>
		<br />
		<h2>Admin Login:</h2>

		<form
			action="http://localhost:8080/FlyAwayAirlineBookingProject/validateAdminLogin"
			method="post">
			Admin Username: <input type="text" name="adminUserName" /> <br /><br />
			Admin Password: <input type="password" name="adminPwd" /> <br /><br /> 
			<input	type="submit" value="Login" />
		</form>
	</center>
</body>
</html>