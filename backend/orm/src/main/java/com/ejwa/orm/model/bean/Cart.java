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
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface Cart {
    public void initialize(String person);
    public void addProduct(String title);
    public void removeProduct(String title);
    public List<String> getContents();
    public void remove();
}
