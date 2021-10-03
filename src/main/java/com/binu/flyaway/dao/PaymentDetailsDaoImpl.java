package com.binu.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.binu.flyaway.dto.PaymentDetails;

/**
 * PaymentDetailsDaoImpl.java
 * This is the class containing CRUD implementations of the data access methods listed in the PaymentDetailsDao interface
 *  
 */
public class PaymentDetailsDaoImpl implements PaymentDetailsDao {

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
	public PaymentDetailsDaoImpl(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	 * handles adding a payment details record to the payment_details database table using JDBC prepared statement
	 */
	@Override
	public boolean addPaymentDetails(PaymentDetails paymentDetails) throws SQLException {
		
		System.out.println("A1: In addPaymentDetails");
        String sql = "INSERT INTO payment_details (payment_type, card_no, card_exp_month, card_exp_year, card_cvv_code, billing_first_name,"
        		+ "billing_last_name, billing_addr_line1, billing_addr_line2, billing_city, billing_state, billing_zip_code, billing_phone_no) "
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        connect();
        
        System.out.println("A2: In addPaymentDetails");
        PreparedStatement statement = jdbcConnection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        System.out.println("A3: In addPaymentDetails");      
        statement.setInt(1, paymentDetails.getPaymentType());
        statement.setString(2, paymentDetails.getCardNo());
        statement.setInt(3, paymentDetails.getCardExpirationMonth());
        statement.setInt(4, paymentDetails.getCardExpirationYear());
        statement.setInt(5, paymentDetails.getCardCvvCode());
        System.out.println("A4: In addPaymentDetails");       
        statement.setString(6, paymentDetails.getBillingFirstName());
        statement.setString(7, paymentDetails.getBillingLastName());
        statement.setString(8, paymentDetails.getBillingAddressLine1());
        statement.setString(9, paymentDetails.getBillingAddressLine2());
        statement.setString(10, paymentDetails.getBillingCity());
        statement.setString(11, paymentDetails.getBillingState());
        statement.setString(12, paymentDetails.getBillingZipCode());
        statement.setString(13, paymentDetails.getBillingPhoneNo());
        System.out.println("A5: In addPaymentDetails");       
        boolean rowInserted = statement.executeUpdate() > 0;
        System.out.println("A6: In addPaymentDetails");
        
        
        // get the id of the record inserted in the database
        ResultSet rs = statement.getGeneratedKeys();
        int last_inserted_id = -1;
        if(rs.next())
        {
            last_inserted_id = rs.getInt(1);
        }
        System.out.println("In PaymentDetailDaoImpl addPaymentDetails method   last_inserted_id=" + last_inserted_id);
        paymentDetails.setPaymentId(last_inserted_id);
        
    
        statement.close();
        disconnect();
        return rowInserted;		 
	}


}
