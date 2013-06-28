
package com.walmart.ecomm.service.entity.service;

import com.walmart.ecomm.service.entity.Store;
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

/**
 *
 * @author vrangan
 */
@Stateless
@Path("store")
public class StoreFacadeREST extends AbstractFacade<Store> {
    @PersistenceContext(unitName = "WALMART-PU")
    private EntityManager em;

    public StoreFacadeREST() {
        super(Store.class);
    }

    @POST
    @Override
    @Consumes("application/json")
    public void create(Store entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes("application/json")
    public void edit(Store entity) {
        super.edit(entity);
    }

  

    @GET
    @Path("{id}")
    @Produces( "application/json")
    public Store find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces( "application/json")
    public List<Store> findAll() {
        return super.findAll();
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
