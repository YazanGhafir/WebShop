/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.QClothingItem_;
import com.ejwa.orm.model.entity.QSizeQuantity_;
import easycriteria.JPAQuery;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import lombok.Getter;

/**
 *
 * @author madel
 */
@Stateless
public class ClothingItemDAO extends AbstractDAO<ClothingItem, Long> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public ClothingItemDAO() {
        super(ClothingItem.class);
    }
    
    public ClothingItem findClothingItemMatchingID(Long id) {
        QClothingItem_ clothingItem = new QClothingItem_();
        ClothingItem ci = new JPAQuery(getEntityManager()).select(ClothingItem.class)
                .where(
                        clothingItem.clothingItem_id.eq(id)
                ).getSingleResult();
        return ci;
    }

    public List<ClothingItem> findClothingItemsMatchingLabel(String name) {
        QClothingItem_ clothingItem = new QClothingItem_();
        List<ClothingItem> ci_list = new JPAQuery(getEntityManager()).select(ClothingItem.class)
                .where(
                        clothingItem.label.eq(name)
                ).getResultList();
        return ci_list;
    }
    
    public List<ClothingItem> findClothingItemsBySearchLabel(String searchText) {
        QClothingItem_ clothingItem = new QClothingItem_();
        List<ClothingItem> ci_list = new JPAQuery(entityManager).select(ClothingItem.class)
                .where(
                        clothingItem.description.like("%" + searchText + "%")
                                .or(clothingItem.label.like("%" + searchText + "%"))
                )
                .getResultList();
        return ci_list;
    }
    
     public List<ClothingItem> findClothingItemsWithFilters(List<String> size, List<String> colour, double minPrice, double maxPrice) {
         QClothingItem_ clothingItem = new QClothingItem_();
         QSizeQuantity_ sizeQuantity = new QSizeQuantity_();
         
        List<ClothingItem> ci_list = new JPAQuery(entityManager).select(ClothingItem.class)
                .where(
                        clothingItem.colour.in(colour)
                                .and(clothingItem.price.between(minPrice, maxPrice))
                ).join(clothingItem, JoinType.INNER, sizeQuantity)
                .where(sizeQuantity.size.in(size))
                .getResultList();
        return ci_list;
    }

    public void removeAllClothingItems() {
        QClothingItem_ clothingItem = new QClothingItem_();
        List<ClothingItem> ci_list = new JPAQuery(getEntityManager()).select(ClothingItem.class).getResultList();
        for (ClothingItem ci : ci_list) {
            remove(ci);
        }
    }

    public void remove(ClothingItem entity){
        ClothingItem entityToRemove = entityManager.find(ClothingItem.class, entity.getClothingItem_id());
        entityManager.remove(entityToRemove);
    }
    
    public double findMaxClothingItemPrice() {
        
        QClothingItem_ clothingItem = new QClothingItem_();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Double> q = cb.createQuery(Double.class);
        Root<ClothingItem> r = q.from(ClothingItem.class);
        q.select(cb.max(r.get("price")));

        Double p = entityManager.createQuery(q).getSingleResult();

        return p;
    }

    public double findMinClothingItemPrice() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Double> q = cb.createQuery(Double.class);
        Root<ClothingItem> r = q.from(ClothingItem.class);
        q.select(cb.min(r.get("price")));

        TypedQuery<Double> query = entityManager.createQuery(q);

        Double p = query.getSingleResult();

        return p;
    }

}
