package com.saib.rest.response;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY)
public class GetDomesticSingleConsentByIdResponse extends BaseResponse {

	
	private Integer responseCode;
	private String responesMsg;

	private String consentType;
	private String transactionType;
	
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

	public Integer getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponesMsg() {
		return responesMsg;
	}

	public void setResponesMsg(String responesMsg) {
		this.responesMsg = responesMsg;
	}

}
