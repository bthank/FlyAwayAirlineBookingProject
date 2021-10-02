package com.binu.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.binu.flyaway.dto.Booking;

/**
 * BookingDaoImpl.java
 * This is the class containing CRUD implementations of the data access methods listed in the BookingDao interface
 *  
 */
public class BookingDaoImpl implements BookingDao {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
	
    
	
	public BookingDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	public boolean addBooking(Booking booking) throws SQLException {
		
        String sql = "INSERT INTO booking (customer_id, flight_id, payment_id) VALUES (?, ?, ?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
       
        statement.setInt(1, booking.getCustomerId());
        statement.setInt(2, booking.getFlightId());
        statement.setInt(3, booking.getPaymentId());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        
        return rowInserted;		 
	}

}
