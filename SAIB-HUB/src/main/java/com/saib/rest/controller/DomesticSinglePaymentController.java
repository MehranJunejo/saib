package com.saib.rest.controller;

import java.util.Locale;

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
import com.saib.common.Internationalization;
import com.saib.rest.request.AddDomesticSinglePaymentRequest;
import com.saib.rest.response.AddDomesticSinglePaymentResponse;
import com.saib.rest.response.GetDomesticSinglePaymentByIdResponse;
import com.saib.rest.response.GetDomesticSinglePaymentStatusByIdResponse;
import com.saib.service.DomesticSinglePaymentService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@RequestMapping("/domestic-single-payment/")
@OpenAPIDefinition(info = @Info(title = "Domestic single Payment Services", version = "1.0",description = "All endpoints of Domestic single Payment"))
public class DomesticSinglePaymentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DomesticSinglePaymentController.class);

	@Autowired
	private Internationalization internationalization;
	
	@Autowired
	private DomesticSinglePaymentService domesticSinglePaymentService;

	@Operation(summary = "add domestic payment", description = "add domestic payment", tags = "POST")
	@PostMapping(value = "v1", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<AddDomesticSinglePaymentResponse> postDomesticPayment(
			@RequestBody AddDomesticSinglePaymentRequest request) {
		
		AddDomesticSinglePaymentResponse response = new AddDomesticSinglePaymentResponse();
		HttpHeaders httpHeaders = new HttpHeaders();
		
		try {

			LOGGER.debug("Inside /v1 postDomesticPayment ");

			if (CommonUtil.isNullOrEmty(request.getLang())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg(internationalization.messageResource()
						.getMessage("base.request.lang.empty", null, new Locale(request.getLang())));
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			
			if (CommonUtil.isNullOrEmty(request.getPaymentName())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg(internationalization.messageResource()
						.getMessage("base.request.name.empty", null, new Locale(request.getLang())));			
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			response = domesticSinglePaymentService.addDomesticSinglePaymentStatus(request);

		} catch (Throwable e) {

			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponesMsg("Something went wrong.");
			response.setErrorMessage(CommonUtil.getException(e));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} finally {
		}

		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
	}
	
	
	@Operation(summary = "Retrieve the domestic payment details", description = "Retrieve the domestic payment details by id", tags = "GET")
	@GetMapping(value = "v1/{domesticPaymentId}/{lang}" , produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GetDomesticSinglePaymentByIdResponse> getDomesticPaymentById(
			@PathVariable  Long domesticPaymentId, @PathVariable String lang) {
	
    		HttpHeaders httpHeaders = new HttpHeaders();
    		GetDomesticSinglePaymentByIdResponse response = new GetDomesticSinglePaymentByIdResponse();
		
    		try {
    			LOGGER.debug("Inside /v1/{domesticPaymentId} getDomesticPaymentById ");
        		 response = domesticSinglePaymentService.getDomesticSinglePaymentById(domesticPaymentId,lang);

    		} catch (Throwable e) {

    			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    			response.setResponesMsg("Something went wrong.");
    			response.setErrorMessage(CommonUtil.getException(e));
    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    		} finally {
    		}
			return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
	}	
 

	@Operation(summary = "Retrieve the domestic payment details status ", description = "Retrieve the domestic payment details status by id", tags = "GET")
	@GetMapping(value = "v1/{domesticPaymentId}/{lang}/status" , produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GetDomesticSinglePaymentStatusByIdResponse> getDomesticPaymentStatusById(
			@PathVariable  Long domesticPaymentId, @PathVariable String lang) {
	
    		HttpHeaders httpHeaders = new HttpHeaders();
    		GetDomesticSinglePaymentStatusByIdResponse response=new GetDomesticSinglePaymentStatusByIdResponse();
    		try {
    			LOGGER.debug("Inside /v1/{domesticPaymentId}/status getDomesticPaymentStatusById ");
        		  response = domesticSinglePaymentService.getDomesticSinglePaymentStatusById(domesticPaymentId,lang);

    		} catch (Throwable e) {

    			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    			response.setResponesMsg("Something went wrong.");
    			response.setErrorMessage(CommonUtil.getException(e));
    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    		} finally {
    		}
    		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);
    		}	


	@Operation(summary = "Retrieve the domestic payment details", description = "Retrieve the domestic payment details by id", tags = "GET")
	@DeleteMapping(value = "v1/{domesticPaymentId}/{lang}" , produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GetDomesticSinglePaymentByIdResponse> deleteDomesticPaymentById(
			@PathVariable  Long domesticPaymentId, @PathVariable String lang) {
	
    		HttpHeaders httpHeaders = new HttpHeaders();
    		GetDomesticSinglePaymentByIdResponse response = new GetDomesticSinglePaymentByIdResponse();
		
    		try {
    			LOGGER.debug("Inside v1/{domesticPaymentId} deleteDomesticPaymentById ");
        		 response = domesticSinglePaymentService.deleteDomesticSinglePaymentStatusById(domesticPaymentId,lang);
    		
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
