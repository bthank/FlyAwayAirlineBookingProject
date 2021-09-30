package com.binu.flyaway.dto;

public class Booking {
	
	private Integer bookingId;
	
	private Integer customerId;
	private Integer flightId;
	
	public Booking() {
	 
	}

	public Booking(Integer customerId, Integer flightId) {

		this.customerId = customerId;
		this.flightId = flightId;
	}
	
	public Booking(Integer bookingId, Integer customerId, Integer flightId) {

		this.bookingId = bookingId;
		this.customerId = customerId;
		this.flightId = flightId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", flightId=" + flightId + "]";
	}
	
	
	
}
