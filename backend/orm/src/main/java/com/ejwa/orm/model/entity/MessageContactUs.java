package com.ejwa.orm.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MessageContactUs implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long message_id;
    
    @NonNull private String name;
    @NonNull private String email;
    @NonNull private String subject;
    @NonNull private String message;

}
