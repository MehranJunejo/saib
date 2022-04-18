package com.saib.service;

import java.sql.Timestamp;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.saib.common.Internationalization;
import com.saib.model.ConsentModel;
import com.saib.repository.ConsentRepo;
import com.saib.rest.request.AddDomesticSingleConsentRequest;
import com.saib.rest.response.AddDomesticSingleConsentResponse;
import com.saib.rest.response.GetDomesticSingleConsentByIdResponse;
  
@Service
public class DomesticSingleConsentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DomesticSingleConsentService.class);

	@Autowired
	private Internationalization internationalization;
	
	@Autowired
	private ConsentRepo consentRepo;
	
	public AddDomesticSingleConsentResponse addDomesticSingleConsent(AddDomesticSingleConsentRequest request) {
		LOGGER.debug("Inside DomesticSingleConsentService addDomesticSingleConsent");
		AddDomesticSingleConsentResponse response = new AddDomesticSingleConsentResponse();

		ConsentModel consentModel = new ConsentModel();
		consentModel.setName(request.getName());
		consentModel.setTransactionType(request.getTransactionType());
		consentModel.setConsentType(request.getConsentType());
		consentModel.setCreatedBy("Mehran"); // Temp hard coded, will be changed 
		consentModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		
		consentModel =	consentRepo.save(consentModel); // adding to db

		response.setId(consentModel.getId());
		response.setName(consentModel.getName());
		response.setConsentType(consentModel.getConsentType());
		response.setTransactionType(consentModel.getTransactionType());
		response.setCreatedBy(consentModel.getCreatedBy());
		response.setCreatedDate(consentModel.getCreatedDate());
		response.setResponesMsg(internationalization.messageResource().getMessage("domestic.payment.constent.create", null, new Locale(request.getLang())));
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public GetDomesticSingleConsentByIdResponse getDomesticSingleConsentById(Long id,String lang) {
		LOGGER.debug("Inside DomesticSingleConsentService getDomesticSingleConsentById");
		GetDomesticSingleConsentByIdResponse response = new GetDomesticSingleConsentByIdResponse();
		ConsentModel consentModel=null;

		Optional<ConsentModel> otpional=consentRepo.findById(id);
		if(otpional.isPresent()){ 
			  consentModel = otpional.get();
			  response.setConsentType(consentModel.getConsentType());
				response.setTransactionType(consentModel.getTransactionType());
				response.setResponesMsg(internationalization.messageResource()
						.getMessage("domestic.payment.constent.found", null, new Locale(lang)));
				response.setResponseCode(HttpStatus.OK.value());
						response.setResponseCode(HttpStatus.OK.value());
	
		 }
		else {
			response.setResponesMsg(internationalization.messageResource().getMessage("base.response.not.found", null,
				new Locale(lang)));
		response.setResponseCode(HttpStatus.NOT_FOUND.value());}
		
 		return response;
	}
	
}
