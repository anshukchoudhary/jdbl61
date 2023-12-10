package com.digital.library.project.librarymanagesys2dec.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.library.project.librarymanagesys2dec.models.Author;
import com.digital.library.project.librarymanagesys2dec.repos.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    // This function will be responsible to return an author with given email
    // if it already or else it will create a new author
    public Author createOrGetAuthor(Author author){

        Author authorFromDB = authorRepository.findAuthor(author.getEmail());

        if(authorFromDB == null){
            authorFromDB = authorRepository.save(author);
        }

        return authorFromDB;
    }
}
