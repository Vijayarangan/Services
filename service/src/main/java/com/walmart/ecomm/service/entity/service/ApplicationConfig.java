
package com.walmart.ecomm.service.entity.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author vrangan
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();       
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Load all the REST Services
     * @param resources 
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.walmart.ecomm.service.entity.service.GeographyFacadeREST.class);
        resources.add(com.walmart.ecomm.service.entity.service.InventoryFacadeREST.class);
        resources.add(com.walmart.ecomm.service.entity.service.ItemFacadeREST.class);
        resources.add(com.walmart.ecomm.service.entity.service.RegionFacadeREST.class);
        resources.add(com.walmart.ecomm.service.entity.service.StoreFacadeREST.class);
    }
    
}
