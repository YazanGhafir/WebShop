/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author madel
 */
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class ClothingItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clothingItem_id;
    @NonNull
    private String label;
    @NonNull
    private Double price;
    @NonNull
    private String description;
    @NonNull
    private String image;
    @NonNull
    private String colour;
    
    @OneToMany(mappedBy = "clothingItem")
    private List<SizeQuantity> sizeList;
    
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;
    
    @ManyToMany
    private List<CustomerOrder> customerOrders;
}
