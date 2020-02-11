package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.*;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class PaymentDAO extends AbstractDAO<Payment> {
	@Getter @PersistenceContext(unitName = "webshopDB")
	private EntityManager entityManager;

	public PaymentDAO() {
		super(Payment.class);
	}

	public List<Payment> findPaymentsMatchingName() {
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
