package service;


import com.ejwa.orm.model.bean.CartBean;
import com.ejwa.orm.model.entity.ClothingItem;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cart")
public class CartServiceREST {

    @Inject
    private CartBean cartBean;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClothingItem> getCart() {
        return cartBean.getItems();
    }
    
    @POST
    @Path("{id}")
    public void addProductToCart(Long id) {
        cartBean.addItem(id);
    }

    @DELETE
    @Path("{id}")
    public void removeProductFromCart(Long id) {
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
