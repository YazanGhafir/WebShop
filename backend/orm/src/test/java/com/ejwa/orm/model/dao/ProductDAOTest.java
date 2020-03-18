package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
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

@RunWith(Arquillian.class)
public class ProductDAOTest {

    private Long test_id_1;
    private Long test_id_2;

    private Product test_p1 = new Product("Adidas T-Shirt00", 5.0, "img");
    private Product test_p2 = new Product("Adidas T-Shirt11", 20.0, "img");
    private Product test_p3 = new Product("Tommy Hilfiger Jacket", 20.0, "img");
    private Product test_p4 = new Product("Adidas T-Shirt111", 10.0, "img");
    private Product test_p5 = new Product("Adidas T-Shirt222", 40.0, "img");
    private Product test_p6 = new Product("Tommy Hilfiger Jacket333", 50.0, "img");

    //private Product RESTtest = new Product("REST_test_Tommy Hilfiger Jacket333", 50.0);
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(ProductDAO.class, Product.class, ClothingItem.class, SizeQuantity.class, SizeQuantityId.class ,Category.class, Customer.class, CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private ProductDAO productDAO;
    
    @Inject
    private UserTransaction utx;

    @Before
    public void init()throws Exception {
        test_id_1 = new Random().nextLong();
        test_id_2 = new Random().nextLong();

        utx.begin();
        test_p1.setProduct_id(test_id_1);
        test_p2.setProduct_id(test_id_2);

        productDAO.create(test_p1);
        productDAO.create(test_p2);
        productDAO.create(test_p3);
        productDAO.create(test_p4);
        productDAO.create(test_p5);
        productDAO.create(test_p6);
        utx.commit();
    }

    @After
    public void roll_back_init()throws Exception {
        utx.begin();
        productDAO.remove(productDAO.merge(test_p1));
        productDAO.remove(productDAO.merge(test_p2));
        productDAO.remove(productDAO.merge(test_p3));
        productDAO.remove(productDAO.merge(test_p4));
        productDAO.remove(productDAO.merge(test_p5));
        productDAO.remove(productDAO.merge(test_p6));
        utx.commit();
        /*
        productDAO.remove(productDAO.find(test_p2.getProduct_id()));
        productDAO.remove(productDAO.find(test_p3.getProduct_id()));
        productDAO.remove(productDAO.find(test_p4.getProduct_id()));
        productDAO.remove(productDAO.find(test_p5.getProduct_id()));
        productDAO.remove(productDAO.find(test_p6.getProduct_id()));
        */
    }

    /*
    @Test @InSequence(7)
    public void Z_just_for_REST_test() {
        productDAO.create(RESTtest);
    }
     */
    @Test
    @InSequence(0)
    public void checkThatFindProductMatchingIDMatchesCorrectly() {
        Product p = productDAO.findProductMatchingID(test_id_1);
        Assert.assertEquals(p, test_p1);
    }

    // @Test @InSequence(1)
    public void checkThatFindProductsMatchingNameMatchesCorrectly() {
        List<Product> p_list = productDAO.findProductsMatchingName("Adidas T-Shirt");
        List<Product> test_p_list = new ArrayList<Product>() {
            {
                add(test_p1);
                add(test_p2);
            }
        };
        Assert.assertEquals(p_list, test_p_list);
    }

    //@Test @InSequence(2)
    public void checkThatFindProductsMatchingPriceMatchesCorrectly() {
        List<Product> p_list = productDAO.findProductsMatchingPrice(20.0);
        List<Product> test_p_list = new ArrayList<Product>() {
            {
                add(test_p2);
                add(test_p3);
            }
        };
        Assert.assertEquals(p_list, test_p_list);
    }

    // @Test @InSequence(3)
    public void checkThatFindProductsMatchingHigherPriceOrEqualMatchesCorrectly() {
        List<Product> p_list = productDAO.findProductsHigherPriceOrEqual(20.0);
        List<Product> test_p_list = new ArrayList<Product>() {
            {
                add(test_p2);
                add(test_p3);
                add(test_p5);
                add(test_p6);
            }
        };
        Assert.assertEquals(p_list, test_p_list);
    }

    // @Test @InSequence(4)
    public void checkThatFindProductsMatchingHigherPriceMatchesCorrectly() {
        List<Product> p_list = productDAO.findProductsHigherPrice(20.0);
        List<Product> test_p_list = new ArrayList<Product>() {
            {
                add(test_p5);
                add(test_p6);
            }
        };
        Assert.assertEquals(p_list, test_p_list);
    }

    // @Test @InSequence(5)
    public void checkThatFindProductsMatchingLowerPriceOrEqualMatchesCorrectly() {
        List<Product> p_list = productDAO.findProductsLowerPriceOrEqual(20.0);
        List<Product> test_p_list = new ArrayList<Product>() {
            {
                add(test_p1);
                add(test_p2);
                add(test_p3);
                add(test_p4);
            }
        };
        Assert.assertEquals(p_list, test_p_list);
    }

    // @Test @InSequence(6)
    public void checkThatFindProductsMatchingLowerPriceMatchesCorrectly() {
        List<Product> p_list = productDAO.findProductsLowerPrice(20.0);
        List<Product> test_p_list = new ArrayList<Product>() {
            {
                add(test_p1);
                add(test_p4);
            }
        };
        Assert.assertEquals(p_list, test_p_list);
    }

}
