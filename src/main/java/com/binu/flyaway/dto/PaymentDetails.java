package com.binu.flyaway.dto;

/**
 * Class representing a payment details data transfer object between java and the database
 */
public class PaymentDetails {

	private Integer paymentId;
	
	private Integer paymentType; // 1=Credit Card, 2=Debit Card
	private String cardNo;
	private Integer cardExpirationMonth;
	private Integer cardExpirationYear;
	private Integer cardCvvCode;
	
	private String billingFirstName;
	private String billingLastName;
	private String billingAddressLine1;
	private String billingAddressLine2;
	private String billingCity;
	private String billingState;
	private String billingZipCode;
	private String billingPhoneNo;
	
	public PaymentDetails() {
 
	}

	public PaymentDetails(Integer paymentType, String cardNo, Integer cardExpirationMonth, Integer cardExpirationYear,
			Integer cardCvvCode, String billingFirstName, String billingLastName, String billingAddressLine1,
			String billingAddressLine2, String billingCity, String billingState, String billingZipCode,
			String billingPhoneNo) {
		super();
		this.paymentType = paymentType;
		this.cardNo = cardNo;
		this.cardExpirationMonth = cardExpirationMonth;
		this.cardExpirationYear = cardExpirationYear;
		this.cardCvvCode = cardCvvCode;
		this.billingFirstName = billingFirstName;
		this.billingLastName = billingLastName;
		this.billingAddressLine1 = billingAddressLine1;
		this.billingAddressLine2 = billingAddressLine2;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZipCode = billingZipCode;
		this.billingPhoneNo = billingPhoneNo;
	}

	public PaymentDetails(Integer paymentId, Integer paymentType, String cardNo, Integer cardExpirationMonth,
			Integer cardExpirationYear, Integer cardCvvCode, String billingFirstName, String billingLastName,
			String billingAddressLine1, String billingAddressLine2, String billingCity, String billingState,
			String billingZipCode, String billingPhoneNo) {
		super();
		this.paymentId = paymentId;
		this.paymentType = paymentType;
		this.cardNo = cardNo;
		this.cardExpirationMonth = cardExpirationMonth;
		this.cardExpirationYear = cardExpirationYear;
		this.cardCvvCode = cardCvvCode;
		this.billingFirstName = billingFirstName;
		this.billingLastName = billingLastName;
		this.billingAddressLine1 = billingAddressLine1;
		this.billingAddressLine2 = billingAddressLine2;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZipCode = billingZipCode;
		this.billingPhoneNo = billingPhoneNo;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getCardExpirationMonth() {
		return cardExpirationMonth;
	}

	public void setCardExpirationMonth(Integer cardExpirationMonth) {
		this.cardExpirationMonth = cardExpirationMonth;
	}

	public Integer getCardExpirationYear() {
		return cardExpirationYear;
	}

	public void setCardExpirationYear(Integer cardExpirationYear) {
		this.cardExpirationYear = cardExpirationYear;
	}

	public Integer getCardCvvCode() {
		return cardCvvCode;
	}

	public void setCardCvvCode(Integer cardCvvCode) {
		this.cardCvvCode = cardCvvCode;
	}

	public String getBillingFirstName() {
		return billingFirstName;
	}

	public void setBillingFirstName(String billingFirstName) {
		this.billingFirstName = billingFirstName;
	}

	public String getBillingLastName() {
		return billingLastName;
	}

	public void setBillingLastName(String billingLastName) {
		this.billingLastName = billingLastName;
	}

	public String getBillingAddressLine1() {
		return billingAddressLine1;
	}

	public void setBillingAddressLine1(String billingAddressLine1) {
		this.billingAddressLine1 = billingAddressLine1;
	}

	public String getBillingAddressLine2() {
		return billingAddressLine2;
	}

	public void setBillingAddressLine2(String billingAddressLine2) {
		this.billingAddressLine2 = billingAddressLine2;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public String getBillingZipCode() {
		return billingZipCode;
	}

	public void setBillingZipCode(String billingZipCode) {
		this.billingZipCode = billingZipCode;
	}

	public String getBillingPhoneNo() {
		return billingPhoneNo;
	}

	public void setBillingPhoneNo(String billingPhoneNo) {
		this.billingPhoneNo = billingPhoneNo;
	}

	@Override
	public String toString() {
		return "PaymentDetails [paymentId=" + paymentId + ", paymentType=" + paymentType + ", cardNo=" + cardNo
				+ ", cardExpirationMonth=" + cardExpirationMonth + ", cardExpirationYear=" + cardExpirationYear
				+ ", cardCvvCode=" + cardCvvCode + ", billingFirstName=" + billingFirstName + ", billingLastName="
				+ billingLastName + ", billingAddressLine1=" + billingAddressLine1 + ", billingAddressLine2="
				+ billingAddressLine2 + ", billingCity=" + billingCity + ", billingState=" + billingState
				+ ", billingZipCode=" + billingZipCode + ", billingPhoneNo=" + billingPhoneNo + "]";
	}


	
}
