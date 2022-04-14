package com.saib.rest.response;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY)
public class GetDomesticSinglePaymentByIdResponse extends BaseResponse {


	private Integer responseCode;
	private String responesMsg;

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
