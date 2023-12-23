package com.example.jbdl.minorproject1.repositories;

import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query("select b from Book b where b.myAuthor.name = ?1")
    List<Book> findByMyAuthorName(String authorName);

//    @Query("select b from Book b where b.name = :bookName")
    List<Book> findByName(String bookName);

//    @Query("select b from Book b where b.genre = :genre")
    List<Book> findByGenre(Genre genre);

    @Query("select b from Book b where b.student.name = ?1")
    Book findByStudentName(String name);
}


//JPQL WILL EXCUTE ON DB TABLE OR JAVA OBJECT ?
//JAVA OBJECT 
//NAVTIVE SQL - DB TABLES