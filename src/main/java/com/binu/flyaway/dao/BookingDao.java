package com.binu.flyaway.dao;

import java.sql.SQLException;

import com.binu.flyaway.dto.Booking;

/**
 * BookingDao.java
 * This is the interface representing the available data access methods for the Booking class
 *  
 */
public interface BookingDao {

	void connect() throws SQLException;
	void disconnect() throws SQLException;
	boolean  addBooking(Booking booking) throws SQLException;
}
