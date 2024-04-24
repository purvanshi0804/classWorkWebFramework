package com.example.cw2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cw2.model.Employee;
import com.example.cw2.repository.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo EmployeeRepo;
    public Employee createEmployee(Employee Employee) {
        return EmployeeRepo.save(Employee);
    }
    public Employee getEmployeeByid(int EmployeeId) {
        return EmployeeRepo.findById(EmployeeId).orElse(null);
     }
     public void deleteEmployee(int id) {
        EmployeeRepo.deleteById(id);
     }
}
