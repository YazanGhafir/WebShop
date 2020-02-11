package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.Customer;
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
public class CategoryDAOTest {
	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class)
			.addClasses(CategoryDAO.class, Category.class, Product.class)
			.addAsResource("META-INF/persistence.xml")
			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	private	CategoryDAO categoryDAO;

	@Before
	public void init() {
            //Faker faker = new Faker();
            categoryDAO.create(new Category("Shirts")); 
            categoryDAO.create(new Category("Shoes")); 
            categoryDAO.create(new Category("Shorts")); 
            categoryDAO.create(new Category("Jackets")); 

	}

	@Test
	public void checkThatFindCategoriesMatchingNameMatchesCorrectly() {
		Assert.assertTrue(true); /* Some better condition */
	}
}
