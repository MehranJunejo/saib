package com.saib.rest.request;

public class AddDomesticPeriodicPaymentRequest extends BaseRequest {
	
	private String paymentName;

	 

	public String getPaymentName() {
		return paymentName;
	}



	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}



	@Override
	public String toString() {
		return "addDomesticPaymentRequest [paymentName=" + paymentName + "]";
	}


}
