package controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.saib.rest.response.GetDomesticSingleConsentByIdResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class FirstTest {

    RestTemplate restTemplate = new RestTemplate();

	 @LocalServerPort
	    int randomServerPort;
	     
	    @Test
	    public void testGetEmployeeListSuccess() throws URISyntaxException 
	    {
	 
	    	
	    	 final String baseUrl = "http://localhost:8081/domestic-single-consent/v1/1";
	    	    URI uri = new URI(baseUrl);
	    	    ResponseEntity<GetDomesticSingleConsentByIdResponse> result = restTemplate.getForEntity(uri, GetDomesticSingleConsentByIdResponse.class);
	    	   // Assert.assertEquals(200, result.getStatusCodeValue());
	    	    GetDomesticSingleConsentByIdResponse obj=  result.getBody();
	    	    Assert.assertEquals("Domestic", obj.getConsentType());

	    	    
	    }  
	
}
