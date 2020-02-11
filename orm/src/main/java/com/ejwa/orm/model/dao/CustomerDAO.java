package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CustomerDAO extends AbstractDAO<Product> {
	@Getter @PersistenceContext(unitName = "academy")
	private EntityManager entityManager;

	public CustomerDAO() {
		super(Product.class);
	}

	public List<Product> findCustomersMatchingName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
