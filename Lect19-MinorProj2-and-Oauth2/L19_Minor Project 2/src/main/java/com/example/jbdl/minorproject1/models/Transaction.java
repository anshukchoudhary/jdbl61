package com.example.jbdl.minorproject1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String transactionId;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"transactionList", "bookList"})
    private Student student;

    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    private Integer fine;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties(value = {"transactionList", "student"})
    private Book book;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

}
