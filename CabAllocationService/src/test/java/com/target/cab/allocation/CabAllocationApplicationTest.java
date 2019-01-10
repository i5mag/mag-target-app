package com.target.cab.allocation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CabAllocationApplicationTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void createCabs() throws Exception {
		

	    String exampleCabJson = "{\"cabs\": [{\"id\": \"cab1\",\"cost\": 2,\"capacity\": 2},{\"id\": \"cab2\",\"cost\": 1,\"capacity\":}]}";

	    RequestBuilder requestBuilder = MockMvcRequestBuilders
	            .post("/target/cabs")
	            .accept(MediaType.APPLICATION_JSON)
	            .content(exampleCabJson)
	            .contentType(MediaType.APPLICATION_JSON);

	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();

	    MockHttpServletResponse response = result.getResponse();

	    assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	}
}
