package com.binu.flyaway.dto;

import java.sql.Date;

/**
 * TravelSearchDetail.java
 * This is a pojo class that represents the travel details a user enters on the flight search page
 *  
 *
 */
public class TravelSearchDetail {

	private String sourceAirport;
	private String destinationAirport;
	
	private Date departureDate;
	
	private Integer numberTraveling;

	public TravelSearchDetail() {
		
	}

	public TravelSearchDetail(String sourceAirport, String destinationAirport, Date departureDate,
			Integer numberTraveling) {

		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.departureDate = departureDate;
		this.numberTraveling = numberTraveling;
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

	public Integer getNumberTraveling() {
		return numberTraveling;
	}

	public void setNumberTraveling(Integer numberTraveling) {
		this.numberTraveling = numberTraveling;
	}

	@Override
	public String toString() {
		return "TravelSearchDetail [sourceAirport=" + sourceAirport + ", destinationAirport=" + destinationAirport
				+ ", departureDate=" + departureDate + ", numberTraveling=" + numberTraveling + "]";
	}
	
	
	
	
}
