package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.CustomerOrder;
import com.ejwa.orm.model.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class OrderDAO extends AbstractDAO<CustomerOrder> {
	@Getter @PersistenceContext(unitName = "webshopDB")
	private EntityManager entityManager;

	public OrderDAO() {
		super(CustomerOrder.class);
	}

	public List<CustomerOrder> findOrdersMatchingName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
