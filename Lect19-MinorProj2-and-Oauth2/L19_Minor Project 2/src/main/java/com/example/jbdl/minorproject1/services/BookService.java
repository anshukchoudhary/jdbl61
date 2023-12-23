package com.example.jbdl.minorproject1.services;

import com.example.jbdl.minorproject1.models.Author;
import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.models.Genre;
import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.repositories.BookRepository;
import com.example.jbdl.minorproject1.repositories.StudentRepository;
import com.example.jbdl.minorproject1.responses.BookResponse;
import com.example.jbdl.minorproject1.responses.BookWithoutStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    public void createBook(Book book){
        //TODO: We need to write the logic for author insertion

        Author author = authorService.createOrGetAuthor(book.getMyAuthor());
        book.setMyAuthor(author);
        bookRepository.save(book);
    }

//    public Book getBookById(int id){
//        return bookRepository.findById(id).orElse(null);
//    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getBookByName(String name){
        return bookRepository.findByName(name);
    }

    public List<Book> getBookById(int id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return Arrays.asList(bookOptional.get());
        }

        return new ArrayList<>();
    }

    public List<Book> getBookByAuthorName(String name){
        return bookRepository.findByMyAuthorName(name);
    }

    public List<Book> getBookByGenre(Genre genre){
        return bookRepository.findByGenre(genre);
    }

    public List<BookResponse> getBookByStudentName(String name){
        List<Book> bookList = Arrays.asList(bookRepository.findByStudentName(name));

        return bookList.stream()
                .map(BookResponse::to)
                .collect(Collectors.toList());
    }

    public List<BookWithoutStudentResponse> getBookByStudentNameWithoutStudent(String name){
       List<Book> bookList = Arrays.asList(bookRepository.findByStudentName(name));
        return bookList.stream()
                .map(BookWithoutStudentResponse::to)
                .collect(Collectors.toList());
    }
}

/**
 * Complete the book and author flow
 * Create transactions --> Issue and Return
 * Custom queries --> Filtered get books API
 */
