package com.saib.rest.request;

public class AddDomesticPeriodicConsentRequest extends BaseRequest {
	
	private String name;
	private String consentType;
	private String transactionType; 

	 
 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getConsentType() {
		return consentType;
	}


	public void setConsentType(String consentType) {
		this.consentType = consentType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "addDomesticPaymentRequest [paymentName=" + name + "]";
	}


}
