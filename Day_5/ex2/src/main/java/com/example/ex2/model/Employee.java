package main.java.com.example.ex2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee
{
    @Id
    private int employeeId;
    private String employeeName;
    private String employeeEmail;
    private double salary;
    private int department;
}

