package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class ProductDAO extends AbstractDAO<Product> {
	@Getter @PersistenceContext(unitName = "academy")
	private EntityManager entityManager;

	public ProductDAO() {
		super(Product.class);
	}

	public List<Product> findCarsMatchingName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
