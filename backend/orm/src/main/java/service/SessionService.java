package service;

import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("s")
public class SessionService {

    
    @Inject
    private SessionBeanTest sb;

    
    @POST
    @Path("v/{id}")
    public void determinViewedProduct(@PathParam("id") Long id) {
        sb.determinViewedProduct(id);
    }
    
    @POST
    @Path("ci/{customerInfo}")
    public void addCustomerInfoAfterLogin(@PathParam("customerInfo") String customerInfo) {
        sb.addCustomerInfoAfterLogin(customerInfo);
    }
    
    @POST
    @Path("sc/{id}")
    public void addToShoppingCart(@PathParam("id") Long id) {
        sb.addToShoppingCart(id);
    }
    
    
    @GET
    @Path("ci")
    public String getCustomerInfo() {
        return sb.getCustomerInfo();
    }
    
    
    @GET
    @Path("v")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getViewedProduct() {
        return sb.getViewedProduct();
    }
    
    @GET
    @Path("sc")
    public List<Product> getShoppingCart() {
        return sb.getShoppingCart();
    }
    
    @DELETE
    @Path("ci/r")
    public void removeCustomerInfo() {
        sb.removeCustomerInfoAfterLogout();
    }
    
    @DELETE
    @Path("sc/r/{id}")
    public void removeItemFromShoppingCart(@PathParam("id") Long id) {
        sb.deleteFromShoppingCart(id);
    }
    
}
