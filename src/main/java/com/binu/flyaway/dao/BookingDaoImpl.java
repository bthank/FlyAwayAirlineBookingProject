package com.binu.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
    
	/**
	 * Constructor that sets JDBC parameters
	 * 
	 * @param jdbcURL
	 * @param jdbcUsername
	 * @param jdbcPassword
	 */
	public BookingDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	/**
	 * handles connecting to the database via JDBC
	 */
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

	/**
	 * handles disconnecting from the database via JDBC
	 */
	@Override
	public void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }		 
		
	}

	/**
	 * handles adding a booking record to the booking database table using JDBC prepared statement
	 */
	@Override
	public boolean addBooking(Booking booking) throws SQLException {
		
        String sql = "INSERT INTO booking (customer_id, flight_id, payment_id) VALUES (?, ?, ?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       
        statement.setInt(1, booking.getCustomerId());
        statement.setInt(2, booking.getFlightId());
        statement.setInt(3, booking.getPaymentId());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        
        
        // get the id of the record inserted in the database
        ResultSet rs = statement.getGeneratedKeys();
        int last_inserted_id = -1;
        if(rs.next())
        {
            last_inserted_id = rs.getInt(1);
        }
        System.out.println("In BookingDaoImpl addBooking method   last_inserted_id=" + last_inserted_id);
        booking.setBookingId(last_inserted_id);
        
        
        statement.close();
        disconnect();
        
        return rowInserted;		 
	}

}
