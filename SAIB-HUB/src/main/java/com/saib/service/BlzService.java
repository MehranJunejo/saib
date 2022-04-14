package com.saib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

 import com.saib.consumer.BLZServiceClient;
import com.saib.dto.BLZServiceDTO;
import com.saib.model.LogsModel;
import com.saib.repository.LogsRepo;
import com.saib.rest.request.GetDetailsByBlzCodeRequest;
import com.saib.rest.response.GetDetailsByBlzCodeResponse;
import com.saib.util.LogUtils;
 
@Service
public class BlzService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BlzService.class);
	
	@Autowired
	private BLZServiceClient blzServiceClient;
	
	@Autowired
	private LogsRepo logsRepo;
	
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	public GetDetailsByBlzCodeResponse getDetailsByBlzCode(GetDetailsByBlzCodeRequest request) {
		
		LOGGER.debug("getDetailsByBlzCode Service");
		GetDetailsByBlzCodeResponse response  = new GetDetailsByBlzCodeResponse(); 

		BLZServiceDTO bLZServiceDTO = new BLZServiceDTO();
		bLZServiceDTO.setBlzCode(request.getBlzCode());
		LOGGER.debug("Request Parameter Mapping for getBankDetails"+bLZServiceDTO.toString());
		blzServiceClient.getBankDetails(bLZServiceDTO);
		if(bLZServiceDTO.getDetailsType() != null )
		{
			LOGGER.debug("getBankDetails reponse recieved.");
			response.setResponseCode(0000000);
			response.setResponesMsg("SUCCESS");
			response.setBankDetails(bLZServiceDTO.getDetailsType());
			
			
		}
		LOGGER.debug("GetDetailsByBlzCodeResponse Response sent to client "+response.toString());
		LogsModel logsModel = LogUtils.getLogObject(request, "TransationId", response.toString(),  "BlzService", applicationName);
		logsRepo.save(logsModel);

		return response;
	}
}
