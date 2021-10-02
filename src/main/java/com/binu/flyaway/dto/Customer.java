package com.binu.flyaway.dto;

/**
 * Class representing a customer data transfer object between java and the database
 */
public class Customer {
	
	private Integer customerId;
	private String firstName;
	private String lastName;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNo;
	
	private Integer noOfTravelers;

	public Customer() {
		
	}
	
	public Customer(String firstName, String lastName, String addressLine1, String addressLine2,
			String city, String state, String zipCode, String phoneNo, Integer noOfTravelers) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.noOfTravelers = noOfTravelers;
	}	

	public Customer(Integer customerId, String firstName, String lastName, String addressLine1, String addressLine2,
			String city, String state, String zipCode, String phoneNo, Integer noOfTravelers) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phoneNo = phoneNo;
		this.noOfTravelers = noOfTravelers;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getNoOfTravelers() {
		return noOfTravelers;
	}

	public void setNoOfTravelers(Integer noOfTravelers) {
		this.noOfTravelers = noOfTravelers;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + ", phoneNo=" + phoneNo + ", noOfTravelers=" + noOfTravelers + "]";
	}
	
	
	
	
}
