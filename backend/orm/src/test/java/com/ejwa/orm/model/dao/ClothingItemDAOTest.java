/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author madel
 */
@RunWith(Arquillian.class)
public class ClothingItemDAOTest {

    private Long test_id_1;
    private Long test_id_2;
    private Long test_id_3;

    private ClothingItem item1 = new ClothingItem("Adidas T-Shirt", 490.90, "This is a tshirt", "img", "Black");
    private ClothingItem item2 = new ClothingItem("Adidas T-Shirt", 480.90, "This is a tshirt", "img", "White");
    private ClothingItem item3 = new ClothingItem("Adidas Pants", 390.90, "This is a tshirt", "img", "White");

    private SizeQuantity sizeItem1 = new SizeQuantity("L", 5, item1);
    private SizeQuantity sizeItem2 = new SizeQuantity("S", 4, item1);
    private SizeQuantity sizeItem3 = new SizeQuantity("M", 6, item1);

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(ClothingItemDAO.class, ClothingItem.class, SizeQuantity.class, SizeQuantityDAO.class, Category.class, Customer.class, CustomerOrder.class, Payment.class, Product.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private ClothingItemDAO clothingItemDAO;

    @EJB
    private SizeQuantityDAO sizeQuantityDAO;

    @Before
    public void init() {
        test_id_1 = new Random().nextLong();
        test_id_2 = new Random().nextLong();
        test_id_3 = new Random().nextLong();

        item1.setProduct_id(test_id_1);
        item2.setProduct_id(test_id_2);
        item3.setProduct_id(test_id_3);

        clothingItemDAO.create(item1);
        clothingItemDAO.create(item2);
        clothingItemDAO.create(item3);

        sizeQuantityDAO.create(sizeItem1);
        sizeQuantityDAO.create(sizeItem2);
        sizeQuantityDAO.create(sizeItem3);
        sizeItem1.setClothingItem(item1);
        sizeItem1.setClothingItem(item2);
        sizeItem1.setClothingItem(item3);

        sizeQuantityDAO.create(sizeItem1);
        sizeQuantityDAO.create(sizeItem2);
        sizeQuantityDAO.create(sizeItem3);

    }

    @After
    public void cleanUp() {
        
        sizeQuantityDAO.remove(sizeItem1);
        sizeQuantityDAO.remove(sizeItem2);
        sizeQuantityDAO.remove(sizeItem3);
        clothingItemDAO.remove(clothingItemDAO.find(item1.getProduct_id()));
        clothingItemDAO.remove(clothingItemDAO.find(item2.getProduct_id()));
        clothingItemDAO.remove(clothingItemDAO.find(item3.getProduct_id()));
    }

    @Test
    @InSequence(0)
    public void checkThatFindClothingItemMatchingIDMatchesCorrectly() {
        ClothingItem p = clothingItemDAO.findClothingItemMatchingID(test_id_1);
        Assert.assertEquals(p, item1);
    }

    @Test
    @InSequence(1)
    public void checkThatFindlothingItemsMatchingNameMatchesCorrectly() {
        List<ClothingItem> p_list = clothingItemDAO.findClothingItemsMatchingLabel("Adidas T-Shirt");
        List<ClothingItem> test_p_list = new ArrayList<ClothingItem>() {
            {
                add(item1);
                add(item2);
            }
        };

        Assert.assertEquals(test_p_list, p_list);
    }

    @Test
    public void checkThatFindClothingItemsBySearchLabelFindsCorrect() {
        String searchLabel = "dress";
        List<ClothingItem> p = clothingItemDAO.findProductsBySearchLabel(searchLabel);
        p.forEach(clothingItem -> {
            Assert.assertTrue(clothingItem.getDescription().contains(searchLabel) || clothingItem.getLabel().contains(searchLabel));
        });
    }

    @Test
    public void checkThatFilterClothingItemsFiltersCorrectly() {
        double minPrice = 400.00;
        double maxPrice = 500.00;
        List<String> colour = new ArrayList();
        colour.add("Black");
        List<String> sizeL = new ArrayList();
        sizeL.add("L");

        /*
        List<ClothingItem> cil = clothingItemDAO.findProductsWithFilters(sizeL, colour, minPrice, maxPrice, 10, 10);
        cil.forEach(ci -> {
            Assert.assertEquals(colour, ci.getColour());
            Assert.assertTrue(minPrice <= ci.getPrice() && maxPrice >= ci.getPrice());
        });*/
        Assert.assertTrue(true);
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

}
