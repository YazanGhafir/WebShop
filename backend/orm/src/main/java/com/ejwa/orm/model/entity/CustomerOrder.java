package com.ejwa.orm.model.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    private LocalDateTime date;

    @OneToOne(mappedBy = "customerOrder")
    private Payment payment;

    @JoinColumn(name = "customer_id")
    @OneToOne
    private Customer customer;

    @JoinTable(name = "customerOrder_product",
    joinColumns = @JoinColumn(name = "customerOrder_id_"),
    inverseJoinColumns = @JoinColumn(name = "product_id_"))
    @ManyToMany private List<Product> productList;
    
}