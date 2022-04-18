package com.saib.service;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.saib.common.Internationalization;
import com.saib.rest.request.AddDomesticPeriodicPaymentRequest;
import com.saib.rest.response.AddDomesticPeriodicPaymentResponse;
import com.saib.rest.response.DeleteDomesticPeriodicPaymentResponse;
import com.saib.rest.response.GetDomesticPeriodicPaymentByIdResponse;
import com.saib.rest.response.GetDomesticPeriodicPaymentStatusByIdResponse;
  
@Service
public class DomesticPeriodicPaymentService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DomesticPeriodicPaymentService.class);

	@Autowired
	private Internationalization internationalization;
	
	public AddDomesticPeriodicPaymentResponse addDomesticPeriodicPayment(AddDomesticPeriodicPaymentRequest request) {
		LOGGER.debug("Inside DomesticPeriodicPaymentService addDomesticPeriodicPayment");
		AddDomesticPeriodicPaymentResponse response = new AddDomesticPeriodicPaymentResponse();

		response.setResponesMsg(internationalization.messageResource()
				.getMessage("domestic.payment.constent.found", null, new Locale(request.getLang())));	
		response.setResponseCode(HttpStatus.OK.value());
		return response;
	}
	
	public GetDomesticPeriodicPaymentByIdResponse getDomesticPeriodicPaymentById(long id,String lang) {
		GetDomesticPeriodicPaymentByIdResponse response = new GetDomesticPeriodicPaymentByIdResponse();

		response.setResponesMsg(internationalization.messageResource()
				.getMessage("domestic.payment.constent.found", null, new Locale(lang)));	
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	
	public GetDomesticPeriodicPaymentStatusByIdResponse getDomesticPeriodicPaymentStatusById(long id,String lang) {
		LOGGER.debug("Inside DomesticPeriodicPaymentService getDomesticPeriodicPaymentStatusById");
		GetDomesticPeriodicPaymentStatusByIdResponse response = new GetDomesticPeriodicPaymentStatusByIdResponse();

		response.setResponesMsg(internationalization.messageResource()
				.getMessage("domestic.payment.constent.found", null, new Locale(lang)));	
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public DeleteDomesticPeriodicPaymentResponse deleteDomesticPeriodicPaymentById(long id,String lang) {
		LOGGER.debug("Inside DomesticPeriodicPaymentService deleteDomesticPeriodicPaymentById");
		DeleteDomesticPeriodicPaymentResponse response = new DeleteDomesticPeriodicPaymentResponse();

		response.setResponesMsg(internationalization.messageResource()
				.getMessage("domestic.payment.constent.found", null, new Locale(lang)));	
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
}
