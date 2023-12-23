package com.example.jbdl.minorproject1.responses;

import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.models.Genre;
import com.example.jbdl.minorproject1.models.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookWithoutStudentResponse {
    private int id;
    private String name;
    private Genre genre;

//    @JsonIgnore
//    private Student student;

    public static BookWithoutStudentResponse to(Book book){
        return BookWithoutStudentResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .genre(book.getGenre())
//                .student(book.getStudent())
                .build();
    }
}
