/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.bean;

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

    private ArrayList<Product> products;

    public void addProduct(Product product){
        products.add(product);
    }
    
    public boolean removeProduct(Product product){
        return products.remove(product);
    }
    
    public ArrayList<Product> getProducts(){
        return products;
    }

    public String getMessage(){
        return "Hej";
    }
    
    @PostConstruct
    public void init() {
        this.products = new ArrayList<Product>();
        products.add(new Product("Adidas T-Shirt", 5.0));
    }
}

