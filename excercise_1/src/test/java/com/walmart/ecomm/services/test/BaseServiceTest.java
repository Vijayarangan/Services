package com.walmart.ecomm.services.test;

import org.junit.After;
import org.junit.Before;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class BaseServiceTest {

	protected static WebResource webRes;
	
	
	@Before
	public void setUp() throws Exception {
		// Set Up the required Connection like DB, loggers, etc		
		System.out.println("Testing Starts");
		int itemId = (int)(Math.random() * 8847);
		webRes= Client.create().resource("http://localhost:8080/services/Items/"+itemId);
	}


	@After
	public void tearDown() throws Exception {
		//Close all required connections,etc
		System.out.println("Testing Complete");
	}


}
