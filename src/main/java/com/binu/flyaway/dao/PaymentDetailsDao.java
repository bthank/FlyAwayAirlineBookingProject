package com.binu.flyaway.dao;

import java.sql.SQLException;

import com.binu.flyaway.dto.PaymentDetails;

/**
 * PaymentDetailsDao.java
 * This is the interface representing the available data access methods for the PaymentDetails class
 *  
 */
public interface PaymentDetailsDao {

	void connect() throws SQLException;
	void disconnect() throws SQLException;
	boolean addPaymentDetails(PaymentDetails paymentDetails) throws SQLException;
}
