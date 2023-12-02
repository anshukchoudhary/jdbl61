package com.digital.library.project.librarymanagesys2dec.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Book {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;

	//@ManyToOne
	private Author myAuthor;

	// @Enumerated(value = EnumType.ORDINAL)// VALUE WILL BE STORED AS NUMBER

	@Enumerated(value = EnumType.STRING) // VALUE WILL BE STORED AS STRING
	private Genre genre;

	// onetoone
	// onetomany
	// manytoone
	// manytomany

	//@ManyToOne
	private Student student;

	//@OneToMany
	private List<Transaction> transaction;
	
	
	@CreationTimestamp
	private Date createdOn;
	
	
	@UpdateTimestamp
	private Date updatedOn;
	
	
	

}
