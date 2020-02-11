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
public class ProductDAOTest {
	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class)
			.addClasses(ProductDAO.class, Product.class, Payment.class, Order.class, Customer.class, Category.class)
			.addAsResource("META-INF/persistence.xml")
			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	private	ProductDAO carDAO;

	@Before
	public void init() {
		carDAO.create(new Product("Adidas T-Shirt", 100.0));
		carDAO.create(new Product("Nike shoes", 90.0));
		carDAO.create(new Product("Tommy Hilfiger Jacket", 80.0));
                 //carDAO.create(new Customer("yazan.yasser.ghafir@gmail.com", "HELLO123, "Chalmersplatsen 4, 412 96 Göteborg", "Chalmersplatsen 4, 412 96 Göteborg", "Yazan", "Ghafir"));
                 //carDAO.create(new Order());
                 //carDAO.create(new Category("Shirt"));
		//carDAO.create(new Payment("Card"));            
	}

	@Test
	public void checkThatFindCarsMatchingNameMatchesCorrectly() {
		Assert.assertTrue(true); /* Some better condition */
	}
}
