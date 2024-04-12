package com.example.class_ex_1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController

public class ClassEx1Controller {

    @GetMapping("/hello")
    public String getMethodName() {
        return new String("hello");
    }
    
    
}
