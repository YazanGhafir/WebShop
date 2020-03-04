/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.bean;

/**
 *
 * @author madel
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CartBean implements Cart {

    String customerId;
    String customerName;
    List<String> contents;

    @Override
    public void initialize(String person) {

        customerName = person;

        customerId = "0";
        contents = new ArrayList<>();
    }

   

    @Override
    public void addProduct(String title) {
        contents.add(title);
    }

    @Override
    public void removeProduct(String title){
        boolean result = contents.remove(title);
    }

    @Override
    public List<String> getContents() {
        return contents;
    }

    @Remove
    @Override
    public void remove() {
        contents = null;
    }
}
