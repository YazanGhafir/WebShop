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

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customer_id;

    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String shippingAdress;
    @NonNull
    private String homeAdress;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;


    @OneToOne(mappedBy = "customer")
    private CustomerOrder customerOrder;

    public Customer(String email, String password){
        this.email = email; this.password = password;
    }
}
