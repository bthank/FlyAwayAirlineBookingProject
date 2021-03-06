package com.binu.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.binu.flyaway.dto.Customer;

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
	
    
	/**
	 * Constructor that sets JDBC parameters
	 * 
	 * @param jdbcURL
	 * @param jdbcUsername
	 * @param jdbcPassword
	 */	
	public CustomerDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	 * handles adding a customer record to the customer database table using JDBC prepared statement
	 */
	@Override
	public boolean addCustomer(Customer customer) throws SQLException {
		
        String sql = "INSERT INTO customer (first_name, last_name, address_line_1, address_line_2, city, state, zip_code, phone_no, no_of_travelers) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        connect();
        
        PreparedStatement statement = jdbcConnection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
       
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
        
        
        // get the id of the record inserted in the database
        ResultSet rs = statement.getGeneratedKeys();
        int last_inserted_id = -1;
        if(rs.next())
        {
            last_inserted_id = rs.getInt(1);
        }
        System.out.println("In CustomerDaoImpl addCustomer method   last_inserted_id=" + last_inserted_id);
        customer.setCustomerId(last_inserted_id);
        
        
        statement.close();
        disconnect();
        return rowInserted;		 
		
		
	}

}
