package service;

import com.bean.CartBean;
import com.ejwa.orm.model.dao.CustomerDAO;
import com.ejwa.orm.model.dao.ProductDAO;
import com.ejwa.orm.model.entity.Customer;
import com.ejwa.orm.model.entity.Product;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakerIDN;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cart")
public class CartServiceREST {

    @EJB
    private ProductDAO productDAO;

    @Inject
    private CartBean cartBean;

    @GET
    @Path("message")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return cartBean.getMessage();
    }

    @GET
    @Path("cart")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getCart() {
        return cartBean.getProducts();
    }
    
    @POST
    @Path("cart/{product}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProductToCart(@PathParam("product") Product product) {
        cartBean.addProduct(product);
    }

    @DELETE
    @Path("cart/{product}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeProductFromCart(@PathParam("product") Product product) {
        cartBean.removeProduct(product);
    }

}
