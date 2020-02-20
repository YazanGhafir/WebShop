package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.Customer;
import com.ejwa.orm.model.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class PaymentDAOTest {

    private Long test_id_1;
    private Long test_id_2;
    private Long test_id_3;

    private Payment test_p1 = new Payment("Visa");
    private Payment test_p2 = new Payment("MasterCard");
    private Payment test_p3 = new Payment("Swish");

    private Payment RESTtest = new Payment("REST_test_Swish");
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(PaymentDAO.class, Product.class, Category.class, Customer.class, CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private PaymentDAO paymentDAO;

    @Before
    public void init() {
        test_id_1 = new Random().nextLong();
        test_id_2 = new Random().nextLong();

        test_p1.setPayment_id(test_id_1);
        test_p2.setPayment_id(test_id_2);
        
        paymentDAO.create(test_p1);
        paymentDAO.create(test_p2);
        paymentDAO.create(test_p3);
        
        
    }
    
    @After
    public void roll_back_init(){
        paymentDAO.remove(test_p1);
        paymentDAO.remove(test_p2);
        paymentDAO.remove(test_p3);
    }
    
    @Test
    public void Z_just_for_REST_test() {
        paymentDAO.create(RESTtest);
    }
    
    @Test
    public void checkThatFindPaymentsMatchingIDMatchesCorrectly() {
        Payment p = paymentDAO.findPaymentMatchingID(test_id_1);
        Assert.assertEquals(p, test_p1);
    }
    
    @Test
    public void checkThatFindPaymentsMatchingPaymentTypeMatchesCorrectly() {
        List<Payment> p_list = paymentDAO.findPaymentsMatchingPaymentType("Swish");
        List<Payment> test_p_list = new ArrayList<Payment>(){{add(test_p3);}};
        Assert.assertEquals(p_list, test_p_list);
    }
}
