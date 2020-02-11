package com.ejwa.orm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Product implements Serializable {

    @Id private Long id;
    @NonNull private String name;
    @NonNull private double price;
    private String discription;

       
}
