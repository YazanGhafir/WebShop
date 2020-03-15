/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.bean;

import com.ejwa.orm.model.dao.ClothingItemDAO;
import com.ejwa.orm.model.dao.CustomerOrderDAO;
import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.CustomerOrder;
import com.ejwa.orm.model.entity.Product;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;
import lombok.Getter;

/**
 *
 * @author madel
 */
@Data
@SessionScoped
@Named
public class CartBean implements Serializable {

    @EJB
    private ClothingItemDAO clothingItemDAO;

    @EJB
    private CustomerOrderDAO customerOrderDAO;

    @Getter
    private List<ClothingItem> items;

    @Getter
    private String customerInfo;


    public void addItem(Long id) {
        items.add(clothingItemDAO.findClothingItemMatchingID(id));
    }

    public boolean removeItem(Long id) {
        return items.remove(clothingItemDAO.findClothingItemMatchingID(id));
    }

    @PostConstruct
    public void init() {
        this.items = new ArrayList<ClothingItem>();
        items.add(new ClothingItem("Adidas T-Shirt", 5.0, "this is the description", "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg", "Black"));
    }

    public String createOrder() {
        LocalDateTime test_date = LocalDateTime.of(2014, Month.SEPTEMBER, 11, 16, 15, 15);;
        CustomerOrder order = new CustomerOrder(test_date);
        order.setClothesList(items);
        customerOrderDAO.create(order);
        return "Order Created";
    }

    public void addCustomerInfoAfterLogin(String customerInfo) {
        this.customerInfo = customerInfo;
    }
    
    public void removeCustomerInfoAfterLogout() {
        this.customerInfo = "A Great Person :D";
    }
}
