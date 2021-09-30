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

import com.binu.flyaway.dao.FlightDao;
import com.binu.flyaway.dao.FlightDaoImpl;
import com.binu.flyaway.dao.UserDao;
import com.binu.flyaway.dao.UserDaoImpl;
import com.binu.flyaway.dto.Flight;
import com.binu.flyaway.dto.TravelSearchDetail;
import com.binu.flyaway.dto.User;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 *  
 */
//@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
    private UserDao userDao;
    private FlightDao flightDao;   
    
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        
        System.out.println("In ControllerServlet init()   jdbcURL= " + jdbcURL);
        System.out.println("In ControllerServlet init()   jdbcUsername= " + jdbcUsername);
        System.out.println("In ControllerServlet init()   jdbcPassword= " + jdbcPassword);
        
        userDao   = new UserDaoImpl(jdbcURL, jdbcUsername, jdbcPassword);
        flightDao = new FlightDaoImpl(jdbcURL, jdbcUsername, jdbcPassword); 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/home":
            	showCustomerHomePage(request,response);
            	break;
            case "/customerSearchFlights":
               	showCustomerSearchFlightsForm(request,response);
            	break;
            case "/findFlights":
              	findFlights(request,response);
            	break;        	
            case "/adminLogin":
            	showAdminLoginForm(request,response);
            	break;
            case "/validateAdminLogin":
            	validateAdminLogin(request,response);
            	break;
            case "/showAdminHome":
            	showAdminHomePage(request,response);
            	break;  
            case "/showUpdateUserPasswordForm":
            	showUpdateUserPasswordForm(request,response);
            	break;              	
            case "/updateUserPassword":
            	updateUserPassword(request,response);
            	break;            	
            	
            case "/listAllFlightsCustomer":
            	listFlightsCustomer(request,response);
            	break;
            case "/listAllFlightsAdmin":
            	listFlightsAdmin(request,response);
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
            	displayMasterListofAirlinesAdmin(request,response);
            	break; 
            case "/displayMasterListofAirportsAdmin":
            	displayMasterListofAirportsAdmin(request,response);
            	break; 
            default:
            	showCustomerHomePage(request,response);
            	break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    private void showCustomerHomePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
    	
    	request.setAttribute("admin_username","");
    	
          RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
          dispatcher.forward(request, response);
    }
    
    private void showCustomerSearchFlightsForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
          RequestDispatcher dispatcher = request.getRequestDispatcher("customer-search-flights.jsp");
          dispatcher.forward(request, response);
    } 
    
    private void findFlights(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException, ServletException {
    	
    	
    	String sDate1=request.getParameter("departureDate");
    	java.util.Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
    	
      //  java.util.Date myDate = new java.util.Date(flight.getDepartureDate().toString());
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
    	
    	java.sql.Date departureDate = sqlDate;
        String source = request.getParameter("departureCity");
        String destination = request.getParameter("destinationCity");
        Integer numberTraveling = Integer.parseInt(request.getParameter("numberTraveling")); 
        
        TravelSearchDetail travelSearchDetail = new TravelSearchDetail(source, destination, departureDate, numberTraveling);
        List<Flight> listFlight = flightDao.findFlights(travelSearchDetail);

        System.out.println("D1:   listflight=" + listFlight);
          
        request.setAttribute("listFlight", listFlight);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list-flights.jsp");
        dispatcher.forward(request, response);        
        
    }
 

    
    private void showAdminLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
          RequestDispatcher dispatcher = request.getRequestDispatcher("admin-login.jsp");
          dispatcher.forward(request, response);
    }

    private void validateAdminLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
		 
		 String username = request.getParameter("adminUserName");
		 String password = request.getParameter("adminPwd");

		 User user = new User(username,password);
		 System.out.println("User name: " + user.getUsername());
		 System.out.println("Password: " + user.getPassword());
		 		 
		 boolean isValidAdminUser = userDao.validateAdminUser(user);
		 System.out.println("In ValidateAdminLogin   isValidAdminUser= " + isValidAdminUser);
		 
		 if (isValidAdminUser) {
			 // send the user to the admin-portal.jsp page
			 HttpSession session = request.getSession();
			 session.setAttribute("adminUserName", user.getUsername());

			 response.sendRedirect("admin-portal.jsp");
		 } else {
			 HttpSession session = request.getSession();
			 session.setAttribute("adminUserName", "");
			 // send the user to the admin-login-error.jsp page
			 response.sendRedirect("admin-login-error.jsp");
			 
		 }
    }
    
    
    private void showAdminHomePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
          RequestDispatcher dispatcher = request.getRequestDispatcher("admin-portal.jsp");
          dispatcher.forward(request, response);
    }
    
    private void showUpdateUserPasswordForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ParseException {
    		
    	String username = (String)request.getAttribute("admin_username");
    	User user = userDao.findUserByUsername(username);	
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("update-user-password-form.jsp");
    	dispatcher.forward(request, response);
    }
    
    private void listFlightsCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        List<Flight> listFlight = flightDao.listAllFlights();
        request.setAttribute("listFlight", listFlight);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list-flights.jsp");
        dispatcher.forward(request, response);
    }
    
    private void listFlightsAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        List<Flight> listFlight = flightDao.listAllFlights();
        request.setAttribute("listFlight", listFlight);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-all-flights.jsp");
        dispatcher.forward(request, response);
    }
    
 
    
    private void displayMasterListofAirlinesAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        List<Flight> listFlight = flightDao.listAllFlights();
        
        Set<String> setAirlines = new HashSet<>();
        for (Flight flight: listFlight) {
        	setAirlines.add(flight.getAirline());
        }
        
        request.setAttribute("setAirlines", setAirlines);
        RequestDispatcher dispatcher = request.getRequestDispatcher("master-list-airlines.jsp");
        dispatcher.forward(request, response);
    }
    
    private void displayMasterListofAirportsAdmin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        List<Flight> listFlight = flightDao.listAllFlights();
        
        Set<String> setAirports = new HashSet<>();
        for (Flight flight: listFlight) {
        	setAirports.add(flight.getSourceAirport());
        	setAirports.add(flight.getDestinationAirport());
        }
        
        request.setAttribute("setAirports", setAirports);
        RequestDispatcher dispatcher = request.getRequestDispatcher("master-list-airports.jsp");
        dispatcher.forward(request, response);
    }    
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Flight existingFlight = flightDao.getFlight(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("flight-form.jsp");
        request.setAttribute("flight", existingFlight);
        dispatcher.forward(request, response);
 
    }
 
    private void insertFlight(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException, ServletException {
    	
    	
    	String sDate1=request.getParameter("departureDate");
    	java.util.Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
    	
    	java.util.Date departureDate = date1;
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        Double fare = Double.parseDouble(request.getParameter("fare"));
        Integer availableSeats = Integer.parseInt(request.getParameter("availableSeats")); 
        String airline = request.getParameter("airline");
        
        Flight newFlight = new Flight(source, destination, departureDate, fare, availableSeats,airline);
        flightDao.addFlight(newFlight);
        
        listFlightsAdmin(request,response);

    }
 
    private void updateFlight(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        
    	String sDate1=request.getParameter("departureDate");
    	java.util.Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(sDate1);
    	
        java.util.Date departureDate = date1;
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        Double fare = Double.parseDouble(request.getParameter("fare"));
        Integer availableSeats = Integer.parseInt(request.getParameter("availableSeats")); 
        String airline = request.getParameter("airline");
 
        Flight flight = new Flight(id, source, destination, departureDate, fare, availableSeats,airline);
        flightDao.updateFlight(flight);
        
        listFlightsAdmin(request,response);

    }
    
    
    private void updateUserPassword(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException, ServletException {
    	
		 HttpSession session = request.getSession();
		 String username = (String)session.getAttribute("adminUserName");
    	
        if (username == null) {
        	request.setAttribute("error", "ERROR - Cannot update password.  Username is null.");
			 // send the user to the admin-error.jsp page
			 response.sendRedirect("admin-error.jsp");
        }
        
    	String pwd=request.getParameter("adminPwd");
  
        User user = userDao.findUserByUsername(username);
        user.setPassword(pwd);
        
        userDao.updateUserPassword(user);
        

        showAdminLoginForm(request,response);
    }    
    
 
    private void deleteFlight(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Flight flight = new Flight(id);
        flightDao.deleteFlight(flight);

        listFlightsAdmin(request,response);
 
    }
}
