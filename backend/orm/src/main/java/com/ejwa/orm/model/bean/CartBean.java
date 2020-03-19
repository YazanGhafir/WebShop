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
import com.ejwa.orm.model.entity.CustomerOrderClothingItem;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;
import lombok.Getter;

/**
 *
 * @author madel
 */
@Data
@Singleton
public class CartBean implements Serializable {

    @EJB
    private ClothingItemDAO clothingItemDAO;

    @EJB
    private CustomerOrderDAO customerOrderDAO;

    @Getter
    private List<CartItem> items;

    private String customerInfo;
    
    private String customerEmail;
    
    private boolean inloggningsstatus = false;

    public void addItem(Long id, String size) {
        ClothingItem ci = clothingItemDAO.findClothingItemMatchingID(id);
        boolean found = false;
        List<CartItem> newList = new ArrayList<CartItem>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItem().getId() == (id) && items.get(i).getSize().equals(size)) {
                int oldQuantity = items.get(i).getQuantity();
                CartItem newItem = items.get(i);
                newItem.setQuantity(oldQuantity + 1);
                newList.add(newItem);
                found = true;
            } else {
                newList.add(items.get(i));
            }
        }
        if (!found) {
            newList.add(new CartItem(ci, size, 1));
        }
        items = newList;
    }

    public void updateQuantity(long id, int quantity, String size) {
        items.forEach(i -> {
            if (i.getItem().getId() == (id) && i.getSize().equals(size)) {
                i.setQuantity(quantity);
            }
        });
    }

    public void removeItem(Long id, String size) {
        List<CartItem> newList = new ArrayList<CartItem>();
        items.forEach(i -> {
            if (!(i.getItem().getId() == (id) && i.getSize().equals(size))) {
                newList.add(i);
            }
        });
        items = newList;
    }

    @PostConstruct
    public void init() {
        this.items = new ArrayList<CartItem>();
        ClothingItem ci = new ClothingItem("Adidas T-Shirt", 580.0, "this is the description", "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg", "Black");
        clothingItemDAO.create(ci);
        items.add(new CartItem(ci, "L", 1));
    }

    public String createOrder() {
        LocalDateTime test_date = LocalDateTime.of(2014, Month.SEPTEMBER, 11, 16, 15, 15);;
        CustomerOrder order = new CustomerOrder(test_date);
        List<CustomerOrderClothingItem> clothesList = new ArrayList<CustomerOrderClothingItem>();
        items.forEach(i -> {
            CustomerOrderClothingItem c = new CustomerOrderClothingItem();
            c.setClothingItem(i.getItem());
            c.setQuantity(i.getQuantity());
            c.setSize(i.getSize());
            clothesList.add(c);
        });
        order.setClothesList(clothesList);
        customerOrderDAO.create(order);
        return "Order Created";
    }

    public void addCustomerInfoAfterLogin(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public void removeCustomerInfoAfterLogout() {
        this.customerInfo = "A Great Person :D";
    }
    
    public List<CustomerOrder> getHistory(){
        return this.customerOrderDAO.findCustomerOrdersMatchingCustomer(customerEmail);
    }    

}
