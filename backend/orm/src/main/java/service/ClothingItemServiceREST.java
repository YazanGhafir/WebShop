/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.ejwa.orm.model.dao.ClothingItemDAO;
import com.ejwa.orm.model.entity.ClothingItem;
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
    public void edit(@PathParam("id") Long id, ClothingItem entity) {
        clothingItemDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        clothingItemDAO.remove(clothingItemDAO.findClothingItemMatchingID(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ClothingItem find(@PathParam("id") Long id) {
        return clothingItemDAO.findClothingItemMatchingID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClothingItem> findAll() {
         return clothingItemDAO.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(clothingItemDAO.count());
    }
    
    
    @GET
    @Path("label/{label}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClothingItem> findByLabel(@PathParam("label") String label){
        return clothingItemDAO.findClothingItemsMatchingLabel(label);
    }
    
    
    @GET
    @Path("search/{searchTerm}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClothingItem> search(@PathParam("searchTerm") String searchTerm){
        return clothingItemDAO.findClothingItemsBySearchLabel(searchTerm);
    }
    
    
    @GET
    @Path("max")
    @Produces(MediaType.TEXT_PLAIN)
    public String findMaxPrice(){
        return String.valueOf(clothingItemDAO.findMaxClothingItemPrice());
    }
    
    @GET
    @Path("min")
    @Produces(MediaType.TEXT_PLAIN)
    public String findMinPrice(){
        return String.valueOf(clothingItemDAO.findMinClothingItemPrice());
    }

    @GET
    @Path("{sizes}/{colours}/{minPrice}/{maxPrice}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClothingItem> findWithFilters(@PathParam("sizes") List<String> sizes,
            @PathParam("colours") List<String> colours, @PathParam("minPrice") double minPrice,
            @PathParam("maxPrice") double maxPrice){
        return clothingItemDAO.findClothingItemsWithFilters(sizes, colours, minPrice, maxPrice);
    }
    
}
