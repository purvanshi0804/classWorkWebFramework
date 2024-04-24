package com.example.ex2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private int courseId;
    private String courseName;
    private int creditHours;
    private String instructor;
    private String preRequistics;
    private int maxCapacity;
    private String enrolledstudents;
}
