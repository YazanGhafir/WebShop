package service;

import com.ejwa.orm.model.dao.CustomerDAO;
import com.ejwa.orm.model.entity.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("customer")
public class CustomerServiceREST {

    @EJB
    private CustomerDAO customerDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Customer entity) {
        customerDAO.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Long id, Customer entity) {
        customerDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        customerDAO.remove(customerDAO.findCustomerMatchingID(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer find(@PathParam("id") Long id) {
        return customerDAO.findCustomerMatchingID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(customerDAO.count());
    }

    /*
    register_customer_signup
    register_customer_signup
    is_registered_Customer
    authenticateCustomer        
    remove_Customer        
     */
    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findByEmail(@PathParam("email") String email) {
        return customerDAO.findCustomerMatchingEmail(email);
    }

    @GET
    @Path("{shippingadress}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findByShippingAdress(@PathParam("shippingadress") String shippingadress) {
        return customerDAO.findCustomerOrdersMatchingShippingAdress(shippingadress);
    }

    @GET
    @Path("{homeadress}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findByHomeAdress(@PathParam("homeadress") String homeadress) {
        return customerDAO.findCustomerOrdersMatchingHomeAdress(homeadress);
    }

    @GET
    @Path("{lastname}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findByLastName(@PathParam("lastname") String lastname) {
        return customerDAO.findCustomerOrdersMatchingLastName(lastname);
    }

    @GET
    @Path("{firstname}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findByFirstName(@PathParam("firstname") String firstname) {
        return customerDAO.findCustomerOrdersMatchingFirstName(firstname);
    }

}
