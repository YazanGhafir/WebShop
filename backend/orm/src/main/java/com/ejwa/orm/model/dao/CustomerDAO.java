package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.*;
import easycriteria.JPAQuery;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CustomerDAO extends AbstractDAO<Customer, Long> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public CustomerDAO() {
        super(Customer.class);
    }
    

    public boolean register_customer_signup (String email, String password){
        Customer customer_to_register = new Customer(email, password);
        if(is_registered_Customer(email, password)) return false; //already registered customer
        create(customer_to_register);
        Customer customer_to_validate_registration = authenticateCustomer(email, password);
        return customer_to_register.equals(customer_to_validate_registration);
    }
    

    public boolean is_registered_Customer(String email, String password){
        QCustomer_ c_ = new QCustomer_();
        try {
        Customer c = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.email.eq(email).and(
                        c_.password.eq(password))
                ).getSingleResult();
        } catch (NoResultException e){
            return false;
        }
        return true;
    }
    
    public Customer authenticateCustomer(String email, String password){
        QCustomer_ c_ = new QCustomer_();
        Customer c = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.email.eq(email).and(
                        c_.password.eq(password))
                ).getSingleResult();
        return c;
    }
    
   public boolean remove_Customer(String email, String password){
        QCustomer_ c_ = new QCustomer_();
        try {
        Customer c = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.email.eq(email).and(
                        c_.password.eq(password))
                ).getSingleResult();
        remove(c);
        } catch (NoResultException e){
            return false;
        }
        return true;
    }
    
    public Customer findCustomerMatchingID(Long id) {
        QCustomer_ c_ = new QCustomer_();
        Customer c = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.customer_id.eq(id)
                ).getSingleResult();
        return c;
    }
    
    public Customer findCustomerMatchingEmail(String email) {
        QCustomer_ c_ = new QCustomer_();
        Customer c = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.email.eq(email)
                ).getSingleResult();
        return c;
    }
        
    public List<Customer> findCustomerOrdersMatchingShippingAdress(String shippingAdress) {
        QCustomer_ c_ = new QCustomer_();
        List<Customer> c_list = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.shippingAdress.eq(shippingAdress)
                ).getResultList();
        return c_list;
    }
    
    public List<Customer> findCustomerOrdersMatchingHomeAdress(String homeAdress) {
        QCustomer_ c_ = new QCustomer_();
        List<Customer> c_list = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.homeAdress.eq(homeAdress)
                ).getResultList();
        return c_list;
    }
    
    public List<Customer> findCustomerOrdersMatchingLastName(String lastName) {
        QCustomer_ c_ = new QCustomer_();
        List<Customer> c_list = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.lastName.eq(lastName)
                ).getResultList();
        return c_list;
    }
    
    public List<Customer> findCustomerOrdersMatchingFirstName(String firstName) {
        QCustomer_ c_ = new QCustomer_();
        List<Customer> c_list = new JPAQuery(getEntityManager()).select(Customer.class)
                .where(
                        c_.firstName.eq(firstName)
                ).getResultList();
        return c_list;
    }
    
}

