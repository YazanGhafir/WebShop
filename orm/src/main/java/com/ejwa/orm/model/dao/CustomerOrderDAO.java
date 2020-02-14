package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.CustomerOrder;
import com.ejwa.orm.model.entity.QCustomerOrder_;
import easycriteria.JPAQuery;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CustomerOrderDAO extends AbstractDAO<CustomerOrder> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public CustomerOrderDAO() {
        super(CustomerOrder.class);
    }

    public CustomerOrder findCustomerOrderMatchingID(Long id) {
        QCustomerOrder_ qo_ = new QCustomerOrder_();
        CustomerOrder qo = new JPAQuery(getEntityManager()).select(CustomerOrder.class)
                .where(
                        qo_.customerorder_id.eq(id)
                ).getSingleResult();
        return qo;
    }

    public List<CustomerOrder> findCustomerOrdersMatchingDate(Date date) {
        QCustomerOrder_ qo_ = new QCustomerOrder_();
        List<CustomerOrder> q_List = new JPAQuery(getEntityManager()).select(CustomerOrder.class)
                .where(
                        qo_.date.eq(date)
                ).getResultList();
        return q_List;
    }
    
    /* TODO ASK ABOUT
    public List<CustomerOrder> findCustomerOrdersBeforeOrEqualDate(Date date) {
        QCustomerOrder_ qo_ = new QCustomerOrder_();
        List<CustomerOrder> q_List = new JPAQuery(getEntityManager()).select(CustomerOrder.class)
                .where(
                        qo_.date.lessThanOrEqualTo(date)
                ).getResultList();
        return q_List;
    }
    
    public List<CustomerOrder> findCustomerOrdersAfterOrEqualDate(Date date) {
        QCustomerOrder_ qo_ = new QCustomerOrder_();
        List<CustomerOrder> q_List = new JPAQuery(getEntityManager()).select(CustomerOrder.class)
                .where(
                        qo_.date.greaterThanOrEqualTo(date)
                ).getResultList();
        return q_List;
    }
*/
   
   
    
    
}
