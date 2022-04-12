package com.saib.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.saib.common.Constants;

@Configuration
public class ServiceMarsheller {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.saib.consumer.stub");
		return marshaller;
	}
	
	@Bean
	public BLZServiceClient soapConnector(Jaxb2Marshaller marshaller) {
		BLZServiceClient client = new BLZServiceClient();
	client.setDefaultUri(Constants.BLZ_SERVICE_URL);
	client.setMarshaller(marshaller);
	client.setUnmarshaller(marshaller);
	return client;
	}
}
