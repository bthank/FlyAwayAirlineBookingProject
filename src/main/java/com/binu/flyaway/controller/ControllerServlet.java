package com.binu.flyaway.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.binu.flyaway.dao.BookingDao;
import com.binu.flyaway.dao.BookingDaoImpl;
import com.binu.flyaway.dao.CustomerDao;
import com.binu.flyaway.dao.CustomerDaoImpl;
import com.binu.flyaway.dao.FlightDao;
import com.binu.flyaway.dao.FlightDaoImpl;
import com.binu.flyaway.dao.PaymentDetailsDao;
import com.binu.flyaway.dao.PaymentDetailsDaoImpl;
import com.binu.flyaway.dao.UserDao;
import com.binu.flyaway.dao.UserDaoImpl;
import com.binu.flyaway.dto.Booking;
import com.binu.flyaway.dto.Customer;
import com.binu.flyaway.dto.Flight;
import com.binu.flyaway.dto.PaymentDetails;
import com.binu.flyaway.dto.TravelSearchDetail;
import com.binu.flyaway.dto.User;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the user.
 * 
 */
//@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	private FlightDao flightDao;
	private CustomerDao customerDao;
	private PaymentDetailsDao paymentDetailsDao;
	private BookingDao bookingDao;

	/**
	 * Method to initalize database connection fields and instantiate Dao objects used by the controller
	 */
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		System.out.println("In ControllerServlet init()   jdbcURL= " + jdbcURL);
		System.out.println("In ControllerServlet init()   jdbcUsername= " + jdbcUsername);
		System.out.println("In ControllerServlet init()   jdbcPassword= " + jdbcPassword);

		userDao = new UserDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
		flightDao = new FlightDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
		customerDao = new CustomerDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
		paymentDetailsDao = new PaymentDetailsDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
		bookingDao = new BookingDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
	}

	/**
	 * Method to handle Post requests; routes to doGet to do all processing
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	/**
	 * Method to handle Get requests and handles routinfg of requests to appropriate handler methods
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/home":
				showCustomerHomePage(request, response);
				break;
			case "/customerSearchFlights":
				showCustomerSearchFlightsForm(request, response);
				break;
			case "/findFlights":
				findFlights(request, response);
				break;
			case "/displayBookingCustomerForm":
				displayBookingCustomerForm(request, response);
				break;
			case "/addCustomer":
				addCustomer(request, response);
				break;

			case "/addPaymentDetails":
				addPaymentDetails(request, response);
				break;
			case "/bookFlight":
				bookFlight(request, response);
				break;

			case "/adminLogin":
				showAdminLoginForm(request, response);
				break;
			case "/validateAdminLogin":
				validateAdminLogin(request, response);
				break;
			case "/showAdminHome":
				showAdminHomePage(request, response);
				break;
			case "/showUpdateUserPasswordForm":
				showUpdateUserPasswordForm(request, response);
				break;
			case "/updateUserPassword":
				updateUserPassword(request, response);
				break;

			case "/listAllFlightsCustomer":
				listFlightsCustomer(request, response);
				break;
			case "/listAllFlightsAdmin":
				listFlightsAdmin(request, response);
				break;
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertFlight(request, response);
				break;
			case "/delete":
				deleteFlight(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateFlight(request, response);
				break;
			case "/displayMasterListofAirlinesAdmin":
				displayMasterListofAirlinesAdmin(request, response);
				break;
			case "/displayMasterListofAirportsAdmin":
				displayMasterListofAirportsAdmin(request, response);
				break;
			default:
				showCustomerHomePage(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}
	
	/**
	 * Request handler method to show the landing page for the web app
	 */
	private void showCustomerHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {

		request.setAttribute("admin_username", "");

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Request handler method to display the customer search flights page
	 */
	private void showCustomerSearchFlightsForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer-search-flights.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * Request handler method to find flights based off of the user specified search criteria
	 */
	private void findFlights(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {

		try {
			
			String sDate1 = request.getParameter("departureDate");
			java.util.Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);

			// java.util.Date myDate = new
			// java.util.Date(flight.getDepartureDate().toString());
			java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

			java.sql.Date departureDate = sqlDate;
			String source = request.getParameter("departureCity");
			String destination = request.getParameter("destinationCity");
			Integer numberTraveling = Integer.parseInt(request.getParameter("numberTraveling"));

			TravelSearchDetail travelSearchDetail = new TravelSearchDetail(source, destination, departureDate,
					numberTraveling);
			List<Flight> listFlight = flightDao.findFlights(travelSearchDetail);

			System.out.println("D1:   listflight=" + listFlight);

			request.setAttribute("listFlight", listFlight);
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list-flights.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer-input-error.jsp");
			dispatcher.forward(request, response);

		}


	}
	
	/**
	 * Request handler method to display the booking process' customer information entry page
	 */
	private void displayBookingCustomerForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {
		int flightId = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("flightId", flightId);
		System.out.println("In displayBookingCustomerForm   flightId= " + flightId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("booking-customer-form.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * Request handler method to handle adding a customer to the customer table in the database
	 */
	private void addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		String phoneNo = request.getParameter("phoneNo");
		Integer noOfTravelers = Integer.parseInt(request.getParameter("noOfTravelers"));

		System.out.println("In addCustomer   firstName=" + firstName + "   noOfTravelers=" + noOfTravelers);

		Customer newCustomer = new Customer(firstName, lastName, addressLine1, addressLine2, city, state, zipCode,
				phoneNo, noOfTravelers);
		customerDao.addCustomer(newCustomer);

		RequestDispatcher dispatcher = request.getRequestDispatcher("payment-details-form.jsp");
		dispatcher.forward(request, response);

	}
	
	/**
	 * Request handler method to handle adding a payment detail record to the payment_details table in the database
	 */
	private void addPaymentDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {

		Integer paymentType = Integer.parseInt(request.getParameter("paymentType"));
		String cardNo = request.getParameter("cardNo");
		Integer cardExpirationMonth = Integer.parseInt(request.getParameter("cardExpirationMonth"));
		Integer cardExpirationYear = Integer.parseInt(request.getParameter("cardExpirationYear"));
		Integer cardCvvCode = Integer.parseInt(request.getParameter("cardCvvCode"));

		String billingFirstName = request.getParameter("billingFirstName");
		String billingLastName = request.getParameter("billingLastName");
		String billingAddressLine1 = request.getParameter("billingAddressLine1");
		String billingAddressLine2 = request.getParameter("billingAddressLine2");
		String billingCity = request.getParameter("billingCity");
		String billingState = request.getParameter("billingState");
		String billingZipCode = request.getParameter("billingZipCode");
		String billingPhoneNo = request.getParameter("billingPhoneNo");

		System.out.println(
				"In addPaymentDetails   paymentType=" + paymentType + "   billingFirstName=" + billingFirstName);

		PaymentDetails newPaymentDetails = new PaymentDetails(paymentType, cardNo, cardExpirationMonth,
				cardExpirationYear, cardCvvCode, billingFirstName, billingLastName, billingAddressLine1,
				billingAddressLine2, billingCity, billingState, billingZipCode, billingPhoneNo);
		System.out.println("newPaymentDetails= " + newPaymentDetails);
		paymentDetailsDao.addPaymentDetails(newPaymentDetails);

		RequestDispatcher dispatcher = request.getRequestDispatcher("confirm-booking-details-form.jsp");
		dispatcher.forward(request, response);

	}
	
	/**
	 * Request handler method to handle adding a booking record to the booking table in the database
	 */
	private void bookFlight(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {

		HttpSession session = request.getSession();
		Integer customerId = (Integer) session.getAttribute("customerId");
		Integer flightId = (Integer) session.getAttribute("flightId");
		Integer paymentId = (Integer) session.getAttribute("paymentId");

		System.out.println(
				"In bookFlight   customerId=" + customerId + "   flightId=" + flightId + "    paymentId=" + paymentId);

		Booking newBooking = new Booking(customerId, flightId, paymentId);
		bookingDao.addBooking(newBooking);

		RequestDispatcher dispatcher = request.getRequestDispatcher("booking-success-page.jsp");
		dispatcher.forward(request, response);

	}
	
	/**
	 * Request handler method to handle displaying the admin login form
	 */
	private void showAdminLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin-login.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * Request handler method to handle validating the admin login form
	 */
	private void validateAdminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {

		String username = request.getParameter("adminUserName");
		String password = request.getParameter("adminPwd");

		User user = new User(username, password);
		System.out.println("User name: " + user.getUsername());
		System.out.println("Password: " + user.getPassword());

		boolean isValidAdminUser = userDao.validateAdminUser(user);
		System.out.println("In ValidateAdminLogin   isValidAdminUser= " + isValidAdminUser);

		if (isValidAdminUser) {
			// send the user to the admin-portal.jsp page
			HttpSession session = request.getSession();
			session.setAttribute("userType", "ADMIN");
			session.setAttribute("adminUserName", user.getUsername());

			response.sendRedirect("admin-portal.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("userType", "");
			session.setAttribute("adminUserName", "");
			// send the user to the admin-login-error.jsp page
			response.sendRedirect("admin-login-error.jsp");

		}
	}
	
	/**
	 * Request handler method to handle displaying the admin home page
	 */
	private void showAdminHomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {

		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);

		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-portal.jsp");
			dispatcher.forward(request, response);

		}

	}
	
	/**
	 * Request handler method to handle displaying the update user password page
	 */
	private void showUpdateUserPasswordForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, ParseException {

		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);

		} else {

			String username = (String) request.getAttribute("admin_username");
			User user = userDao.findUserByUsername(username);

			RequestDispatcher dispatcher = request.getRequestDispatcher("update-user-password-form.jsp");
			dispatcher.forward(request, response);

		}

	}
	
	/**
	 * Request handler method to handle displaying the list of all flights for a customer
	 */
	private void listFlightsCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException {
		List<Flight> listFlight = flightDao.listAllFlights();
		request.setAttribute("listFlight", listFlight);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list-flights.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * Request handler method to handle displaying the list of all flights for a admin user
	 */
	private void listFlightsAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException {

		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);

		} else {

			List<Flight> listFlight = flightDao.listAllFlights();
			request.setAttribute("listFlight", listFlight);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list-all-flights.jsp");
			dispatcher.forward(request, response);

		}

	}
	
	/**
	 * Request handler method to handle displaying the master list of airlines providing available flights for an admin user
	 */
	private void displayMasterListofAirlinesAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException {
		
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);

		} else {
			
			List<Flight> listFlight = flightDao.listAllFlights();

			Set<String> setAirlines = new HashSet<>();
			for (Flight flight : listFlight) {
				setAirlines.add(flight.getAirline());
			}

			request.setAttribute("setAirlines", setAirlines);
			RequestDispatcher dispatcher = request.getRequestDispatcher("master-list-airlines.jsp");
			dispatcher.forward(request, response);
			
		}		
		
	}
	
	/**
	 * Request handler method to handle displaying the master list of airports used in available flights for an admin user
	 */
	private void displayMasterListofAirportsAdmin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException {
				
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);

		} else {
			
			List<Flight> listFlight = flightDao.listAllFlights();

			Set<String> setAirports = new HashSet<>();
			for (Flight flight : listFlight) {
				setAirports.add(flight.getSourceAirport());
				setAirports.add(flight.getDestinationAirport());
			}

			request.setAttribute("setAirports", setAirports);
			RequestDispatcher dispatcher = request.getRequestDispatcher("master-list-airports.jsp");
			dispatcher.forward(request, response);		
			
		}
			
	}
	
	/**
	 * Request handler method to handle displaying an add flight page for an admin user
	 */
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);

		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
			dispatcher.forward(request, response);
			
		}
				
	}
	
	/**
	 * Request handler method to handle displaying an edit flight page for an admin user
	 */
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);
		
		} else {
			
			int id = Integer.parseInt(request.getParameter("id"));
			Flight existingFlight = flightDao.getFlight(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
			request.setAttribute("flight", existingFlight);
			dispatcher.forward(request, response);
			
		}
	
	}
	
	/**
	 * Request handler method to handle adding a flight for an admin user
	 */
	private void insertFlight(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);
		
		} else {
			
			try {
				
				String sDate1 = request.getParameter("departureDate");
				java.util.Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);

				java.util.Date departureDate = date1;
				String source = request.getParameter("source");
				String destination = request.getParameter("destination");
				Double fare = Double.parseDouble(request.getParameter("fare"));
				Integer availableSeats = Integer.parseInt(request.getParameter("availableSeats"));
				String airline = request.getParameter("airline");

				Flight newFlight = new Flight(source, destination, departureDate, fare, availableSeats, airline);
				flightDao.addFlight(newFlight);

				listFlightsAdmin(request, response);
				
			} catch (ParseException e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin-input-error.jsp");
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
			}

		}
			
	}
	
	/**
	 * Request handler method to handle updating a flight for an admin user
	 */
	private void updateFlight(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
				
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);
		
		} else {
			
			
			try {

				int id = Integer.parseInt(request.getParameter("id"));

				String sDate1 = request.getParameter("departureDate");
				java.util.Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);

				java.util.Date departureDate = date1;
				String source = request.getParameter("source");
				String destination = request.getParameter("destination");
				Double fare = Double.parseDouble(request.getParameter("fare"));
				Integer availableSeats = Integer.parseInt(request.getParameter("availableSeats"));
				String airline = request.getParameter("airline");

				Flight flight = new Flight(id, source, destination, departureDate, fare, availableSeats, airline);
				flightDao.updateFlight(flight);

				listFlightsAdmin(request, response);
				
			} catch (ParseException e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin-input-error.jsp");
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
			}
				
		}
			
	}
	
	/**
	 * Request handler method to handle updating the password for an admin user
	 */
	private void updateUserPassword(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
	
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);
		
		} else {
			
			
			String username = (String) session.getAttribute("adminUserName");

			if (username == null) {
				request.setAttribute("error", "ERROR - Cannot update password.  Username is not available.");
				// send the user to the admin-error.jsp page
				response.sendRedirect("admin-error.jsp");
			} else {

				String pwd = request.getParameter("adminPwd");

				User user = userDao.findUserByUsername(username);
				user.setPassword(pwd);

				userDao.updateUserPassword(user);

				showAdminLoginForm(request, response);		
				
			}
			
		}
					
	}
	
	/**
	 * Request handler method to handle deleting a flight for an admin user
	 */
	private void deleteFlight(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ParseException {
		
		HttpSession session = request.getSession();
		String userType = (String) session.getAttribute("userType");
		if (userType != "ADMIN") {
			// send the user to an admin page access error page
			RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page-access-error.jsp");
			dispatcher.forward(request, response);
		
		} else {
			
			try {
				
				int id = Integer.parseInt(request.getParameter("id"));

				Flight flight = new Flight(id);
				flightDao.deleteFlight(flight);

				listFlightsAdmin(request, response);
				
			} catch (Exception e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
			}
			
		}
				
	}
}
