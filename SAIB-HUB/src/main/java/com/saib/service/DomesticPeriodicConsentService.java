package com.saib.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.saib.model.ConsentModel;
import com.saib.repository.ConsentRepo;
import com.saib.rest.request.AddDomesticPeriodicConsentRequest;
import com.saib.rest.response.AddDomesticPeriodicConsentResponse;
import com.saib.rest.response.GetDomesticPeriodicConsentByIdResponse;
 
@Service
public class DomesticPeriodicConsentService {

	

	@Autowired
	private ConsentRepo consentRepo;
	
	@Value("${domestic.single.response}")	
 	private String domesticSingleResponse;
	
	
	public AddDomesticPeriodicConsentResponse addDomesticPeriodicConsent(AddDomesticPeriodicConsentRequest request) {
		AddDomesticPeriodicConsentResponse response = new AddDomesticPeriodicConsentResponse();

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
		response.setResponesMsg(domesticSingleResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public GetDomesticPeriodicConsentByIdResponse addDomesticPeriodicConsentById(Long id) {
		GetDomesticPeriodicConsentByIdResponse response = new GetDomesticPeriodicConsentByIdResponse();
		ConsentModel consentModel=null;

		Optional<ConsentModel> otpional=consentRepo.findById(id);
		if(otpional.isPresent()){ 
			  consentModel = otpional.get();
		 }
		
		response.setConsentType(consentModel.getConsentType());
		response.setTransactionType(consentModel.getTransactionType());
		response.setResponesMsg(domesticSingleResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
	}
	
}
