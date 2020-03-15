package com.ejwa.orm.model.dao;

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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class CustomerDAOTest {

    private Long test_id_1, test_id_2, test_id_3;
    private String test_email_1 = "test_email_1@email.com", test_email_2 = "test_email_2@email.com", test_email_3 = "test_email_3@email.com";
    private String test_password_1 = "test_password_1", test_password_2 = "test_password_2", test_password_3 = "test_password_3";
    private String test_shippingAdress_1 = "test_shippingAdress_1", test_shippingAdress_2 = "test_shippingAdress_2", test_shippingAdress_3 = "test_shippingAdress_3";
    private String test_homeAdress_1 = "test_homeAdress_1", test_homeAdress_2 = "test_homeAdress_2", test_homeAdress_3 = "test_homeAdress_3";
    private String test_firstName_1 = "test_first_name_1", test_firstName_2 = "test_first_name_2", test_firstName_3 = "test_first_name_3";
    private String test_lastName_1 = "test_last_name_1", test_lastName_2 = "test_last_name_2", test_lastName_3 = "test_last_name_3";

    private Customer test_c1 = new Customer(test_email_1, test_password_1, test_shippingAdress_1, test_homeAdress_1, test_firstName_1, test_lastName_1);
    private Customer test_c2 = new Customer(test_email_2, test_password_2, test_shippingAdress_2, test_homeAdress_2, test_firstName_2, test_lastName_2);
    private Customer test_c3 = new Customer(test_email_3, test_password_3, test_shippingAdress_3, test_homeAdress_3, test_firstName_3, test_lastName_3);

    //private Customer RESTtest = new Customer("REST_test_email_@email.com", "REST_test_password", "REST_test_shippingAdress", "REST_test_homeAdress", "REST_test_firstName", "REST_test_lastName");
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(CustomerDAO.class, Category.class, ClothingItem.class, SizeQuantity.class, SizeQuantityId.class, Customer.class, CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private CustomerDAO customerDAO;

    @Before
    public void init() {
        test_id_1 = new Random().nextLong();
        test_id_2 = new Random().nextLong();
        test_id_2 = new Random().nextLong();

        test_c1.setCustomer_id(test_id_1);
        test_c2.setCustomer_id(test_id_2);
        test_c3.setCustomer_id(test_id_3);

        customerDAO.create(test_c1);
        customerDAO.create(test_c2);
        customerDAO.create(test_c3);
    }

    @After
    public void roll_back_init() {
        customerDAO.remove(customerDAO.find(test_c1.getCustomer_id()));
        customerDAO.remove(customerDAO.find(test_c2.getCustomer_id()));
        customerDAO.remove(customerDAO.find(test_c3.getCustomer_id()));
    }

    /*@Test
    public void Z_just_for_REST_test() {
        customerDAO.create(RESTtest);
    }*/
    @Test
    public void checkThatis_registered_CustomerCorrectly() {
        boolean toValidate1 = customerDAO.is_registered_Customer(test_email_2, test_password_2);
        System.out.println(toValidate1);
        Assert.assertTrue(toValidate1);
        boolean toValidate2 = customerDAO.is_registered_Customer("55555555555555", "666666666666666");
        System.out.println(toValidate2);
        Assert.assertFalse(toValidate2);
    }

    @Test
    public void checkThatRegister_customer_signup_email_passwordMatchesCorrectly() {
        boolean toValidate = customerDAO.register_customer_signup("new_test_email@email.com", "new_test_password");
        Assert.assertTrue(toValidate);
        if (toValidate) {
            customerDAO.remove_Customer("new_test_email@email.com", "new_test_password");
        }
    }

    @Test
    public void checkThatAuthenticateCustomerMatchesCorrectly() {
        Customer c = customerDAO.authenticateCustomer(test_email_2, test_password_2);
        Assert.assertEquals(c, test_c2);
    }

    @Test
    public void checkThatFindCustomerMatchingIDMatchesCorrectly() {
        Customer c = customerDAO.findCustomerMatchingID(test_id_1);
        Assert.assertEquals(c, test_c1);
    }

    @Test
    public void checkThatFindCustomerMatchingFirstNameMatchesCorrectly() {
        List<Customer> c_list = customerDAO.findCustomerOrdersMatchingFirstName(test_firstName_2);
        List<Customer> test_c_list = new ArrayList<Customer>() {
            {
                add(test_c2);
            }
        };
        Assert.assertEquals(c_list, test_c_list);
    }

    @Test
    public void checkThatFindCustomerMatchingLastNameMatchesCorrectly() {
        List<Customer> c_list = customerDAO.findCustomerOrdersMatchingLastName(test_lastName_3);
        List<Customer> test_c_list = new ArrayList<Customer>() {
            {
                add(test_c3);
            }
        };
        Assert.assertEquals(c_list, test_c_list);
    }

    @Test
    public void checkThatFindCustomerMatchingHomeAdressMatchesCorrectly() {
        List<Customer> c_list = customerDAO.findCustomerOrdersMatchingHomeAdress(test_homeAdress_2);
        List<Customer> test_c_list = new ArrayList<Customer>() {
            {
                add(test_c2);
            }
        };
        Assert.assertEquals(c_list, test_c_list);
    }

    @Test
    public void checkThatFindCustomerMatchingFShippingAdressMatchesCorrectly() {
        List<Customer> c_list = customerDAO.findCustomerOrdersMatchingShippingAdress(test_shippingAdress_3);
        List<Customer> test_c_list = new ArrayList<Customer>() {
            {
                add(test_c3);
            }
        };
        Assert.assertEquals(c_list, test_c_list);
    }

}
