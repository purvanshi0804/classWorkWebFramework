package com.example.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex2.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>{
    
}
