package com.example.ex1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex1.model.Person;
import com.example.ex1.service.PersonService;

@RestController
public class PersonController 
{

    @Autowired
    private PersonService personService;

     @PostMapping("/api/person")
    public ResponseEntity<Person> post(@RequestBody Person person)
    {
        if(person!=null)
        {
            personService.post(person);
            return new ResponseEntity<>(person,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/person")
    public ResponseEntity<List<Person>> getAll()
    {
        List<Person> li = personService.getAll();
        if(li.size()>0)
        {
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/person/byAge")
    public ResponseEntity<List<Person>> getbyAge(@RequestParam int age)
    {
        List<Person> li = personService.getbyAge(age);
        if(li.size()>0)
        {
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
