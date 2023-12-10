package com.digital.library.project.librarymanagesys2dec.services;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.digital.library.project.librarymanagesys2dec.models.Book;
import com.digital.library.project.librarymanagesys2dec.models.Student;
import com.digital.library.project.librarymanagesys2dec.models.Transaction;
import com.digital.library.project.librarymanagesys2dec.models.TransactionStatus;
import com.digital.library.project.librarymanagesys2dec.models.TransactionType;
import com.digital.library.project.librarymanagesys2dec.repos.TransactionRepository;

@Service
public class TransactionService {
	

//	student.book.limit=2
//  book.return.days=7
//	book.fine.day=1
//			
			
	@Value("${student.book.limit}")
	int studentBookLimit;
	
	@Value("${book.return.days}")
	int bookReturnDays;
	
	@Value("${book.fine.day}")
	int finePerDay;
	
	
	
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	BookService bookService;
	
	
	
	//1st method - issue book
	//1. find the book is present or available or not 
	//2. student is present or not 
	//3. Student book limit or max book to be issued 
	//4. create a txn with pending status
	//5. Make the book unvailable and assign it to a student 
	//6. Update the txn was successfull and respond the msg
	
	
	
	public String issueBook(int bookId, int studentId) throws Exception {
		
		Student student = studentService.getStudentById(studentId);
		
		// to check the student 
		if(student == null) {
			throw new Exception("Student is not present, unable to issue the book");
			
		}
		
		//to check the limit
		if(student.getBookList().size()>=studentBookLimit) {
			throw new Exception("Student has reached their limit , unable to issue the book");
		}
		
		
		Book book = bookService.getBookById(bookId);
		//if book exist 
		if(book == null) {
			throw new Exception("book is not present in the system, unable to issue the book");
			
		}
		
		if(book.getStudent()!=null) {
			
			throw new Exception("book is already issued to someone else , unable to issue the book");
			
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
		bookService.createBook(book);//it should update exisitng book as well 
		
		transaction.setTransactionStatus(TransactionStatus.SUCCESS);
		
		transactionRepository.save(transaction);
		}catch (Exception e) {
			book.setStudent(null);
			bookService.createBook(book);

			transaction.setTransactionStatus(TransactionStatus.FAILED);
			transactionRepository.save(transaction);
			
		}
		
		
		return transaction.getTransactionId() + "Issue method";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	//2nd method - return book
	 // check both book and studen is present 
	//1. to check whether the book is assigned to the student or not ?
	//2. check the return date and calculate the fine if any then update txn 
	//3. create a txn with pending status
	//4. Make the book available and or make the student id to null
	//5. send succcesss msg 
	
	public String returnBook(int bookId, int studentId) throws Exception {
		
		Student student = studentService.getStudentById(studentId);
		Book book = bookService.getBookById(bookId);
		
		
		if(student == null || book == null || 
				book.getStudent() == null || 
				book.getStudent().getStudentId() != studentId ) {
			throw new Exception("Book or student is either  not present or book is not assigned to the student , Unable to return the book ");
		}
		
		//to claucalte the fine u need to find the issue date 
		//transaction u will have to find the book issue details
		
		//Q. find the lastest  transaction with student book and  trasnaction status should be TRANSCTION TYPE ISSUE
		
	List<Transaction> issuedTxns = transactionRepository.findByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.ISSUE);
	
		Transaction issueTnx = issuedTxns.get(0);
		
		long issueTimeInMs = issueTnx.getUpdatedOn().getTime();
		long currentTimeInMs = System.currentTimeMillis();
		
		long timeDiff = currentTimeInMs - issueTimeInMs;
		
		long diffInDays = TimeUnit.DAYS.convert(timeDiff,TimeUnit.MILLISECONDS);
		
		
		int fine = 0;
		if(diffInDays > bookReturnDays) {
			fine = (int) ((diffInDays - bookReturnDays) * finePerDay);
			
		}
		
		Transaction transaction = Transaction.builder()
				  .book(book)
				  .student(student)
				  .fine(fine)
				  .transactionType(TransactionType.RETURN)
				  .transactionStatus(TransactionStatus.PENDING)
				  .transactionId(UUID.randomUUID().toString())
				  .build();
				  
				 
		transactionRepository.save(transaction);
		
		
		
		try {
			book.setStudent(null);
			bookService.createBook(book);

			transaction.setTransactionStatus(TransactionStatus.SUCCESS);
			transactionRepository.save(transaction);
		
		}catch (Exception e) {
		
			
			
			book.setStudent(student);
			bookService.createBook(book);//it should update exisitng book as well 
			
			transaction.setTransactionStatus(TransactionStatus.FAILED);
			
			transactionRepository.save(transaction);
			
		}
		
		
		
		
		
		
		
		
		
		return transaction.getTransactionId();
		
	}
	
	
	
	
	
	
	

}
