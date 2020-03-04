/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author madel
 */
@SessionScoped
@Named
public class CartBean implements Serializable {

    private ArrayList<String> products;

    public void addProduct(String product){
        products.add(product);
    }
    
    public boolean removeProduct(String product){
        return products.remove(product);
    }
    
    public ArrayList<String> getProducts(){
        return products;
    }

    public String getMessage(){
        return "Hej";
    }
    
    @PostConstruct
    public void init() {
        this.products = new ArrayList<String>();
    }
}

