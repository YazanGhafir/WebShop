package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.*;
import easycriteria.JPAQuery;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class PaymentDAO extends AbstractDAO<Payment> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public PaymentDAO() {
        super(Payment.class);
    }

    public List<Payment> findPaymentsMatchingName() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Payment findPaymentMatchingID(Long id) {
        QPayment_ payment = new QPayment_();
        Payment p = new JPAQuery(getEntityManager()).select(Payment.class)
                .where(
                        payment.payment_id.eq(id)
                ).getSingleResult();
        return p;
    }

    public List<Payment> findPaymentsMatchingPaymentType(String paymentType) {
        QPayment_ payment = new QPayment_();
        List<Payment> p_List = new JPAQuery(getEntityManager()).select(Payment.class)
                .where(
                        payment.paymentType.eq(paymentType)
                ).getResultList();
        return p_List;
    }
}
