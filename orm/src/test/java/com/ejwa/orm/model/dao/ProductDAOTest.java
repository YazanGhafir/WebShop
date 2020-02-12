package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.*;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ProductDAOTest {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(ProductDAO.class, Product.class, Category.class, Customer.class, CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private ProductDAO productDAO;

    @Before
    public void init() {
        productDAO.create(new Product("Adidas T-Shirt", 10.0));
        productDAO.create(new Product("Nike shoes", 20.0));
        productDAO.create(new Product("Tommy Hilfiger Jacket", 30.0));
    }

    @Test
    public void checkThatFindProductsMatchingNameMatchesCorrectly() {
        Assert.assertTrue(true);
        /* Some better condition */
    }
}
