package com.ejwa.orm.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomerOrder implements Serializable {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerorder_id;
    
    @NonNull private String date;
    
    @OneToOne (mappedBy = "customerOrder") private Payment payment; 
    
    @JoinColumn(name="customer_id")
    @OneToOne private Customer customer;
    
    @OneToMany(mappedBy = "customerOrder") private List<Product> productList;
    
}
