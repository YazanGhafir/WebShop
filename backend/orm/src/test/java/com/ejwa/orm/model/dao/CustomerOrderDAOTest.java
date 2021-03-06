package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.Customer;
import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.*;
import java.time.LocalDateTime;
import java.time.Month;
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
public class CustomerOrderDAOTest {

    private Long test_id_1;
    private Long test_id_2;

    private LocalDateTime test_date1;
    private LocalDateTime test_date2;
    private LocalDateTime test_date3;
    

    private CustomerOrder test_customerOrder1 = new CustomerOrder();
    private CustomerOrder test_customerOrder2 = new CustomerOrder();
    private CustomerOrder test_customerOrder3 = new CustomerOrder();

    private CustomerOrder RESTtest = new CustomerOrder();

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(CustomerOrderDAO.class, ClothingItem.class, CustomerOrderClothingItemId.class, CustomerOrderClothingItem.class, SizeQuantity.class, SizeQuantityId.class, Category.class, Customer.class, CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private CustomerOrderDAO customerOrderDAO;

    @Inject
    private UserTransaction utx;
    
    @Before
    public void init() throws Exception {
        test_id_1 = new Random().nextLong();
        test_id_2 = new Random().nextLong();
        
        
        
        test_date1 = LocalDateTime.of(2014, Month.SEPTEMBER, 11, 16, 15, 15);
        test_date2 = LocalDateTime.of(2014, Month.OCTOBER, 11, 16, 15, 15);
        test_date3 = LocalDateTime.of(2014, Month.AUGUST, 11, 16, 15, 15);
    

        test_customerOrder1.setCustomerorder_id(test_id_1);
        test_customerOrder2.setCustomerorder_id(test_id_2);

        test_customerOrder1.setDate(test_date1);
        test_customerOrder2.setDate(test_date2);
        test_customerOrder3.setDate(test_date3);

        utx.begin();
        customerOrderDAO.create(test_customerOrder1);
        customerOrderDAO.create(test_customerOrder2);
        customerOrderDAO.create(test_customerOrder3);
        utx.commit();

    }

    @After
    public void roll_back_init() throws Exception {
        utx.begin();
        customerOrderDAO.remove(customerOrderDAO.find(test_customerOrder1.getCustomerorder_id()));
        customerOrderDAO.remove(customerOrderDAO.find(test_customerOrder2.getCustomerorder_id()));
        customerOrderDAO.remove(customerOrderDAO.find(test_customerOrder3.getCustomerorder_id()));
        utx.commit();
    }

    
    @Test
    public void checkThatFindOrdersMatchingIDMatchesCorrectly() {
        CustomerOrder co = customerOrderDAO.findCustomerOrderMatchingID(test_id_1);
        Assert.assertEquals(co, test_customerOrder1);
    }

    @Test
    public void checkThatFindOrdersMatchingDateMatchesCorrectly() {
        List<CustomerOrder> co_list = customerOrderDAO.findCustomerOrdersMatchingDate(test_date1);
        List<CustomerOrder> test_p_list = new ArrayList<CustomerOrder>() {
            {
                add(test_customerOrder1);
            }
        };
        Assert.assertEquals(co_list, test_p_list);
    }

    @Test
    public void checkThatFindOrdersHappenedBeforeOrEqualDateMatchesCorrectly() {
        List<CustomerOrder> co_list = customerOrderDAO.findCustomerOrdersBeforeOrEqualDate(test_date1);
        List<CustomerOrder> test_co_list = new ArrayList<CustomerOrder>() {
            {
                add(test_customerOrder1);
                add(test_customerOrder3);
            }
        };
        Assert.assertEquals(co_list.size(), test_co_list.size());
    }

    @Test
    public void checkThatFindOrdersHappenedAfterOrEqualDateMatchesCorrectly() {
        List<CustomerOrder> co_list = customerOrderDAO.findCustomerOrdersAfterOrEqualDate(test_date1);
        List<CustomerOrder> test_co_list = new ArrayList<CustomerOrder>() {
            {
                add(test_customerOrder1);
                add(test_customerOrder2);
            }
        };
        Assert.assertEquals(co_list.size(), test_co_list.size());
    }

}
