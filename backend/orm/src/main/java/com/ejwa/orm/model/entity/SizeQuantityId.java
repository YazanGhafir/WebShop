/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.entity;

import java.util.Objects;
import lombok.NonNull;

/**
 *
 * @author madel
 */
public class SizeQuantityId {
    
    private String size;
    
    private Long clothingItem;
    
    public SizeQuantityId(){}
    
     public SizeQuantityId(String size, Long clothingItem) {
        this.size = size;
        this.clothingItem = clothingItem;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.size);
        hash = 89 * hash + Objects.hashCode(this.clothingItem);
        return hash;
    }

    public String getSize() {
        return size;
    }


    public Long getClothingItem() {
        return clothingItem;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SizeQuantityId other = (SizeQuantityId) obj;
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.clothingItem, other.clothingItem)) {
            return false;
        }
        return true;
    }

  
    
}
