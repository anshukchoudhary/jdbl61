package com.example.jbdl.minorproject1.controllers;

import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.requests.StudentCreateRequest;
import com.example.jbdl.minorproject1.security.User;
import com.example.jbdl.minorproject1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // Permit all
    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.createStudent(studentCreateRequest.to());
    }

    // Admin
    @GetMapping("/student/all")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    // Admin
    @GetMapping("/studentById/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId){
        return studentService.getStudentById(studentId);
    }

    // Student
    @GetMapping("/student")
    public Student getStudent(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer studentId = user.getStudent().getStudentId();
        return studentService.getStudentById(studentId);
    }




}
