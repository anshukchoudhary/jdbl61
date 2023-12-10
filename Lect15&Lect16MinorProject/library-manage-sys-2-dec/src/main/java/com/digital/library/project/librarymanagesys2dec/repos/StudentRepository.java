package com.digital.library.project.librarymanagesys2dec.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digital.library.project.librarymanagesys2dec.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
