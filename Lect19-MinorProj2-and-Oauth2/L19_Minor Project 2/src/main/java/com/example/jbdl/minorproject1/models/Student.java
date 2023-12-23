package com.example.jbdl.minorproject1.models;

import com.example.jbdl.minorproject1.security.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;
    private int age;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String phoneNumber;

    /* Remember it in this way, mapped is always the current class' reference
       attribute in the other class
     */
    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties(value = {"student", "transactionList"})
    private List<Book> bookList;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties(value = {"student", "book"})
    private List<Transaction> transactionList;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties("student")
    private User user;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    // All the books issued to student 1 --> GET Student info
}
