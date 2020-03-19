/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.dao;

import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.CustomerOrderClothingItem;
import com.ejwa.orm.model.entity.CustomerOrderClothingItemId;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.Getter;

/**
 *
 * @author madel
 */
@Stateless
public class CustomerOrderClothingItemDAO  extends AbstractDAO<CustomerOrderClothingItem, CustomerOrderClothingItemId> {

    @Getter
    @PersistenceContext(unitName = "webshopDB")
    private EntityManager entityManager;
    
    
     public CustomerOrderClothingItemDAO() {
        super(CustomerOrderClothingItem.class);
    }
}
