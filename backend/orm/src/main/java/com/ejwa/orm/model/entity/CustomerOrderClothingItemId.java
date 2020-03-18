/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author madel
 */  

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderClothingItemId implements Serializable{
    
    private Long customerOrder;
    private Long clothingItem;
        
}
