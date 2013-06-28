
 
package com.walmart.ecomm.services.client;

import com.sun.jersey.api.client.UniformInterfaceException;

/**
 *
 * @author vrangan
 */
public interface ServiceClientInterface {
    // For Fetching All Avaiable -GET
    public <T> T findAll_JSON(Class<T> responseType) throws UniformInterfaceException;
    // To update Resource - PUT
    public void edit_JSON(Object requestEntity) throws UniformInterfaceException;
    //To create Resource - POST
    public void create_JSON(Object requestEntity) throws UniformInterfaceException;
    //Tpo get a Unique Resource - Get
     public <T> T find_JSON(Class<T> responseType, String id) throws UniformInterfaceException;
    
}
