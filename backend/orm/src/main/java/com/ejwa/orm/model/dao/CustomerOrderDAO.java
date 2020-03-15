package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.CustomerOrder;
import com.ejwa.orm.model.entity.QCustomerOrder_;
import easycriteria.JPAQuery;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class CustomerOrderDAO extends AbstractDAO<CustomerOrder, Long> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public CustomerOrderDAO() {
        super(CustomerOrder.class);
    }
    
     public void remove(CustomerOrder entity) {
        CustomerOrder entityToRemove = entityManager.find(CustomerOrder.class, entity.getCustomerorder_id());
        entityManager.remove(entityToRemove);
    }

    public CustomerOrder findCustomerOrderMatchingID(Long id) {
        QCustomerOrder_ qo_ = new QCustomerOrder_();
        CustomerOrder qo = new JPAQuery(getEntityManager()).select(CustomerOrder.class)
                .where(
                        qo_.customerorder_id.eq(id)
                ).getSingleResult();
        return qo;
    }

    public List<CustomerOrder> findCustomerOrdersMatchingDate(LocalDateTime date) {
        QCustomerOrder_ qo_ = new QCustomerOrder_();
        List<CustomerOrder> q_List = new JPAQuery(getEntityManager()).select(CustomerOrder.class)
                .where(
                        qo_.date.eq(date)
                ).getResultList();
        return q_List;
    }
   
    public List<CustomerOrder> findCustomerOrdersBeforeOrEqualDate(LocalDateTime date) {
        QCustomerOrder_ qo_ = new QCustomerOrder_();
        List<CustomerOrder> q_List = new JPAQuery(getEntityManager()).select(CustomerOrder.class)
                .where(
                        qo_.date.lessThanOrEqualTo(date)
                ).getResultList();
        return q_List;
    }
    
    public List<CustomerOrder> findCustomerOrdersAfterOrEqualDate(LocalDateTime date) {
        QCustomerOrder_ qo_ = new QCustomerOrder_();
        List<CustomerOrder> q_List = new JPAQuery(getEntityManager()).select(CustomerOrder.class)
                .where(
                        qo_.date.greaterThanOrEqualTo(date)
                ).getResultList();
        return q_List;
    }
}
