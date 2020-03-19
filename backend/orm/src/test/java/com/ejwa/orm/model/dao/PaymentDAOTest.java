package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.Customer;
import com.ejwa.orm.model.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class PaymentDAOTest {

    private Long test_id_1;
    private Long test_id_2;
    private Long test_id_3;

    private Payment test_p1 = new Payment("Visa");
    private Payment test_p2 = new Payment("MasterCard");
    private Payment test_p3 = new Payment("Swish");

    //private Payment RESTtest = new Payment("REST_test_Swish");
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(PaymentDAO.class, ClothingItem.class, CustomerOrderClothingItemId.class, CustomerOrderClothingItem.class, SizeQuantity.class, SizeQuantityId.class ,Category.class, Customer.class, CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private PaymentDAO paymentDAO;

    @Inject
    private UserTransaction utx;
    
    @Before
    public void init() throws Exception {
        utx.begin();
        paymentDAO.create(test_p1);
        paymentDAO.create(test_p2);
        paymentDAO.create(test_p3);
        utx.commit();

    }

    @After
    public void roll_back_init() throws Exception {
        utx.begin();
        paymentDAO.remove(paymentDAO.merge(test_p1));
        paymentDAO.remove(paymentDAO.merge(test_p2));
        paymentDAO.remove(paymentDAO.merge(test_p3));
        utx.commit();
    }

    /*@Test
    public void Z_just_for_REST_test() {
        paymentDAO.create(RESTtest);
    }*/
    @Test
    public void checkThatFindPaymentsMatchingIDMatchesCorrectly() {
        Payment p = paymentDAO.findPaymentMatchingID(test_p1.getPayment_id());
        Assert.assertEquals(p, test_p1);
    }

    @Test
    public void checkThatFindPaymentsMatchingPaymentTypeMatchesCorrectly() {
        List<Payment> p_list = paymentDAO.findPaymentsMatchingPaymentType("Swish");
        List<Payment> test_p_list = new ArrayList<Payment>() {
            {
                add(test_p3);
            }
        };
        Assert.assertEquals(p_list.size(), test_p_list.size());
    }
}
