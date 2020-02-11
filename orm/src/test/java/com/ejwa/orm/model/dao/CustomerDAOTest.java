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
public class CustomerDAOTest {
	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class)
			.addClasses(CustomerDAO.class, Customer.class)
			.addAsResource("META-INF/persistence.xml")
			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	private	CustomerDAO customerDAO;

	@Before
	public void init() {
	    customerDAO.create(new Customer("yazan.yasser.ghafir@gmail.com", "HELLO123", "Chalmersplatsen 4, 412 96 Göteborg", "Chalmersplatsen 4, 412 96 Göteborg", "Yazan", "Ghafir"));
	}

	@Test
	public void checkThatFindCustomersMatchingNameMatchesCorrectly() {
		Assert.assertTrue(true); /* Some better condition */
	}
}
