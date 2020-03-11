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
import javax.ejb.EJB;
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
    
   
    @EJB
    private SizeQuantityDAO sizeDao;

    public ClothingItemDAO() {
        super(ClothingItem.class);
    }

    public void removeSizes(ClothingItem entity){
        entity.getSizeList().forEach(size -> sizeDao.remove(size));
        
    }
    
    public ClothingItem findClothingItemMatchingID(Long id) {
        QClothingItem_ clothingItem = new QClothingItem_();
        ClothingItem ci = new JPAQuery(getEntityManager()).select(ClothingItem.class)
                .where(
                        clothingItem.product_id.eq(id)
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
    
     public List<ClothingItem> findProductsWithFilters(List<String> size, List<String> colour, double minPrice, double maxPrice, int ofset, int rowCount) {
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
