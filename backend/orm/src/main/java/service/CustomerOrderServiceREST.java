package service;

import com.ejwa.orm.model.dao.CustomerOrderDAO;
import com.ejwa.orm.model.entity.CustomerOrder;
import java.time.LocalDateTime;
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

@Path("customerorder")
public class CustomerOrderServiceREST {

    @EJB
    private CustomerOrderDAO customerOrderDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CustomerOrder entity) {
        customerOrderDAO.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Long id, CustomerOrder entity) {
        customerOrderDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        customerOrderDAO.remove(customerOrderDAO.findCustomerOrderMatchingID(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerOrder find(@PathParam("id") Long id) {
        return customerOrderDAO.findCustomerOrderMatchingID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerOrder> findAll() {
        customerOrderDAO.create(new CustomerOrder(LocalDateTime.MAX));
        return customerOrderDAO.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(customerOrderDAO.count());
    }

    @GET
    @Path("fidate/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerOrder> findByDate(@PathParam("date") String date) {
        LocalDateTime t = LocalDateTime.parse(date.subSequence(0, date.length()));
        return customerOrderDAO.findCustomerOrdersMatchingDate(t);
    }

    @GET
    @Path("after/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerOrder> findAfterDate(@PathParam("date") String date) {
        LocalDateTime t = LocalDateTime.parse(date.subSequence(0, date.length()));
        return customerOrderDAO.findCustomerOrdersAfterOrEqualDate(t);
    }

    @GET
    @Path("before/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerOrder> findBeforeDate(@PathParam("date") String date) {
         LocalDateTime t = LocalDateTime.parse(date.subSequence(0, date.length()));
        return customerOrderDAO.findCustomerOrdersBeforeOrEqualDate(t);
    }

}
