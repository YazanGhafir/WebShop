package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CategoryDAO extends AbstractDAO<Category> {
	@Getter @PersistenceContext(unitName = "webshopDB")
	private EntityManager entityManager;

	public CategoryDAO() {
		super(Category.class);
	}

	public List<Category> findCategoriesMatchingName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
