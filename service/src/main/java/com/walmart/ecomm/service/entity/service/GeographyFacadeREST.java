
package com.walmart.ecomm.service.entity.service;

import com.walmart.ecomm.service.entity.Geography;
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
@Path("geography")
public class GeographyFacadeREST extends AbstractFacade<Geography> {
    @PersistenceContext(unitName = "WALMART-PU")
    private EntityManager em;

    public GeographyFacadeREST() {
        super(Geography.class);
    }

    @POST
    @Override
  @Consumes("application/json")
    public void create(Geography entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes("application/json")
    public void edit(Geography entity) {
        super.edit(entity);
    }


    @GET
    @Path("{id}")
    @Produces("application/json")
    public Geography find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Geography> findAll() {
        return super.findAll();
    }

  

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
