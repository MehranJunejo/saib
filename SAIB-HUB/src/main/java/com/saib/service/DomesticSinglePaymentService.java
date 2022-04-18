package com.saib.service;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.saib.common.Internationalization;
import com.saib.rest.request.AddDomesticSinglePaymentRequest;
import com.saib.rest.response.AddDomesticSinglePaymentResponse;
import com.saib.rest.response.GetDomesticSinglePaymentByIdResponse;
import com.saib.rest.response.GetDomesticSinglePaymentStatusByIdResponse;
  
@Service
public class DomesticSinglePaymentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DomesticSinglePaymentService.class);

	@Autowired
	private Internationalization internationalization;
	 
	public AddDomesticSinglePaymentResponse addDomesticSinglePaymentStatus(AddDomesticSinglePaymentRequest request) {
		LOGGER.debug("Inside DomesticSinglePaymentService addDomesticSinglePaymentStatus");
		AddDomesticSinglePaymentResponse response = new AddDomesticSinglePaymentResponse();

		response.setResponesMsg(internationalization.messageResource()
				.getMessage("domestic.payment.constent.found", null, new Locale(request.getLang())));
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public GetDomesticSinglePaymentByIdResponse getDomesticSinglePaymentById(long id,String lang) {
		LOGGER.debug("Inside DomesticSinglePaymentService getDomesticSinglePaymentById");
		GetDomesticSinglePaymentByIdResponse response = new GetDomesticSinglePaymentByIdResponse();

		response.setResponesMsg(internationalization.messageResource()
				.getMessage("domestic.payment.constent.found", null, new Locale(lang)));	
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	
	public GetDomesticSinglePaymentStatusByIdResponse getDomesticSinglePaymentStatusById(long id,String lang) {
		LOGGER.debug("Inside DomesticSinglePaymentService getDomesticSinglePaymentStatusById");
		GetDomesticSinglePaymentStatusByIdResponse response = new GetDomesticSinglePaymentStatusByIdResponse();

		response.setResponesMsg(internationalization.messageResource()
				.getMessage("domestic.payment.constent.found", null, new Locale(lang)));
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public GetDomesticSinglePaymentByIdResponse deleteDomesticSinglePaymentStatusById(long id, String lang) {
		LOGGER.debug("Inside DomesticSinglePaymentService deleteDomesticSinglePaymentStatusById");
		GetDomesticSinglePaymentByIdResponse response = new GetDomesticSinglePaymentByIdResponse();

		response.setResponesMsg(internationalization.messageResource()
				.getMessage("domestic.payment.constent.found", null, new Locale(lang)));
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
}
