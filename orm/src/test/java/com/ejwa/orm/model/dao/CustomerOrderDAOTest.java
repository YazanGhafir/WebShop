package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.Customer;
import com.ejwa.orm.model.entity.*;
import java.util.ArrayList;
import java.util.Date;
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

@RunWith(Arquillian.class)
public class CustomerOrderDAOTest {

    private Long test_id_1;
    private Long test_id_2;
    
    private Date test_date1 = new Date(System.currentTimeMillis());
    private Date test_date2 = new Date(System.currentTimeMillis());
    private Date test_date3 = new Date(System.currentTimeMillis());

    private CustomerOrder test_customerOrder1 = new CustomerOrder(test_date1);
    private CustomerOrder test_customerOrder2 = new CustomerOrder(test_date2);
    private CustomerOrder test_customerOrder3 = new CustomerOrder(test_date3);

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(CustomerOrderDAO.class, Product.class, Category.class, Customer.class, CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private CustomerOrderDAO customerOrderDAO;

    @Before
    public void init() {
        test_id_1 = new Random().nextLong();
        test_id_2 = new Random().nextLong();

        test_customerOrder1.setCustomerorder_id(test_id_1);
        test_customerOrder2.setCustomerorder_id(test_id_2);
        
        test_customerOrder2.getDate().setTime((test_customerOrder1.getDate().getTime()+1000));
        test_customerOrder3.getDate().setTime((test_customerOrder1.getDate().getTime()-1000));

        customerOrderDAO.create(test_customerOrder1);
        customerOrderDAO.create(test_customerOrder2);
        customerOrderDAO.create(test_customerOrder3);

    }
    
    @After
    public void roll_back_init(){
        customerOrderDAO.remove(test_customerOrder1);
        customerOrderDAO.remove(test_customerOrder2);
        customerOrderDAO.remove(test_customerOrder3);
    }

    @Test
    public void checkThatFindOrdersMatchingIDMatchesCorrectly() {
        CustomerOrder co = customerOrderDAO.findCustomerOrderMatchingID(test_id_1);
        Assert.assertEquals(co, test_customerOrder1);
    }
    
    @Test
    public void checkThatFindOrdersMatchingDateMatchesCorrectly() {
        List<CustomerOrder> co_list = customerOrderDAO.findCustomerOrdersMatchingDate(test_date1);
        List<CustomerOrder> test_p_list = new ArrayList<CustomerOrder>(){{add(test_customerOrder1);}};
        Assert.assertEquals(co_list, test_p_list);
    }
    
    /*
    @Test
    public void checkThatFindOrdersHappenedBeforeOrEqualDateMatchesCorrectly() {
        List<CustomerOrder> co_list = customerOrderDAO.findCustomerOrdersBeforeOrEqualDate(test_date1);
        List<CustomerOrder> test_co_list = new ArrayList<CustomerOrder>(){{add(test_customerOrder1); add(test_customerOrder3);}};
        Assert.assertEquals(co_list, test_co_list);
    }
    
    @Test
    public void checkThatFindOrdersHappenedAfterOrEqualDateMatchesCorrectly() {
       List<CustomerOrder> co_list = customerOrderDAO.findCustomerOrdersAfterOrEqualDate(test_date1);
       List<CustomerOrder> test_co_list = new ArrayList<CustomerOrder>(){{add(test_customerOrder1); add(test_customerOrder2);}};
       Assert.assertEquals(co_list, test_co_list);
    }
*/
    
    
}
