package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.*;
import easycriteria.JPAQuery;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class MessageDAO extends AbstractDAO<MessageContactUs, Long> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public MessageDAO() {
        super(MessageContactUs.class);
    }

}
