/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author madel
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CustomerOrderClothingItemId.class)
public class CustomerOrderClothingItem implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private CustomerOrder customerOrder;

    @Id
    @ManyToOne
    @JoinColumn
    private ClothingItem clothingItem;

    private int quantity;
    private String size;
}
