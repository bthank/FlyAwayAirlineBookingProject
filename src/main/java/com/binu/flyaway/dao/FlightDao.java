package com.binu.flyaway.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.binu.flyaway.dto.Flight;
import com.binu.flyaway.dto.TravelSearchDetail;

public interface FlightDao {

	void connect() throws SQLException;
	void disconnect() throws SQLException;
	boolean addFlight(Flight flight) throws SQLException;
	List<Flight> listAllFlights() throws SQLException, ParseException;
	boolean deleteFlight(Flight flight) throws SQLException;
	boolean updateFlight(Flight flight) throws SQLException;
	List<Flight> findFlights(TravelSearchDetail travelSearchDetail) throws SQLException;
	Flight getFlight(Integer id) throws SQLException;
	
	
}
