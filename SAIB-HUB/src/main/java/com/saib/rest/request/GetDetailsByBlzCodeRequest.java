package com.saib.rest.request;

public class GetDetailsByBlzCodeRequest extends BaseRequest {
	
	private String blzCode;

	public String getBlzCode() {
		return blzCode;
	}

	public void setBlzCode(String blzCode) {
		this.blzCode = blzCode;
	}


	@Override
	public String toString() {
		return "GetDetailsByBlzCodeRequest [blzCode=" + blzCode + "]";
	}


}
