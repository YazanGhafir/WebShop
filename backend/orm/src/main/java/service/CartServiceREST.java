package service;


import com.ejwa.orm.model.bean.CartBean;
import com.ejwa.orm.model.dao.ClothingItemDAO;
import com.ejwa.orm.model.dao.ProductDAO;
import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cart")
public class CartServiceREST {

    @EJB
    private ClothingItemDAO clothingItemDAO;

    @Inject
    private CartBean cartBean;

    @GET
    @Path("message")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return cartBean.getMessage();
    }
    
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClothingItem> getCart() {
        return cartBean.getProducts();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProductToCart(ClothingItem product) {
        cartBean.addProduct(product);
    }

    @DELETE
    //@Consumes(MediaType.APPLICATION_JSON)
    public void removeProductFromCart(ClothingItem product) {
        cartBean.removeProduct(product);
    }

}
