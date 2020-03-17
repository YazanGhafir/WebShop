/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SizeQuantityId.class)
public class SizeQuantity implements Serializable {
    @Id
    private String size;

    private Integer quantity;
    
    @Id
    @ManyToOne
    private ClothingItem clothingItem;

}
