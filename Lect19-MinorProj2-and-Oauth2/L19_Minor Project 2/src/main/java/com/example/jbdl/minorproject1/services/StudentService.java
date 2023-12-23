package com.example.jbdl.minorproject1.services;

import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.repositories.StudentRepository;
import com.example.jbdl.minorproject1.security.User;
import com.example.jbdl.minorproject1.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Value("${user.authority.student}")
    private String studentAuthority;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void createStudent(Student student){

        User user = student.getUser();
        user.setAuthority(studentAuthority);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userService.createUser(user);

        studentRepository.save(student);
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);

        // select ref.id, ref.name, ... ref.bookList from student where id = 1;
        // select ref2.id, ref2.name, ref2.student where studentid = 1;

    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}
