package com.walmart.ecomm.services.test;

import javax.ws.rs.core.MediaType;
import junit.framework.Assert;


import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource.Builder;

public class ItemServiceTest extends BaseServiceTest {
	
	// Testing the URL Availability
	@Test
	public void testURLAvailability() {
		String result = webRes.get(String.class);
		Assert.assertNotNull(result);
		System.out.println("Response: " + result);
	}
	
	// Testing the Content Type
	@Test
	public void testContentType() {
		try {
			Builder clientReqBuilder = webRes.accept(MediaType.APPLICATION_JSON);			
			String result = clientReqBuilder.get(String.class);
			Assert.assertNotNull(result);
		} catch (UniformInterfaceException ex) { // resource return code is unexpected.
			int statusCode = ex.getResponse().getClientResponseStatus().getStatusCode();
			System.out.println("status code: " + statusCode);
			Assert.fail();
			ex.printStackTrace();
		} catch (ClientHandlerException ex) { 
			ex.printStackTrace();
			Assert.fail();
		}
	}
	
	// Testing the JSON Validity
	@Test
	public void testValidJson() {
		try {
			Builder clientReqBuilder = webRes.accept(MediaType.APPLICATION_JSON);			
			String result = clientReqBuilder.get(String.class);
			Assert.assertNotNull(result);
			JSONObject json = new JSONObject(result);
			
			System.out.println("item="+json.getDouble("item_id"));
			Assert.assertNotNull(json);
		} catch (UniformInterfaceException ex) { // resource return code is unexpected.
			int statusCode = ex.getResponse().getClientResponseStatus().getStatusCode();
			System.out.println("status code: " + statusCode);
			Assert.fail();			
		} catch (ClientHandlerException ex) { // error in client handler while processing
			Assert.fail();
		} catch (JSONException ex){
			Assert.fail();
		}
	}
	
	// Parsing the JSON for values	
	@Test
	public void testParseJson() {
		try {
			Builder clientReqBuilder = webRes.accept(MediaType.APPLICATION_JSON);			
			String result = clientReqBuilder.get(String.class);
			Assert.assertNotNull(result);
			JSONObject json = new JSONObject(result);
			Assert.assertNotNull(json);
			long itemId=json.getLong("item_id");
			Assert.assertNotNull(itemId);
			System.out.println("itemId="+itemId);
			long localeId=json.getLong("item_id");
			Assert.assertNotNull(localeId);
			System.out.println("locale="+localeId);		
			
		} catch (UniformInterfaceException ex) { // resource return code is unexpected.
			int statusCode = ex.getResponse().getClientResponseStatus().getStatusCode();
			System.out.println("status code: " + statusCode);
			Assert.fail();			
		} catch (ClientHandlerException ex) { // error in client handler while processing
			Assert.fail();
		} catch (JSONException ex){
			Assert.fail();
		}
	}
}
