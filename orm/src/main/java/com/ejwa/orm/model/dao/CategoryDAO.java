package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CategoryDAO extends AbstractDAO<Product> {
	@Getter @PersistenceContext(unitName = "academy")
	private EntityManager entityManager;

	public CategoryDAO() {
		super(Product.class);
	}

	public List<Product> findCategoriesMatchingName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
