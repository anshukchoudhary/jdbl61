package com.digital.library.project.librarymanagesys2dec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.library.project.librarymanagesys2dec.models.Author;
import com.digital.library.project.librarymanagesys2dec.models.Book;
import com.digital.library.project.librarymanagesys2dec.repos.BookRepository;

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

    public Book getBookById(int id){
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

}

/**
 * Complete the book and author flow
 * Create transactions --> Issue and Return
 * Custom queries --> Filtered get books API
 */
