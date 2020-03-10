/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.Category;
import com.ejwa.orm.model.entity.ProductGroup;
import com.ejwa.orm.model.entity.QCategory_;
import com.ejwa.orm.model.entity.QProductGroup_;
import easycriteria.JPAQuery;
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
public class ProductGroupDAO  extends AbstractDAO<ProductGroup> {
	@Getter @PersistenceContext(unitName = "webshopDB")
	private EntityManager entityManager;

	public ProductGroupDAO() {
		super(ProductGroup.class);
	}

        
        public ProductGroup findProductGroupMatchingID(Long id) {
        QProductGroup_ cat = new QProductGroup_();
        ProductGroup p = new JPAQuery(getEntityManager()).select(ProductGroup.class)
                .where(
                        cat.group_id.eq(id)
                ).getSingleResult();
        return p;
    }

}
