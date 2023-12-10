package com.digital.library.project.librarymanagesys2dec.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.library.project.librarymanagesys2dec.models.Book;
import com.digital.library.project.librarymanagesys2dec.models.Student;
import com.digital.library.project.librarymanagesys2dec.models.Transaction;
import com.digital.library.project.librarymanagesys2dec.models.TransactionType;

public interface TransactionRepository extends  JpaRepository<Transaction, Integer>{
	
	//Transaction findByTransactionId(int id);
	
	//List<Transaction>  findByStudent(Student student);
	
//	List<Transaction> findByStudentAndBook(Student student, Book book);
	
//	List<Transaction>  findByStudentOrderById(Student student);// order by on trasnction id primary key
	
	
	//		//Q. find the lastest  transaction with student book and  trasnaction status should be TRANSCTION TYPE ISSUE
	
	
	
	List<Transaction> findByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student, Book book, TransactionType transactionType);
	
	
	

}
