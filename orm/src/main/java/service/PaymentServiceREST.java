package service;

import com.ejwa.orm.model.dao.PaymentDAO;
import com.ejwa.orm.model.entity.Payment;
import com.github.javafaker.Faker;
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

@Path("payment")
public class PaymentServiceREST {

    @EJB
    private PaymentDAO paymentDAO;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Payment entity) {
        paymentDAO.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(@PathParam("id") Long id, Payment entity) {
        paymentDAO.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        paymentDAO.remove(paymentDAO.findPaymentMatchingID(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payment find(@PathParam("id") Long id) {
        return paymentDAO.findPaymentMatchingID(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> findAll() {
        paymentDAO.create(new Payment("Paybal"));
        return paymentDAO.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(paymentDAO.count());
    }

    @GET
    @Path("fipa/{paymentType}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> find(@PathParam("paymentType") String paymentType) {
        return paymentDAO.findPaymentsMatchingPaymentType(paymentType);
    }
}
