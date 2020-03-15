/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.bean;

import com.ejwa.orm.model.entity.ClothingItem;
import com.ejwa.orm.model.entity.Product;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;

/**
 *
 * @author madel
 */
@Data
@SessionScoped
@Named
public class CartBean implements Serializable {

    private ArrayList<ClothingItem> products;

    public void addProduct(ClothingItem product){
        products.add(product);
    }
    
    public boolean removeProduct(ClothingItem product){
        return products.remove(product);
    }
    
    public ArrayList<ClothingItem> getProducts(){
        return products;
    }

    public String getMessage(){
        return "Hej";
    }
    
    @PostConstruct
    public void init() {
        this.products = new ArrayList<ClothingItem>();
        products.add(new ClothingItem("Adidas T-Shirt", 5.0,"this is the description", "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg", "Black"));
    }
}

