package com.saib.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.saib.rest.request.AddDomesticSinglePaymentRequest;
import com.saib.rest.response.AddDomesticSinglePaymentResponse;
import com.saib.rest.response.GetDomesticSinglePaymentByIdResponse;
import com.saib.rest.response.GetDomesticSinglePaymentStatusByIdResponse;
  
@Service
public class DomesticSinglePaymentService {

	
	@Value("${domestic.single.response}")	
 	private String domesticSingleResponse;
	
	
	public AddDomesticSinglePaymentResponse addDomesticSinglePaymentStatus(AddDomesticSinglePaymentRequest request) {
		AddDomesticSinglePaymentResponse response = new AddDomesticSinglePaymentResponse();

		response.setResponesMsg(domesticSingleResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public GetDomesticSinglePaymentByIdResponse getDomesticSinglePaymentById(long id) {
		GetDomesticSinglePaymentByIdResponse response = new GetDomesticSinglePaymentByIdResponse();

		response.setResponesMsg(domesticSingleResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	
	public GetDomesticSinglePaymentStatusByIdResponse getDomesticSinglePaymentStatusById(long id) {
		GetDomesticSinglePaymentStatusByIdResponse response = new GetDomesticSinglePaymentStatusByIdResponse();

		response.setResponesMsg(domesticSingleResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public GetDomesticSinglePaymentByIdResponse deleteDomesticSinglePaymentStatusById(long id) {
		GetDomesticSinglePaymentByIdResponse response = new GetDomesticSinglePaymentByIdResponse();

		response.setResponesMsg(domesticSingleResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
}
