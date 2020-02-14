package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Customer;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CustomerDAO extends AbstractDAO<Customer> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public CustomerDAO() {
        super(Customer.class);
    }

    public List<Customer> findCustomersMatchingEmail(String email) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
