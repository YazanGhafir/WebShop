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
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author razan
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {


    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Id @NonNull private String email;
    @NonNull private String password;
    @NonNull private String shippingAdress;
    @NonNull private String homeAdress;
    @NonNull private String lastName;
    @NonNull private String firstName;
    
    @OneToOne
    private Order order;
}
