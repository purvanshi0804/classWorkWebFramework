package com.example.class_ex_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.class_ex_4.model.Address;

@RequestMapping
public class ClassEx4Controller {
    @GetMapping("/address")
    public Address getinfo(@RequestParam String add){
        Address address = new Address(123,"Main St");
        return address;
        
    }
}
