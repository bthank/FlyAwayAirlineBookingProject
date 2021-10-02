package com.binu.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.binu.flyaway.dto.Customer;
import com.binu.flyaway.dto.Flight;

/**
 * CustomerDaoImpl.java
 * This is the class containing CRUD implementations of the data access methods listed in the CustomerDao interface
 *  
 */
public class CustomerDaoImpl implements CustomerDao {

    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
	
    
	
	public CustomerDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	public boolean addCustomer(Customer customer) throws SQLException {
		
        String sql = "INSERT INTO customer (first_name, last_name, address_line_1, address_line_2, city, state, zip_code, phone_no, no_of_travelers) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
       
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setString(3, customer.getAddressLine1());
        statement.setString(4, customer.getAddressLine2());
        statement.setString(5, customer.getCity());
        statement.setString(6, customer.getState());
        statement.setString(7, customer.getZipCode());
        statement.setString(8, customer.getPhoneNo());
        statement.setInt(9, customer.getNoOfTravelers());
        
        System.out.println("In AddCustomer()   fields    customer= " + customer);
  
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;		 
		
		
	}

}
