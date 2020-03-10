/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.QClothingItem_;
import easycriteria.EasyCriteriaQuery;
import easycriteria.JPAQuery;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import lombok.Getter;

/**
 *
 * @author madel
 */
@Stateless
public class ClothingItemDAO extends AbstractDAO<ClothingItem> {

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
                        clothingItem.product_id.eq(id)
                ).getSingleResult();
        return ci;
    }

    public List<ClothingItem> findClothingItemsMatchingName(String name) {
        QClothingItem_ clothingItem = new QClothingItem_();
        List<ClothingItem> ci_list = new JPAQuery(getEntityManager()).select(ClothingItem.class)
                .where(
                        clothingItem.label.eq(name)
                ).getResultList();
        return ci_list;
    }
    
    public List<ClothingItem> findProductsBySearchLabel(String searchText, int ofset, int rowCount) {
        QClothingItem_ clothingItem = new QClothingItem_();
        List<ClothingItem> ci_list = new JPAQuery(entityManager).select(ClothingItem.class)
                .where(
                        clothingItem.description.like("%" + searchText + "%")
                                .or(clothingItem.label.like("%" + searchText + "%"))
                )
                .limit(ofset, rowCount)
                .getResultList();
        return ci_list;
    }


    public List<ClothingItem> findProductsWithFilters(String size, String colour, double minPrice, double maxPrice, int ofset, int rowCount) {
        QClothingItem_ clothingItem = new QClothingItem_();
        EasyCriteriaQuery query = new JPAQuery(entityManager).select(ClothingItem.class);

        if (!size.equals(null)) {
            //TODO implement filter out sizes (get all sizeQuantities for that size, then filter out the results?
        }
        if(!colour.equals(null)){
            query.addWhereCondition(clothingItem.colour.eq(colour));
        }
        
        query.addWhereCondition(clothingItem.price.between(minPrice, maxPrice));

        List<ClothingItem> cil = query
                .limit(ofset, rowCount)
                .getResultList();
        return cil;
    }

    public void removeAllProduct() {
        QClothingItem_ clothingItem = new QClothingItem_();
        List<ClothingItem> ci_list = new JPAQuery(getEntityManager()).select(ClothingItem.class).getResultList();
        for (ClothingItem ci : ci_list) {
            remove(ci);
        }
    }

    public double findMaxProductPrice() {
        
        QClothingItem_ clothingItem = new QClothingItem_();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Double> q = cb.createQuery(Double.class);
        Root<ClothingItem> r = q.from(ClothingItem.class);
        q.select(cb.max(r.get("price")));

        Double p = entityManager.createQuery(q).getSingleResult();

        return p;
    }

    public double findMinProductPrice() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Double> q = cb.createQuery(Double.class);
        Root<ClothingItem> r = q.from(ClothingItem.class);
        q.select(cb.min(r.get("price")));

        TypedQuery<Double> query = entityManager.createQuery(q);

        Double p = query.getSingleResult();

        return p;
    }

}
