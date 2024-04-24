package main.java.com.example.ex2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Employee;
import com.example.springapp.repository.EmployeeRepo;

@Service
public class EmployeeService 
{
    @Autowired
    private EmployeeRepo employeeRepo;    
    
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployee(int id) {
        return employeeRepo.findById(id).orElse(null);
    }

    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }
}
