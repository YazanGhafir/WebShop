/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.transaction.TransactionManager;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author madel
 */
@Transactional
@RunWith(Arquillian.class)
public class ClothingItemDAOTest {

    private long test_id_1;
    private long test_id_2;
    private long test_id_3;

    private static ClothingItem item1;
    private static ClothingItem item2;
    private static ClothingItem item3;

    private static SizeQuantity sizeItem1;
    private static SizeQuantity sizeItem2;
    private static SizeQuantity sizeItem3;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(ClothingItemDAO.class, ClothingItem.class, SizeQuantity.class, SizeQuantityId.class, SizeQuantityDAO.class, Category.class, Customer.class, CustomerOrder.class, Payment.class, Product.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private ClothingItemDAO clothingItemDAO;

    @EJB
    private SizeQuantityDAO sizeQuantityDAO;

    @Inject
    private UserTransaction utx;


    @Before
    public void checkThatFindClothingItemMatchingIDMatchesCorrectly() throws Exception {
        item1 = new ClothingItem("Adidas T-Shirt", 490.90, "This is a tshirt", "img", "Black");
        item2 = new ClothingItem("Adidas T-Shirt", 480.90, "This is a tshirt", "img", "White");
        item3 = new ClothingItem("Adidas Pants", 390.90, "hejhopp", "img", "Red");

        sizeItem1 = new SizeQuantity("L", 5, item1);
        sizeItem2 = new SizeQuantity("S", 4, item2);
        sizeItem3 = new SizeQuantity("M", 6, item3);

        utx.begin();
        clothingItemDAO.create(item1);
        clothingItemDAO.create(item2);
        clothingItemDAO.create(item3);

        sizeItem1.setClothingItem(item1);
        sizeItem2.setClothingItem(item2);
        sizeItem3.setClothingItem(item3);

        sizeQuantityDAO.create(sizeItem1);
        sizeQuantityDAO.create(sizeItem2);
        sizeQuantityDAO.create(sizeItem3);
        utx.commit();
        //ClothingItem p = clothingItemDAO.findClothingItemMatchingID(test_id_1);

        //Assert.assertEquals(p, item1);
    }
    
    @After
    public void cleanUp() throws Exception{
        utx.begin();
        sizeQuantityDAO.remove(sizeQuantityDAO.merge(sizeItem1));
        sizeQuantityDAO.remove(sizeQuantityDAO.merge(sizeItem2));
        sizeQuantityDAO.remove(sizeQuantityDAO.merge(sizeItem3));
        clothingItemDAO.remove(item1);
        clothingItemDAO.remove(item2);
        clothingItemDAO.remove(item3);
        utx.commit();
    }

    @Test
    public void checkThatFindlothingItemsMatchingNameMatchesCorrectly() {
        List<ClothingItem> p_list = clothingItemDAO.findClothingItemsMatchingLabel("Adidas T-Shirt");
        Assert.assertEquals(2, p_list.size());
    }

    @Test
    public void checkThatFindClothingItemsBySearchLabelFindsCorrect() {
        String searchLabel = "dress";
        List<ClothingItem> p = clothingItemDAO.findClothingItemsBySearchLabel(searchLabel);
        p.forEach(clothingItem -> {
            Assert.assertTrue(clothingItem.getDescription().contains(searchLabel) || clothingItem.getLabel().contains(searchLabel));
        });
    }

    @Test
    public void checkThatfindMaxClothingItemPricefindsMax() {
        double expectedMaxPrice = 490.90;
        double p = clothingItemDAO.findMaxProductPrice();
        Assert.assertEquals(expectedMaxPrice, p, 1);
    }

    @Test
    public void checkThatfindMinClothingItemPricefindsMin() {
        double expectedMinPrice = 390.90;
        double p = clothingItemDAO.findMinProductPrice();
        Assert.assertEquals(expectedMinPrice, p, 1);
    }

    @Test
    public void checkFindClothingItemsWithFilters() {
        //System.out.println(clothingItemDAO.findClothingItemsWithFilters(Arrays.asList("L","M"),Arrays.asList("Black","White"), 0, 10000));
        Assert.assertEquals(Arrays.asList(clothingItemDAO.find(item1.getId())), clothingItemDAO.findClothingItemsWithFilters(Arrays.asList("L"), Arrays.asList("Black"), 0, 10000));
        //Assert.assertTrue(true);
    }

    @Test
    @Ignore
    public void checkRemoveAllClothingItems() throws Exception {
        
        Assert.assertEquals(new ArrayList(), clothingItemDAO.findAll());
    }

}
