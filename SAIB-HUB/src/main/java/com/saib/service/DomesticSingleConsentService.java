package com.saib.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.saib.model.ConsentModel;
import com.saib.repository.ConsentRepo;
import com.saib.rest.request.AddDomesticSingleConsentRequest;
import com.saib.rest.response.AddDomesticSingleConsentResponse;
import com.saib.rest.response.GetDomesticSingleConsentByIdResponse;
  
@Service
public class DomesticSingleConsentService {

	@Autowired
	private ConsentRepo consentRepo;
	
	@Value("${domestic.single.response}")	
 	private String domesticSingleResponse;
	
	
	public AddDomesticSingleConsentResponse addDomesticSingleConsent(AddDomesticSingleConsentRequest request) {
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
		response.setResponesMsg(domesticSingleResponse);
		response.setResponseCode(HttpStatus.OK.value());
		return response;
		
	}
	
	public GetDomesticSingleConsentByIdResponse addDomesticSingleConsentById(Long id) {
		GetDomesticSingleConsentByIdResponse response = new GetDomesticSingleConsentByIdResponse();
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
