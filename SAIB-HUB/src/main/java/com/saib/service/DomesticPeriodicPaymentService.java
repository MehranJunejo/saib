package com.saib.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.saib.rest.request.AddDomesticPeriodicPaymentRequest;
import com.saib.rest.response.AddDomesticPeriodicPaymentResponse;
import com.saib.rest.response.DeleteDomesticPeriodicPaymentResponse;
import com.saib.rest.response.GetDomesticPeriodicPaymentByIdResponse;
import com.saib.rest.response.GetDomesticPeriodicPaymentStatusByIdResponse;
  
@Service
public class DomesticPeriodicPaymentService {
	
	@Value("${domestic.single.response}")	
 	private String domesticPeriodicResponse;
	
	public AddDomesticPeriodicPaymentResponse addDomesticPeriodicPayment(AddDomesticPeriodicPaymentRequest request) {
		AddDomesticPeriodicPaymentResponse response = new AddDomesticPeriodicPaymentResponse();

		response.setResponesMsg(domesticPeriodicResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
	}
	
	public GetDomesticPeriodicPaymentByIdResponse getDomesticPeriodicPaymentById(long id) {
		GetDomesticPeriodicPaymentByIdResponse response = new GetDomesticPeriodicPaymentByIdResponse();

		response.setResponesMsg(domesticPeriodicResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	
	public GetDomesticPeriodicPaymentStatusByIdResponse getDomesticPeriodicPaymentStatusById(long id) {
		GetDomesticPeriodicPaymentStatusByIdResponse response = new GetDomesticPeriodicPaymentStatusByIdResponse();

		response.setResponesMsg(domesticPeriodicResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public DeleteDomesticPeriodicPaymentResponse deleteDomesticPeriodicPaymentStatusById(long id) {
		DeleteDomesticPeriodicPaymentResponse response = new DeleteDomesticPeriodicPaymentResponse();

		response.setResponesMsg(domesticPeriodicResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
}
