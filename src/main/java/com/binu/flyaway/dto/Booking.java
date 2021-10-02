package com.binu.flyaway.dto;

public class Booking {
	
	private Integer bookingId;
	
	private Integer customerId;
	private Integer flightId;
	private Integer paymentId;
	
	public Booking() {
	 
	}

	public Booking(Integer customerId, Integer flightId, Integer paymentId) {
		super();
		this.customerId = customerId;
		this.flightId = flightId;
		this.paymentId = paymentId;
	}

	public Booking(Integer bookingId, Integer customerId, Integer flightId, Integer paymentId) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.flightId = flightId;
		this.paymentId = paymentId;
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

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", flightId=" + flightId
				+ ", paymentId=" + paymentId + "]";
	}
	
}
