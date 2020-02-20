package service;

import com.ejwa.orm.model.dao.CategoryDAO;
import com.ejwa.orm.model.entity.Category;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("category")
public class CategoryServiceREST {

    @EJB
    private CategoryDAO categoryDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Category entity) {
        categoryDAO.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Long id, Category entity) {
        categoryDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        categoryDAO.remove(categoryDAO.findCategoryMatchingID(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category find(@PathParam("id") Long id) {
        return categoryDAO.findCategoryMatchingID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(categoryDAO.count());
    }
    
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String testREST() {
        return String.valueOf(012345);
    }
    
 
    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> findByName(@PathParam("name") String name) {
        return categoryDAO.findCategoriesMatchingCategoryName(name);
    }
    
   
}
