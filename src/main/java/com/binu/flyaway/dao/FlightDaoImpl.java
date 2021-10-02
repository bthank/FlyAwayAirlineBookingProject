package com.binu.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.binu.flyaway.dto.Flight;
import com.binu.flyaway.dto.TravelSearchDetail;

/**
 * FlightDaoImpl.java
 * This is the class containing CRUD implementations of the data access methods listed in theFlightDao interface
 *  
 */
public class FlightDaoImpl implements FlightDao {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
	
    
	
	public FlightDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	@Override
	public void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }		 
		
	}

	@Override
	public void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }		 
		
	}

	@Override
	public boolean addFlight(Flight flight) throws SQLException {
        String sql = "INSERT INTO flight (source_airport, dest_airport, departure_date, fare, available_seats, airline_name) VALUES (?, ?, ?, ?, ?, ?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        Flight.setMaxId(Flight.getMaxId() + 1);
     //   statement.setInt(1, Flight.getMaxId());
        statement.setString(1, flight.getSourceAirport().toUpperCase());
        statement.setString(2, flight.getDestinationAirport().toUpperCase());
        
        java.util.Date myDate = new java.util.Date(flight.getDepartureDate().toString());
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
        
        statement.setDate(3, sqlDate);
        statement.setDouble(4, flight.getFare());
        statement.setInt(5, flight.getNumberAvailableSeats());    
        statement.setString(6, flight.getAirline());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;		 

	}

	@Override
	public List<Flight> listAllFlights() throws SQLException, ParseException {
        List<Flight> listFlights = new ArrayList<>();
        
        String sql = "SELECT * FROM flight";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String sourceAirport = resultSet.getString("source_airport");
            String destAirport = resultSet.getString("dest_airport");
                        
        	String sDate1=resultSet.getDate("departure_date").toString();
        	java.util.Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
        	            
            
            System.out.println("A1: " + resultSet.getDate("departure_date"));
            System.out.println("A2: " + resultSet.getDate("departure_date").toString());            
            java.util.Date myDate =date1;
      //      java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            
            
            
            java.util.Date departureDate = date1;
            Double fare = resultSet.getDouble("fare");
            Integer availableSeats = resultSet.getInt("available_seats");
            String airline = resultSet.getString("airline_name");
             
            Flight flight = new Flight(id, sourceAirport, destAirport, departureDate, fare, availableSeats,airline);
            listFlights.add(flight);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listFlights;
	}

	@Override
	public boolean deleteFlight(Flight flight) throws SQLException {
        String sql = "DELETE FROM flight where id = ?";
        
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, flight.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;     
	}

	@Override
	public boolean updateFlight(Flight flight) throws SQLException {
        String sql = "UPDATE flight SET source_airport = ?, dest_airport = ?, departure_date = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, flight.getSourceAirport().toUpperCase());
        statement.setString(2, flight.getDestinationAirport().toUpperCase());
                
        java.util.Date myDate = new java.util.Date(flight.getDepartureDate().toString());
        java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
          
        statement.setDate(3, sqlDate);
        statement.setInt(4, flight.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
	}

	@Override
	public List<Flight> findFlights(TravelSearchDetail travelSearchDetail) throws SQLException {
        List<Flight> listFlights = new ArrayList<>();
        String sql = "SELECT * FROM flight WHERE source_airport = ? AND dest_airport = ? AND departure_date = ?";
         
        connect();
         
        System.out.println("F7: In FlightDaoImpl travelSearchDetail.getSourceAirport()= " + travelSearchDetail.getSourceAirport());
        System.out.println("F7: In FlightDaoImpl travelSearchDetail.getDestinationAirport()= " + travelSearchDetail.getDestinationAirport());
        System.out.println("F7: In FlightDaoImpl travelSearchDetail.getDepartureDate()= " + travelSearchDetail.getDepartureDate());
        System.out.println("F7: In FlightDaoImpl travelSearchDetail.getNumberTraveling()= " + travelSearchDetail.getNumberTraveling());

        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, travelSearchDetail.getSourceAirport().toUpperCase());
        statement.setString(2, travelSearchDetail.getDestinationAirport().toUpperCase());
        statement.setDate(3, travelSearchDetail.getDepartureDate());
   //     statement.setInt(4, travelSearchDetail.getNumberTraveling());
        
        ResultSet resultSet = statement.executeQuery();
         
        while (resultSet.next()) {
        	Integer id = resultSet.getInt("id");
            String sourceAirport = resultSet.getString("source_airport");
            String destinationAirport = resultSet.getString("dest_airport");
            java.util.Date departureDate = resultSet.getDate("departure_date");
            Double fare = resultSet.getDouble("fare");
            Integer availableSeats = resultSet.getInt("available_seats");
            String airline = resultSet.getString("airline_name");
            
            // only display flights with enough seats to accommodate the customers number of travelers
            if (availableSeats >= travelSearchDetail.getNumberTraveling()) {
                Flight flight = new Flight(id, sourceAirport, destinationAirport, departureDate,fare,availableSeats,airline);
                listFlights.add(flight);            
                System.out.println("F91: In FlightDaoImpl flight= " + flight);
            }
            
        }
         
        resultSet.close();
        statement.close();
        System.out.println("F99: In FlightDaoImpl listFlights= " + listFlights);
         
        return listFlights;
	}

	

	@Override
	public Flight getFlight(Integer id) throws SQLException {
        Flight flight = null;
        String sql = "SELECT * FROM flight WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
          
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String sourceAirport = resultSet.getString("source_airport");
            String destinationAirport = resultSet.getString("dest_airport");
            java.util.Date departureDate = resultSet.getDate("departure_date");
            Double fare = resultSet.getDouble("fare");
            Integer availableSeats = resultSet.getInt("available_seats");
            String airline = resultSet.getString("airline_name");
             
            flight = new Flight(id, sourceAirport, destinationAirport, departureDate,fare,availableSeats,airline);
        }
         
        resultSet.close();
        statement.close();
         
        return flight;
	}	
	
	
	
	
}
