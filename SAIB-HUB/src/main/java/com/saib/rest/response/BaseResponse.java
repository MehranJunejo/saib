package com.saib.rest.response;


public class BaseResponse {

	
	private Integer responseCode ;
	private String responesMsg ;
	private String errorMessage;
	
	
	
	
	
	
	
	

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
