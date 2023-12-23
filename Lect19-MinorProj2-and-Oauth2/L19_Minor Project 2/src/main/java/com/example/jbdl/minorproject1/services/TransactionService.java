package com.example.jbdl.minorproject1.services;

import com.example.jbdl.minorproject1.models.*;
import com.example.jbdl.minorproject1.repositories.StudentRepository;
import com.example.jbdl.minorproject1.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Value("${student.book.quota}")
    int studentBookQuota;

    @Value("${book.return.days}")
    int bookReturnDays;

    @Value("${book.fine.day}")
    int finePerDay;

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(int studentId, int bookId) throws Exception {
        /**
         * 1. Student is present or not
         * 2. Book is present or not and book is available
         * 3. Student's quota has reached or not
         * 4. Create a txn with pending status
         * 5. Make the book unavailable and assign it to a student
         * 6. Update the txn as successful || complete the txn
         */

        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            throw new Exception("Student is not present, unable to issue the book");
        }

        if(student.getBookList().size() >= studentBookQuota){
            throw new Exception("Student has reached their quota, unable to issue the book");
        }

        Book book = bookService.getBookById(bookId).get(0);

        if(book.getStudent() != null){
            throw new Exception("Book is already issued to someone else, unable to issue the book");
        }

        Transaction transaction = Transaction.builder()
                .book(book)
                .student(student)
                .transactionType(TransactionType.ISSUE)
                .transactionStatus(TransactionStatus.PENDING)
                .transactionId(UUID.randomUUID().toString())
                .build();

        transactionRepository.save(transaction);

        try {
            book.setStudent(student);
            bookService.createBook(book); // This is going to update the existing book because bookId is not null

            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transactionRepository.save(transaction);
        }catch (Exception e){
            book.setStudent(null);
            bookService.createBook(book);

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
        }

        return transaction.getTransactionId();

    }

    public String returnBook(int studentId, int bookId) throws Exception {
        /**
         * 1. Check whether the book is assigned to the student or not ?
         * 2. Check the fine and update in the transaction
         * 3. Create a txn with pending status
         * 4. Make the book available || Remove the student as assignee
         * 5. Update the txn with success status
         */

        Student student = studentService.getStudentById(studentId);
        Book book = bookService.getBookById(bookId).get(0);

        if(student == null || book == null ||
                book.getStudent() == null ||
                book.getStudent().getStudentId() != studentId){
            throw new Exception("Book or student is either not present or book is not assigned " +
                    "to the student, unable to return the book");
        }

        List<Transaction> issueTxns = transactionRepository
                .findByBookAndStudentAndTransactionTypeOrderByIdDesc(
                        book, student, TransactionType.ISSUE);

        Transaction issueTxn = issueTxns.get(0);

        long issueTimeInMillis = issueTxn.getUpdatedOn().getTime();
        long currentTimeMillis = System.currentTimeMillis();

        long timeDiff = currentTimeMillis - issueTimeInMillis;
        long numberOfDaysPassed = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);

        int fine = 0;
        if(numberOfDaysPassed > bookReturnDays){
            fine = (int)(numberOfDaysPassed - bookReturnDays) * finePerDay;
        }

        Transaction transaction = Transaction.builder()
                .transactionId(UUID.randomUUID().toString())
                .transactionType(TransactionType.RETURN)
                .transactionStatus(TransactionStatus.PENDING)
                .student(student)
                .book(book)
                .fine(fine)
                .build();

        transactionRepository.save(transaction);

        try {
            book.setStudent(null);
            bookService.createBook(book);

            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transactionRepository.save(transaction);
        }catch (Exception e){
            book.setStudent(student);
            bookService.createBook(book);

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
        }

       return transaction.getTransactionId();
    }
}
