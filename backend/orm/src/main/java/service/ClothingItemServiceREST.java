/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.ejwa.orm.model.dao.ClothingItemDAO;
import com.ejwa.orm.model.dao.ProductDAO;
import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author madel
 */

@Path("clothingItem")
public class ClothingItemServiceREST {
    /*
    @EJB
    private ClothingItemDAO clothingItemDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(ClothingItem entity) {
        clothingItemDAO.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Long id, Product entity) {
        clothingItemDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") @NotNull Long id) {
        clothingItemDAO.remove(productDAO.findProductMatchingID(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product find(@PathParam("id") Long id) {
        return clothingItemDAO.findProductMatchingID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAll() {
        //productDAO.create(new Product(new Faker().commerce().productName().toString(), Double.valueOf(new Faker().commerce().price(0, 100))));
        return clothingItemDAO.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(clothingItemDAO.count());
    }
    */
}
