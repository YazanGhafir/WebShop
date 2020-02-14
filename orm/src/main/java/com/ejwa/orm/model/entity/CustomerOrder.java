package com.ejwa.orm.model.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerorder_id;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne(mappedBy = "customerOrder")
    private Payment payment;

    @JoinColumn(name = "customer_id")
    @OneToOne
    private Customer customer;

    @OneToMany(mappedBy = "customerOrder")
    private List<Product> productList;

}
