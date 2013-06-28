package com.walmart.ecomm.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.walmart.ecomm.dto.Item;

@Path("/Items")
public class ItemService {

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getItemDetails(@PathParam("id") long id) {
		Item item=new Item();
		item.setItem_id(id);
		return item.toString();
	}
}
