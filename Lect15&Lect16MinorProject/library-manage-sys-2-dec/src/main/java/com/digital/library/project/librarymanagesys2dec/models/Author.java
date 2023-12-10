package com.digital.library.project.librarymanagesys2dec.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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



}
