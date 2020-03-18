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
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SizeQuantityDAOTest {

    private ClothingItem  ci1 = new ClothingItem("Adidas T-Shirt", 490.90, "This is a tshirt", "img", "Black");
    private ClothingItem  ci2 = new ClothingItem("Adidas T-Shirt", 480.90, "This is a tshirt", "img", "White");
    
    private Long test_id_1;
    private Long test_id_2;
    
    private SizeQuantity sq1;
    private SizeQuantity sq2;

    @Inject
    private UserTransaction utx;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(ClothingItemDAO.class, CategoryDAO.class, Product.class,
                            SizeQuantity.class, SizeQuantityId.class, SizeQuantityDAO.class,
                            Category.class, Customer.class, ClothingItem.class,
                            CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private ClothingItemDAO clothingItemDAO;

    @EJB
    private SizeQuantityDAO sizeQuantityDAO;

    @Before
    public void init() {
        sq1 = new SizeQuantity("S", 5, ci1);
        sq2 = new SizeQuantity("M", 6, ci2);
       
        clothingItemDAO.create(ci1);
        clothingItemDAO.create(ci2);

        sq1.setClothingItem(ci1);
        sq1.setClothingItem(ci2);

        sizeQuantityDAO.create(sq1);
        sizeQuantityDAO.create(sq2);
    }

    @After
    public void roll_back_init() throws Exception {
        
        utx.begin();
        sizeQuantityDAO.remove(sizeQuantityDAO.merge(sq1));
        sizeQuantityDAO.remove(sizeQuantityDAO.merge(sq2));
        clothingItemDAO.remove(clothingItemDAO.find(ci1.getId()));
        clothingItemDAO.remove(clothingItemDAO.find(ci2.getId()));
        utx.commit();
    }

    @Test
    public void mustHaveATestToCompile(){
        Assert.assertTrue(true);
    }
}
