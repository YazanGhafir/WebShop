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
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Arquillian.class)
public class CategoryDAOTest {

    private Long test_id_1;
    private Long test_id_2;
    private Long test_id_3;

    private Category test_cat1 = new Category("Tshirts");
    private Category test_cat2 = new Category("Shorts");
    private Category test_cat3 = new Category("Jackets");

    //private Category RESTtest = new Category("REST_test_Jackets");
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(CategoryDAO.class, Product.class, SizeQuantity.class, Category.class, Customer.class, ClothingItem.class, CustomerOrder.class, Payment.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @EJB
    private CategoryDAO categoryDAO;

    @Before
    public void init() {
        test_id_1 = new Random().nextLong();
        test_id_2 = new Random().nextLong();
        test_id_3 = new Random().nextLong();

        test_cat1.setCategory_id(test_id_1);
        test_cat2.setCategory_id(test_id_2);
        test_cat3.setCategory_id(test_id_3);
        
        categoryDAO.create(test_cat1);
        categoryDAO.create(test_cat2);
        categoryDAO.create(test_cat3);

    }

    @After
    public void roll_back_init() {
        categoryDAO.remove(test_cat1);
        categoryDAO.remove(test_cat2);
        categoryDAO.remove(test_cat3);

        //categoryDAO.remove(categoryDAO.find(test_cat2.getCategory_id()));
        //categoryDAO.remove(categoryDAO.find(test_cat3.getCategory_id()));
    }

    /*@Test
    public void Z_just_for_REST_test() {
        categoryDAO.create(RESTtest);
    }*/
    @Test
    public void checkThatFindCategoryMatchingIDMatchesCorrectly() {
        Category cat = categoryDAO.findCategoryMatchingID(test_id_1);
        Assert.assertEquals(cat, test_cat1);
    }

    @Test
    public void checkThatFindCategorysMatchingCategoryNameMatchesCorrectly() {
        List<Category> cat_list = categoryDAO.findCategoriesMatchingCategoryName("Shorts");
        List<Category> test_cat_list = new ArrayList<Category>() {
            {
                add(test_cat2);
            }
        };
        Assert.assertEquals(cat_list, test_cat_list);
    }
}
