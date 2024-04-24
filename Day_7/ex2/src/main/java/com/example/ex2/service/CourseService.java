package com.example.ex2.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex2.model.Course;
import com.example.ex2.repository.CourseRepo;

@Service

public class CourseService {

    @Autowired 
    private CourseRepo courseRepo;
    
    public Course post(Course course)
    {
        return courseRepo.save(course);
    }

    public List<Course> getAll()
    {
        return courseRepo.findAll();
    }

    public List<Course> getbyAge(String courseName)
    {
        return courseRepo.findByCourseName(courseName);
    }
}
