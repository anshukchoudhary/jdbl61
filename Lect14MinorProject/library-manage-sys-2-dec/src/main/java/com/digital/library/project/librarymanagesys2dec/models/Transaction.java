package com.digital.library.project.librarymanagesys2dec.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	@ManyToOne
	private Student student;

	private Integer fine;

	private TransactionType transactionType;

	private TranscationStatus transcationStatus;

	@ManyToOne
	private Book book;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;

}
