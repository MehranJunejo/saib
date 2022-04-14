package com.saib.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saib.common.CommonUtil;
import com.saib.rest.request.AddDomesticPeriodicPaymentRequest;
import com.saib.rest.response.AddDomesticPeriodicPaymentResponse;
import com.saib.rest.response.DeleteDomesticPeriodicPaymentResponse;
import com.saib.rest.response.GetDomesticPeriodicPaymentByIdResponse;
import com.saib.rest.response.GetDomesticPeriodicPaymentStatusByIdResponse;
import com.saib.service.DomesticPeriodicPaymentService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@RequestMapping("/domestic-periodic-payment/")
@OpenAPIDefinition(info = @Info(title = "Domestic periodic Payment Services", version = "1.0",description = "All endpoints of Domestic periodic Payment"))
public class DomesticPeriodicPaymentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DomesticPeriodicPaymentController.class);

	
	@Autowired
	private DomesticPeriodicPaymentService domesticPeriodicPaymentService;

	@Operation(summary = "Retrieve the domestic payment details", description = "Retrieve the domestic payment details by id", tags = "GET")
	@GetMapping(value = "v1/{domesticPeriodicPaymentId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GetDomesticPeriodicPaymentByIdResponse> getDomesticPeriodicPaymentById(
			@PathVariable  Long domesticPeriodicPaymentId) {
	
    		HttpHeaders httpHeaders = new HttpHeaders();
    		GetDomesticPeriodicPaymentByIdResponse response = domesticPeriodicPaymentService.getDomesticPeriodicPaymentById(domesticPeriodicPaymentId);
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
	}	
 

	@Operation(summary = "Retrieve the domestic Periodic payment details status ", description = "Retrieve the domestic Periodic payment details status by id", tags = "GET")
	@GetMapping(value = "v1/{domesticPeriodicPaymentId}/status" , produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GetDomesticPeriodicPaymentStatusByIdResponse> getDomesticPeriodicPaymentStatusById(
			@PathVariable  Long domesticPeriodicPaymentId) {
	
    		HttpHeaders httpHeaders = new HttpHeaders();
    		GetDomesticPeriodicPaymentStatusByIdResponse response = domesticPeriodicPaymentService.getDomesticPeriodicPaymentStatusById(domesticPeriodicPaymentId);
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
	}	


	@Operation(summary = "Retrieve the domestic Periodic payment details", description = "Retrieve the domestic Periodic payment details by id", tags = "GET")
	@DeleteMapping(value = "v1/{domesticPeriodicPaymentId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<DeleteDomesticPeriodicPaymentResponse> deleteDomesticPeriodicPaymentById(
			@PathVariable  Long domesticPeriodicPaymentId) {
	
    		HttpHeaders httpHeaders = new HttpHeaders();
    		DeleteDomesticPeriodicPaymentResponse response = domesticPeriodicPaymentService.deleteDomesticPeriodicPaymentStatusById(domesticPeriodicPaymentId);
		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
	}	
 
	
	@Operation(summary = "add domestic Periodic payment", description = "add domestic Periodic payment", tags = "POST")
	@PostMapping(value = "v1", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<AddDomesticPeriodicPaymentResponse> postDomesticPeriodicPayment(
			@RequestBody AddDomesticPeriodicPaymentRequest request) {
		
		AddDomesticPeriodicPaymentResponse response = new AddDomesticPeriodicPaymentResponse();
		HttpHeaders httpHeaders = new HttpHeaders();
		
		try {

			LOGGER.debug("Inside getDetailsByBlzCode Controller" + request.toString());

			if (CommonUtil.isNullOrEmty(request.getLang())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg("Language is null or empty");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			if (CommonUtil.isNullOrEmty(request.getPaymentName())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg("blzCode is null or empty");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			response = domesticPeriodicPaymentService.addDomesticPeriodicPayment(request);

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
