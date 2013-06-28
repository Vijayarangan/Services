
package com.walmart.ecomm.service.entity.service;

import com.walmart.ecomm.service.entity.Region;
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
@Path("region")
public class RegionFacadeREST extends AbstractFacade<Region> {
    @PersistenceContext(unitName = "WALMART-PU")
    private EntityManager em;

    public RegionFacadeREST() {
        super(Region.class);
    }

    @POST
    @Override
    @Consumes("application/json")
    public void create(Region entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes( "application/json")
    public void edit(Region entity) {
        super.edit(entity);
    }



    @GET
    @Path("{id}")
    @Produces( "application/json")
    public Region find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Region> findAll() {
        return super.findAll();
    }

   

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
