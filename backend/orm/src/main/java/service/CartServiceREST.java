package service;


import com.ejwa.orm.model.bean.CartBean;
import com.ejwa.orm.model.bean.CartItem;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cart")
public class CartServiceREST {

    @EJB
    private CartBean cartBean;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartItem> getCart() {
        return cartBean.getItems();
    }
    
    @POST
    @Path("{id}/{size}")
    public void addClothingItemToCart(@PathParam("id")Long id, @PathParam("size")String size) {
        cartBean.addItem(id, size);
    }

    @DELETE
    @Path("{id}")
    public void removeClothingItemFromCart(@PathParam("id")Long id) {
        cartBean.removeItem(id);
    }
    
    @GET
    @Path("order")
    public String createOrder() {
        return cartBean.createOrder();
    }
    
    @DELETE
    @Path("customer")
    public void removeCustomerInfo() {
        cartBean.removeCustomerInfoAfterLogout();
    }
    
    @GET
    @Path("customer")
    public String getCustomerInfo() {
        return cartBean.getCustomerInfo();
    }
    

}
