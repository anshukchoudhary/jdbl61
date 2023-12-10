package com.digital.library.project.librarymanagesys2dec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.library.project.librarymanagesys2dec.services.TransactionService;

@RestController
public class TransactionControllers {
	
	
	
	@Autowired
	TransactionService transactionService;

	@PostMapping("/transaction/issue")
	public String issueBook(@RequestParam("bookId") int bookId, @RequestParam("studentId") int studentId) throws Exception {
	
		
		return transactionService.issueBook(bookId, studentId);
		
	}
	
	
	
	@PostMapping("/transaction/return")
	public String returnBook(@RequestParam("bookId") int bookId, @RequestParam("studentId") int studentId) throws Exception {
		
		return transactionService.returnBook(bookId, studentId);
	}
	
	
}
