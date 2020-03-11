package service;

import com.ejwa.orm.model.dao.ProductDAO;
import com.ejwa.orm.model.dao.ProductInitBean;
import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.Max;
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

@Path("product")
public class ProductServiceREST {

    @Inject
    ProductInitBean pib;
     
    @EJB
    private ProductDAO productDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Product entity) {
        productDAO.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Long id, Product entity) {
        productDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") @NotNull Long id) {
        productDAO.remove(productDAO.findProductMatchingID(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product find(@PathParam("id") Long id) {
        return productDAO.findProductMatchingID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findAll() {
        //productDAO.create(new Product(new Faker().commerce().productName().toString(), Double.valueOf(new Faker().commerce().price(0, 100))));
        return productDAO.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(productDAO.count());
    }

    @GET
    @Path("fina/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findProductsMatchingName(@PathParam("name") String name) {
        return productDAO.findProductsMatchingName(name);
    }

    @GET
    @Path("fipr/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findProductsMatchingPrice(@PathParam("price") Double price) {
        return productDAO.findProductsMatchingPrice(price);
    }

    @GET
    @Path("fiprhieq/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findProductsHigherPriceOrEqual(@PathParam("price") Double price) {
        return productDAO.findProductsHigherPriceOrEqual(price);
    }

    @GET
    @Path("fiprhi/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findProductsHigherPrice(@PathParam("price") Double price) {
        return productDAO.findProductsHigherPrice(price);
    }

    @GET
    @Path("fiprloeq/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findProductsLowerPriceOrEqual(@PathParam("price") Double price) {
        return productDAO.findProductsLowerPriceOrEqual(price);
    }

    @GET
    @Path("fiprlo/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> findProductsLowerPrice(@PathParam("price") Double price) {
        return productDAO.findProductsLowerPrice(price);
    }
}
