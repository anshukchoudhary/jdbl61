package com.example.jbdl.minorproject1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Author {

    // Int / long
    // String
    // Boolean

    // a1 = [1, 4, 2, 80, 56, 43, 23, 60]
    // a2 = ["ABC", "DEF", "ABD", "PSQ", "ABE", "DED", "ADD", "PDQ"]
    // a3 = [true, false, true, false, true, false, ....]

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    // int indexing
    // String indexing

    @Column(length = 30) // varchar(30)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    // This is not going to be a column in the author table, it's just for java back reference
    @OneToMany(mappedBy = "myAuthor")
    @JsonIgnoreProperties(value = {"myAuthor", "createdOn", "updatedOn"})
    List<Book> bookList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;


    /**
     * FetchType.EAGER
            * Pros - 1. API performance will be better because the data is already loaded in the beginning
            * Cons - 1. Lead to memory issues, because data is pre-loaded
     * FetchType.LAZY
            * Pros - 1. Does not lead to memeory issues
            * Cons - 1. Since the data is loaded on demand / when Query is hit it can be a little time taking wrt API
     */
}
