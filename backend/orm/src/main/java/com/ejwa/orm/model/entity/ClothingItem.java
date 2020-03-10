/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.entity;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    private Long product_id;
    @NonNull
    private Long groupId;
    @NonNull
    private String name;
    @NonNull
    private Double price;
    @NonNull
    private String size;
    
    private String description;
    
    private String image;
    
    private String colour;
    
    @JoinColumn(name = "group_id")
    @ManyToOne
    private ProductGroup group;
}
