package com.example.class_ex_2.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class ClassEx2Controller {
    
    @GetMapping("path")
    public String getMethodName(@RequestParam String name) {
        return ("My name is "+name+"!");
    }
        
}
