package com.example.ex2.repository;
import com.example.ex2.model.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer>
{
    List<Course> findByCourseName(String courseName);
}
