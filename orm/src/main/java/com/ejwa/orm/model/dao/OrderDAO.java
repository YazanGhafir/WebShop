package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class OrderDAO extends AbstractDAO<Product> {
	@Getter @PersistenceContext(unitName = "webshopDB")
	private EntityManager entityManager;

	public OrderDAO() {
		super(Product.class);
	}

	public List<Product> findOrdersMatchingName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}