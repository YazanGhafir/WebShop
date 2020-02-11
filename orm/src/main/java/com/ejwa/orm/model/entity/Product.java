package com.ejwa.orm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;   
    
    @NonNull private String name;
    @NonNull private double price;
    private String discription;

    @JoinColumn(name="category_id")
    @ManyToOne private Category category;
       
}
