package com.example.jbdl.minorproject1.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.requests.BookCreateRequest;
import com.example.jbdl.minorproject1.responses.BookResponse;
import com.example.jbdl.minorproject1.responses.BookWithoutStudentResponse;
import com.example.jbdl.minorproject1.services.BookService;

@RestController
public class BookController {

    // post, put, delete --> ADMIN
    // get --> STUDENT, ADMIN


    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        bookService.createBook(bookCreateRequest.to());
    }

    @GetMapping("/book/all")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }


    @GetMapping("/bookByStudent1")
    public List<BookResponse> getBooksByStudent1(@RequestParam("name") String name) {
        return bookService.getBookByStudentName(name);
    }

    @GetMapping("/bookByStudent2")
    public List<BookWithoutStudentResponse> getBooks(@RequestParam("name") String name) {
        return bookService.getBookByStudentNameWithoutStudent(name);
    }


//    public List<Book> getBooks(@RequestParam("filterkeys") String filterKeys,
//                               @RequestParam("filterValues") String filterValues){
//
//        // FilterKeys -   BOOK_NAME,      AUTHOR_NAME, COST
//        // Filtervalues - Intro to Maths,  Will,   1000
//        // FilterRegex -     =,               s%,        <=
//        //
//    }
}
