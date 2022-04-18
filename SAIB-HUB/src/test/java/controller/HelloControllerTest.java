package controller;

 
import static org.junit.jupiter.api.Assertions.assertEquals;

 import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
  import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
 import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
 
import com.saib.rest.controller.DomesticSingleConsentController;
import com.saib.rest.response.GetDomesticSingleConsentByIdResponse;
 

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(DomesticSingleConsentController.class)

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {


@Autowired
private MockMvc mvc;
	
@Autowired
private TestRestTemplate restTemplate;


	@Test
	void hello2() throws Exception {
		
		GetDomesticSingleConsentByIdResponse obj = new GetDomesticSingleConsentByIdResponse();
		
		 
		ResponseEntity<GetDomesticSingleConsentByIdResponse> responseEntity	= restTemplate.getForEntity("http://localhost:8081/domestic-single-consent/v1/1",
				GetDomesticSingleConsentByIdResponse.class);
 		GetDomesticSingleConsentByIdResponse obj1 =responseEntity.getBody();
 		 System.out.println("obj.getConsentType() "+obj1.getConsentType());
 		assertEquals(obj1.getConsentType(), "Domestic");

		
//		Mockito
//        .when(restTemplate.getForEntity(
//          "http://localhost:8081/domestic-single-consent/v1/1", GetDomesticSingleConsentByIdResponse.class))
//        .thenReturn(new ResponseEntity(obj, HttpStatus.OK));
//        Assertions.assertEquals( obj.getConsentType(), null);
//        System.out.println("obj.getConsentType() "+obj.getConsentType());
  	
	}

 	void hello() throws Exception {
	
		RequestBuilder request = MockMvcRequestBuilders.get("/domestic-single-consent/v1/1");
		
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("", "");
		System.out.println(result);
		
 
	}
	 
}
