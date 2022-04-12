package com.saib.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saib.common.CommonUtil;
import com.saib.rest.request.GetDetailsByBlzCodeRequest;
import com.saib.rest.response.BaseResponse;
import com.saib.rest.response.GetDetailsByBlzCodeResponse;
import com.saib.service.BlzService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@RequestMapping("/blz/")
@OpenAPIDefinition(info = @Info(title = "BLZ Services", version = "1.0", description = "All endpoints of BLZ"))
public class BlzController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlzController.class);
	@Autowired
	private BlzService blzService;

	@Operation(summary = "Get Details By Code", description = "Return bank details using blz code", tags = "POST")
	@PostMapping(value = "getDetailsByBlzCode", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GetDetailsByBlzCodeResponse> getDetailsByBlzCode(
			@RequestBody GetDetailsByBlzCodeRequest request) {

		// Request Logging
		System.out.println("Testing");
		
		GetDetailsByBlzCodeResponse response = new GetDetailsByBlzCodeResponse();
		HttpHeaders httpHeaders = new HttpHeaders();

		try {

			LOGGER.debug("Inside getDetailsByBlzCode Controller" + request.toString());

			if (CommonUtil.isNullOrEmty(request.getLang())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg("Language is null or empty");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			if (CommonUtil.isNullOrEmty(request.getBlzCode())) {
				response.setResponseCode(HttpStatus.BAD_REQUEST.value());
				response.setResponesMsg("blzCode is null or empty");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(httpHeaders).body(response);
			}
			response = blzService.getDetailsByBlzCode(request);

		} catch (Throwable e) {

			response.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setResponesMsg("Something went wrong.");
			response.setErrorMessage(CommonUtil.getException(e));
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		} finally {
			// Response file Logging
			// DataBase Logging (Single Database HIT)
//			LOGGER.debug("Inside getDetailsByBlzCode F" + response.getErrorMessage());

		}

		return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(response);

	}

}
