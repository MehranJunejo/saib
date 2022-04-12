package com.saib.consumer;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.saib.common.Constants;
import com.saib.consumer.stub.GetBankResponseType;
import com.saib.consumer.stub.GetBankType;
import com.saib.consumer.stub.ObjectFactory;
import com.saib.dto.BLZServiceDTO;
import com.saib.dto.DetailsType;

public class BLZServiceClient extends WebServiceGatewaySupport {
	private static final Logger LOGGER = LoggerFactory.getLogger(BLZServiceClient.class);

	@Autowired
	public Jaxb2Marshaller marshaller;


	public BLZServiceDTO getBankDetails(BLZServiceDTO blzServiceDTO)  {
		LOGGER.debug("Inside  getBankDetails " + blzServiceDTO.toString());
		
		ObjectFactory factory = new ObjectFactory();
		GetBankType bankType = new GetBankType();
		bankType.setBlz(blzServiceDTO.getBlzCode());
		JAXBElement recievedRes = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(Constants.BLZ_SERVICE_URL, factory.createGetBank(bankType));
		GetBankResponseType res =  (GetBankResponseType) recievedRes.getValue();

		if(res != null && res.getDetails() != null )
			{
				com.saib.consumer.stub.DetailsType detailsRecieved = res.getDetails() ;
				DetailsType details = new DetailsType();
				details.setBezeichnung(detailsRecieved.getBezeichnung());
				details.setBic(detailsRecieved.getBic());
				details.setOrt(detailsRecieved.getOrt());
				details.setPlz(detailsRecieved.getPlz());
				blzServiceDTO.setDetailsType(details);
			}
			
		return blzServiceDTO;

	}
	 
}
