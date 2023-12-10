package com.digital.library.project.librarymanagesys2dec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digital.library.project.librarymanagesys2dec.CreateRequest.StudentCreateRequest;
import com.digital.library.project.librarymanagesys2dec.models.Student;
import com.digital.library.project.librarymanagesys2dec.services.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentControllers {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.createStudent(studentCreateRequest.to());
    }

    @GetMapping("/student/all")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
//
//    @GetMapping("/student/{studentId}")
//    public Student getStudent(@PathVariable("studentId") int studentId){
//        return studentService.getStudentById(studentId);
//    }
}
