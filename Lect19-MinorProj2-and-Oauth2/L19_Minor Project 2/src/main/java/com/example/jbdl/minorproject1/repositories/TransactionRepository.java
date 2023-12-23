package com.example.jbdl.minorproject1.repositories;

import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.models.Transaction;
import com.example.jbdl.minorproject1.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findByBookAndStudentAndTransactionTypeOrderByIdDesc(
            Book book, Student student,
            TransactionType transactionType);

//    Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(int bookId, int studentId,
//                                                                       TransactionType transactionType);
}
