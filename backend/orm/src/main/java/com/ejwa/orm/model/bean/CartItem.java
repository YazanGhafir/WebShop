/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.bean;

import com.ejwa.orm.model.entity.ClothingItem;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author madel
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem implements Serializable {

    private ClothingItem item;
    private String size;
    private int quantity;
}
