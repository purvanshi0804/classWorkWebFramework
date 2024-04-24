package com.example.ex2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.ex2.model.Course;
import com.example.ex2.service.CourseService;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/api/course")
    public ResponseEntity<Course> post(@RequestBody Course course) {

        if (course!=null) {
            courseService.post(course);
            return new ResponseEntity<>(course, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/course")
    public ResponseEntity<List<Course>> getAll() {
        List<Course> li = courseService.getAll();
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/course/{courseName}")
    public ResponseEntity<List<Course>> getbyAge(@PathVariable String courseName) {
        List<Course> li = courseService.getbyAge(courseName);
        if (li.size() > 0) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
