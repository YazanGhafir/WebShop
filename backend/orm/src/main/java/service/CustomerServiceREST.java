package service;

import com.ejwa.orm.model.dao.CustomerDAO;
import com.ejwa.orm.model.entity.Customer;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakerIDN;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("customer")
public class CustomerServiceREST {

    @EJB
    private CustomerDAO customerDAO;

    @Inject
    private SecurityContext securityContext;
  

    @Context
    private HttpServletRequest httpServletRequest;

    @Context
    private HttpServletResponse httpServletResponse;

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
        Faker faker = new Faker();
        customerDAO.create(new Customer(faker.internet().emailAddress(),
                faker.internet().password(),
                faker.address().streetAddress(),
                faker.address().streetAddress(),
                faker.name().firstName(),
                faker.name().lastName()));
        return customerDAO.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(customerDAO.count());
    }

    @POST
    @Path("rc/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean register_customer_signup(@PathParam("email") String email, @PathParam("password") String password) {
        return customerDAO.register_customer_signup(email, password);
    }

    // @RolesAllowed("hhh")
    @GET
    @Path("auth/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public AuthenticationStatus authenticateCustomer(@PathParam("email") String email, @PathParam("password") String password) {
        UsernamePasswordCredential credential = new UsernamePasswordCredential(email, new Password(password));
        AuthenticationStatus as = securityContext.authenticate(httpServletRequest, httpServletResponse,AuthenticationParameters.withParams().credential(credential));
        return as;
        //return customerDAO.authenticateCustomer(email, password);
    }

    @GET
    @Path("isReg/{email}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean is_registered_Customer(@PathParam("email") String email, @PathParam("password") String password) {
        return customerDAO.is_registered_Customer(email, password);
    }

    @DELETE
    @Path("rem/{email}/{password}")
    public void remove_Customer(@PathParam("email") String email, @PathParam("password") String password) {
        customerDAO.remove_Customer(email, password);
    }

    @GET
    @Path("fiem/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer findByEmail(@PathParam("email") String email) {
        return customerDAO.findCustomerMatchingEmail(email);
    }

    @GET
    @Path("fiad/{shippingadress}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findByShippingAdress(@PathParam("shippingadress") String shippingadress) {
        return customerDAO.findCustomerOrdersMatchingShippingAdress(shippingadress);
    }

    @GET
    @Path("fiho/{homeadress}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findByHomeAdress(@PathParam("homeadress") String homeadress) {
        return customerDAO.findCustomerOrdersMatchingHomeAdress(homeadress);
    }

    @GET
    @Path("fila/{lastname}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findByLastName(@PathParam("lastname") String lastname) {
        return customerDAO.findCustomerOrdersMatchingLastName(lastname);
    }

    @GET
    @Path("fifi/{firstname}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> findByFirstName(@PathParam("firstname") String firstname) {
        return customerDAO.findCustomerOrdersMatchingFirstName(firstname);
    }


}
