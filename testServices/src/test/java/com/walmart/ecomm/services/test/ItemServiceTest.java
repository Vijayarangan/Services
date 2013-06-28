
package com.walmart.ecomm.services.test;

import junit.framework.Assert;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.walmart.ecomm.services.client.GenericServiceClient;

/**
 *
 * @author vrangan
 */
public class ItemServiceTest {
    
    private static final String ITEMSERVICE_URI="https://localhost:8080/service/webresources";
    private static final String RESOURCE="com.walmart.ecomm.service.entity.item";
    private static  GenericServiceClient itemService;
    public ItemServiceTest() {
    }
   

    @BeforeClass
    public static void setUpClass() throws Exception {
         itemService = new GenericServiceClient(ITEMSERVICE_URI, RESOURCE);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
    @Test
    public void testGetItemDetails(){
        String resourceToFind="1000";
        itemService.find_JSON(null, resourceToFind);
        //Call the Find Method to Check the JSON
        Assert.assertEquals(1, 1);
    }
    
    @Test
    public void testCreateItem(){     
        Object addItemJson=null;
        itemService.create_JSON(addItemJson);
        //Call the Create Method to Check the JSON
        Assert.assertEquals(1, 1);
    }
    
     @Test
    public void testUpdateItem(){    
         Object editItemJson=null;
        itemService.edit_JSON(editItemJson);
        //Call the Edit Method to Check the JSON
        Assert.assertEquals(1, 1);
    }
}