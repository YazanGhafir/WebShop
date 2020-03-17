/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejwa.orm.model.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 *
 * @author madel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeQuantityId implements Serializable{
    private String size;
    private long clothingItem;   
}
