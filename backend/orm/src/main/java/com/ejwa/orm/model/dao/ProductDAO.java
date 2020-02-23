package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Product;
import com.ejwa.orm.model.entity.QProduct_;
import easycriteria.JPAQuery;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

@Stateless
public class ProductDAO extends AbstractDAO<Product> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;

    public ProductDAO() {
        super(Product.class);
    }


    public Product findProductMatchingID(Long id) {
        QProduct_ product = new QProduct_();
        Product p = new JPAQuery(getEntityManager()).select(Product.class)
                .where(
                        product.product_id.eq(id)
                ).getSingleResult();
        return p;
    }
    
    public List<Product> findProductsMatchingName(String name) {
        QProduct_ product = new QProduct_();
        List<Product> p_List = new JPAQuery(getEntityManager()).select(Product.class)
                .where(
                        product.name.eq(name)
                ).getResultList();
        return p_List;
    }
    
    public List<Product> findProductsMatchingPrice(Double price) {
        QProduct_ product = new QProduct_();
        List<Product> p_List = new JPAQuery(getEntityManager()).select(Product.class)
                .where(
                        product.price.eq(price)
                ).getResultList();
        return p_List;
    }
    
    public List<Product> findProductsHigherPriceOrEqual(Double price) {
        QProduct_ product = new QProduct_();
        List<Product> p_List = new JPAQuery(getEntityManager()).select(Product.class)
                .where(
                        product.price.greaterThanOrEqualTo(price)
                ).getResultList();
        return p_List;
    }
    
    public List<Product> findProductsHigherPrice(Double price) {
        QProduct_ product = new QProduct_();
        List<Product> p_List = new JPAQuery(getEntityManager()).select(Product.class)
                .where(
                        product.price.greaterThan(price)
                ).getResultList();
        return p_List;
    }
    
    public List<Product> findProductsLowerPriceOrEqual(Double price) {
        QProduct_ product = new QProduct_();
        List<Product> p_List = new JPAQuery(getEntityManager()).select(Product.class)
                .where(
                        product.price.lessThanOrEqualTo(price)
                ).getResultList();
        return p_List;
    }
    
    public List<Product> findProductsLowerPrice(Double price) {
        QProduct_ product = new QProduct_();
        List<Product> p_List = new JPAQuery(getEntityManager()).select(Product.class)
                .where(
                        product.price.lessThan(price)
                ).getResultList();
        return p_List;
    }
    
    // ADD sorting and popularity
}
