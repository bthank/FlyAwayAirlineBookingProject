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
		<h2>Admin Page</h2>
		<br />
		<br />
	</center>
    <center>
        <h3>
            <a href="/FlyAwayAirlineBookingProject/showAdminHome">Admin Home</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/FlyAwayAirlineBookingProject/new">Add New Flight</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/FlyAwayAirlineBookingProject/listAllFlightsAdmin">List All Flights</a>
             
        </h3>
    </center>
    <div align="center">
 
        <form action="updateUserPassword" method="post">
	        <table border="1" cellpadding="5">
	            <caption>
	                <h2>Update Password</h2>
	            </caption>
                <c:if test="${user != null}">
                    <input type="hidden" name="username" value="<c:out value='${user.username}' />" />
                </c:if>           
	
	            <tr>
	            	<td>
	            		New Password: <input type="password" name="adminPwd" />  
	            	</td>
	            </tr>
	            <tr>
	                <td colspan="2" align="center">
	                    <input type="submit" value="Update" />
	                </td>
	            </tr>
	        </table>
        </form>
    </div>   
</body>
</html>
