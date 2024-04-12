package com.example.class_ex_5.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.class_ex_5.model.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ClassEx5Controller {

    @GetMapping("/students")
    public List<Student> getMethodName()
    {
     List<Student>st=new ArrayList<>();
     st.add(new Student("John","Welcome, John!"));
     return st;
    }
    
    
}
