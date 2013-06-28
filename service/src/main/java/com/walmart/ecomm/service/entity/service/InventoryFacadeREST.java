
package com.walmart.ecomm.service.entity.service;

import com.walmart.ecomm.service.entity.Inventory;
import com.walmart.ecomm.service.entity.InventoryPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author vrangan
 */
@Stateless
@Path("inventory")
public class InventoryFacadeREST extends AbstractFacade<Inventory> {
    @PersistenceContext(unitName = "WALMART-PU")
    private EntityManager em;

    private InventoryPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;storeId=storeIdValue;itemId=itemIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.walmart.ecomm.service.entity.InventoryPK key = new com.walmart.ecomm.service.entity.InventoryPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> storeId = map.get("storeId");
        if (storeId != null && !storeId.isEmpty()) {
            key.setStoreId(new java.lang.Integer(storeId.get(0)));
        }
        java.util.List<String> itemId = map.get("itemId");
        if (itemId != null && !itemId.isEmpty()) {
            key.setItemId(new java.lang.Integer(itemId.get(0)));
        }
        return key;
    }

    public InventoryFacadeREST() {
        super(Inventory.class);
    }

    @POST
    @Override
     @Consumes("application/json")
    public void create(Inventory entity) {
        super.create(entity);
    }

    @PUT
    @Override
     @Consumes("application/json")
    public void edit(Inventory entity) {
        super.edit(entity);
    }

  

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Inventory find(@PathParam("id") PathSegment id) {
        com.walmart.ecomm.service.entity.InventoryPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
     @Produces("application/json")
    public List<Inventory> findAll() {
        return super.findAll();
    }



    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
