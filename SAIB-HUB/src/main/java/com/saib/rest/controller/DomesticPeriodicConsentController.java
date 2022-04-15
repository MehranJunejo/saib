package com.saib.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saib.common.CommonUtil;
import com.saib.rest.request.AddDomesticPeriodicConsentRequest;
import com.saib.rest.response.AddDomesticPeriodicConsentResponse;
import com.saib.rest.response.GetDomesticPeriodicConsentByIdResponse;
import com.saib.service.DomesticPeriodicConsentService;
 
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@RequestMapping("/domestic-periodic-consent/")
@OpenAPIDefinition(info = @Info(title = "Domestic Periodic consent Services", version = "1.0",description = "All endpoints of Domestic Periodic consent"))
public class DomesticPeriodicConsentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DomesticPeriodicConsentController.class);

	@Autowired
	private DomesticPeriodicConsentService domesticPeriodicConsentService;
	
	
	@Operation(summary = "Retrieve the domestic consent details", description = "Retrieve the domestic consent details by id", tags = "GET")
	@GetMapping(value = "v1/{domesticPeriodicConsentId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GetDomesticPeriodicConsentByIdResponse> getDomesticPaymentById(
			@PathVariable  Long domesticPeriodicConsentId) {
	
    		HttpHeaders httpHeaders = new HttpHeaders();
    		GetDomesticPeriodicConsentByIdResponse response = domesticPeriodicConsentService.addDomesticPeriodicConsentById(domesticPeriodicConsentId);
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
	}		
	
	
	
	
	
	@Operation(summary = "add domestic consent", description = "add domestic consent", tags = "POST")
	@PostMapping(value = "v1", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<AddDomesticPeriodicConsentResponse> postDomesticConsent(
			@RequestBody AddDomesticPeriodicConsentRequest request) {
		
		AddDomesticPeriodicConsentResponse response = new AddDomesticPeriodicConsentResponse();
		 
		HttpHeaders httpHeaders = new HttpHeaders();
		
		try {

			LOGGER.debug("Inside getDetailsByBlzCode Controller" + request.toString());

			if (CommonUtil.isNullOrEmty(request.getLang())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg("Language is null or empty");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			if (CommonUtil.isNullOrEmty(request.getName())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg("name is null or empty");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			
			if (CommonUtil.isNullOrEmty(request.getConsentType())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg("Consent Type is null or empty");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			
			if (CommonUtil.isNullOrEmty(request.getTransactionType())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg("Transaction Type is null or empty");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			response = domesticPeriodicConsentService.addDomesticPeriodicConsent(request);

		} catch (Throwable e) {

			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponesMsg("Something went wrong.");
			response.setErrorMessage(CommonUtil.getException(e));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} finally {
			
		}

		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
		
	}
	
	
	
	
}
