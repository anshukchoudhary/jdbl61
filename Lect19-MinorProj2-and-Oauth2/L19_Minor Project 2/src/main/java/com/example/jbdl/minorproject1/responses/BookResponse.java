package com.example.jbdl.minorproject1.responses;

import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.models.Genre;
import com.example.jbdl.minorproject1.models.Student;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private int id;
    private String name;
    private Genre genre;

    private Student student;

    public static BookResponse to(Book book){
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .genre(book.getGenre())
                .student(book.getStudent())
                .build();
    }
}
