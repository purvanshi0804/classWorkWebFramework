package com.example.ex1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex1.model.Person;
import com.example.ex1.repository.PersonRepo;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepo personRepo;
    
    public Person post(Person person)
    {
            return personRepo.save(person);
    }

    public List<Person> getAll()
    {
        return personRepo.findAll();
    }

    public List<Person> getbyAge(int age)
    {
        return personRepo.findByAge(age);
    }

}
