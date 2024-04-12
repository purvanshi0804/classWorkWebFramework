package com.example.class_ex_3.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ClassEx3Controller {
    @GetMapping("/color")
    public String getMethodName(@RequestParam String color) {
        
        return "My fav color is "+color+"!";
    }
    
}
