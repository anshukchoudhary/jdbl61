package com.digital.library.project.librarymanagesys2dec.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.library.project.librarymanagesys2dec.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
