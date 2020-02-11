package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Customer;
import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CustomerDAO extends AbstractDAO<Customer> {
	@Getter @PersistenceContext(unitName = "webshopDB")
	private EntityManager entityManager;

	public CustomerDAO() {
		super(Customer.class);
	}

	public List<Customer> findCustomersMatchingName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
