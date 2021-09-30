package com.binu.flyaway.dto;

import java.util.Date;

/**
 * Flight.java
 * This is a model class that represents a flight entity
 *  
 *
 */
public class Flight {
	
	private Integer id;
	
	private String sourceAirport;
	private String destinationAirport;
	private Date departureDate;
	private Double fare;
	private Integer numberAvailableSeats;
	private String airline;
	
	private static Integer maxId = 0;
	
	public Flight() {
		 
	}

	public Flight(Integer id) {

		this.id = id;
		
	}

	public Flight(String sourceAirport, String destinationAirport, Date departureDate, Double fare,
			Integer numberAvailableSeats,String airline) {

		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.departureDate = departureDate;
		this.fare = fare;
		this.numberAvailableSeats = numberAvailableSeats;
		this.airline = airline;
	}

	
	public Flight(Integer id, String sourceAirport, String destinationAirport, Date departureDate, Double fare,
			Integer numberAvailableSeats,String airline) {

		this.id = id;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.departureDate = departureDate;
		this.fare = fare;
		this.numberAvailableSeats = numberAvailableSeats;
		this.airline = airline;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public Integer getNumberAvailableSeats() {
		return numberAvailableSeats;
	}

	public void setNumberAvailableSeats(Integer numberAvailableSeats) {
		this.numberAvailableSeats = numberAvailableSeats;
	}
	
	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public static Integer getMaxId() {
		return maxId;
	}

	public static void setMaxId(Integer maxId) {
		Flight.maxId = maxId;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", sourceAirport=" + sourceAirport + ", destinationAirport=" + destinationAirport
				+ ", departureDate=" + departureDate + ", fare=" + fare + ", numberAvailableSeats="
				+ numberAvailableSeats + ", airline=" + airline + "]";
	}


	

}
