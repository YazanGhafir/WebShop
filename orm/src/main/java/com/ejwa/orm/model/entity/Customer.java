
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


    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cusomer_id;
    
    @NonNull private String email;
    @NonNull private String password;
    @NonNull private String shippingAdress;
    @NonNull private String homeAdress;
    @NonNull private String lastName;
    @NonNull private String firstName;
    
    @OneToOne (mappedBy = "customer") private CustomerOrder customerOrder;
}
