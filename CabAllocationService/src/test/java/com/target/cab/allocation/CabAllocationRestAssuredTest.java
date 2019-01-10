package com.target.cab.allocation;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class CabAllocationRestAssuredTest {

	@Test
	public void restAssuredIntegrationTest() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray inputJsonList = (JSONArray)parser.parse(new FileReader("src/test/resources/testinput.json"));
		
		for(Object inputJson : inputJsonList) {
			JSONObject input = (JSONObject)inputJson;
			String host = (String)input.get("host");
			String restEndpoint = (String)input.get("restAPIEndPoint");
			String method = (String)input.get("method");
			JSONObject body = (JSONObject)input.get("body");
			Response response = null;
			
			if("POST".equalsIgnoreCase(method)) {
			  response = RestAssured.given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(body)
						.when()
						.post(host + restEndpoint);
			} else {
				response = RestAssured.given().contentType(ContentType.JSON).get();
			}
			
			ResponseBody responseBody = response.getBody();
			String responseBodyString = responseBody.asString();
			
			assertTrue("Success", responseBodyString.contains("Success"));
		}
	}
}
