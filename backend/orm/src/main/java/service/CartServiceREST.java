package service;

import com.ejwa.orm.model.bean.CartBean;
import com.ejwa.orm.model.bean.CartItem;
import com.ejwa.orm.model.dao.CustomerDAO;
import com.ejwa.orm.model.entity.Customer;
import com.ejwa.orm.model.entity.CustomerOrder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.digest.DigestUtils;

@Path("cart")
public class CartServiceREST {

    @EJB
    private CartBean cartBean;

    @EJB
    private CustomerDAO customerDAO;

    @Inject
    private SecurityContext securityContext;

    @Context
    private HttpServletRequest httpServletRequest;

    @Context
    private HttpServletResponse httpServletResponse;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartItem> getCart() {
        return cartBean.getItems();
    }

    @POST
    @Path("{id}/{size}")
    public void addClothingItemToCart(@PathParam("id") Long id, @PathParam("size") String size) {
        cartBean.addItem(id, size);
    }

    @POST
    @Path("{id}/{quantity}/{size}")
    public void updateQuantityForItemInCart(@PathParam("id") Long id, @PathParam("quantity") int quantity, @PathParam("size") String size) {
        cartBean.updateQuantity(id, quantity, size);
    }

    @DELETE
    @Path("{id}/{size}")
    public void removeClothingItemFromCart(@PathParam("id") Long id, @PathParam("size") String size) {
        cartBean.removeItem(id, size);
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
    
    @GET
    @Path("history")
    public List<CustomerOrder> gethistory() {
        return cartBean.getHistory();
    }

    @GET
    @Path("rca/{email}/{password}/{shippingAdress}/{homeAdress}/{firstName}/{lastName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register_customer_signup(@PathParam("email") String email, @PathParam("password") String password,
            @PathParam("shippingAdress") String shippingAdress, @PathParam("homeAdress") String homeAdress,
            @PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {

        boolean res = customerDAO.register_customer_signup(email.toLowerCase(), DigestUtils.sha256Hex(password), shippingAdress, homeAdress, firstName, lastName);
        if (res) {
            UsernamePasswordCredential credential = new UsernamePasswordCredential(email.toLowerCase(), new Password(DigestUtils.sha256Hex(password)));
            AuthenticationStatus as = securityContext.authenticate(httpServletRequest, httpServletResponse, AuthenticationParameters.withParams().credential(credential));
            cartBean.setInloggningsstatus(true);
            cartBean.addCustomerInfoAfterLogin(firstName + "-" + lastName + "-" + email);
            return Response
                    .status(Response.Status.OK)
                    .build();
        }
        cartBean.setInloggningsstatus(false);
        cartBean.addCustomerInfoAfterLogin("NAN");
        return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .build();
    }

    // @RolesAllowed("hhh")
    @GET
    @Path("auth/{email}/{password}")
    public Response authenticateCustomer(@PathParam("email") String email, @PathParam("password") String password) {
        UsernamePasswordCredential credential = new UsernamePasswordCredential(email.toLowerCase(), new Password(DigestUtils.sha256Hex(password)));
        AuthenticationStatus as = securityContext.authenticate(httpServletRequest, httpServletResponse, AuthenticationParameters.withParams().credential(credential));
        if (as == AuthenticationStatus.SUCCESS) {
            Customer c = customerDAO.authenticateCustomer(email, password);
            cartBean.setInloggningsstatus(true);
            cartBean.addCustomerInfoAfterLogin(c.getFirstName() + "-" + c.getLastName() + "-" + c.getEmail());
            return Response
                    .status(Response.Status.OK)
                    .build();
        }
        cartBean.setInloggningsstatus(false);
        cartBean.addCustomerInfoAfterLogin("NAN");
        return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .build();
    }

    @GET
    @Path("logout")
    public Response logout() {
        try {
            httpServletRequest.logout();
            cartBean.setInloggningsstatus(false);
            cartBean.addCustomerInfoAfterLogin("NAN");
            return Response
                    .status(Response.Status.OK)
                    .build();
        } catch (ServletException ex) {
            Logger.getLogger(CustomerServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .build();
        }
    }

    @GET
    @Path("isReg/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean is_registered_Customer(@PathParam("email") String email) {
        return customerDAO.is_registered_email(email.toLowerCase());
    }
    
    @GET
    @Path("loginstatus")
    public Response loginstatus() {
        if (cartBean.isInloggningsstatus()) {
            return Response
                    .status(Response.Status.OK)
                    .build();
        } else {
            return Response
                .status(Response.Status.NOT_ACCEPTABLE)
                .build();
        }
    }
    
    

}
