/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.QSizeQuantity_;
import com.ejwa.orm.model.entity.SizeQuantity;
import com.ejwa.orm.model.entity.SizeQuantityId;
import easycriteria.JPAQuery;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author madel
 */
@Stateless
public class SizeQuantityDAO extends AbstractDAO<SizeQuantity, SizeQuantityId> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public SizeQuantityDAO() {
        super(SizeQuantity.class);
    }

    public List<SizeQuantity> findSizeQuantityForId(Long id) {
        QSizeQuantity_ sq = new QSizeQuantity_();
        List<SizeQuantity> sl = new JPAQuery(getEntityManager()).select(SizeQuantity.class)
                .where(sq.clothingItem.product_id.eq(id))
                .getResultList();
        return sl;
    } 
    
     public List<SizeQuantity> findSizeQuantityForSize(String size) {
        QSizeQuantity_ sq = new QSizeQuantity_();
        List<SizeQuantity> sl = new JPAQuery(getEntityManager()).select(SizeQuantity.class)
                .where(sq.size.eq(size))
                .getResultList();
        return sl;
    }
}
