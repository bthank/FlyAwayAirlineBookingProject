package com.binu.flyaway.dao;

import java.sql.SQLException;

import com.binu.flyaway.dto.Customer;
/**
 * CustomerDao.java
 * This is the interface representing the available data access methods for the Customer class
 *  
 */
public interface CustomerDao {

	void connect() throws SQLException;
	void disconnect() throws SQLException;
	boolean  addCustomer(Customer customer) throws SQLException;
}
