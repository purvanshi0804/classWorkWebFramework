package com.example.cw2.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.cw2.model.Employee;
import com.example.cw2.service.EmployeeService;
 
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
 
    @PostMapping("/api/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.createEmployee(employee);
        if (emp != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(emp);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/api/employee/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int id,@RequestBody Employee employee){
        Employee emp = employeeService.getEmployeeByid(id);
        if(emp!=null){
            emp.setDepartment(employee.getDepartment());
            emp.setEmployeeEmail(employee.getEmployeeEmail());
            emp.setEmployeeName(employee.getEmployeeName());
            emp.setSalary(employee.getSalary());
            return emp;
        }
        else{
            return null;
        }
    }
    @DeleteMapping("/api/employee/{employeeId}")
    public boolean DeleteMapping(@PathVariable("employeeId") int id){
        Employee emp = employeeService.getEmployeeByid(id);
        if(emp!=null){
            employeeService.deleteEmployee(id);
            return true;   
        }
        else  
            return false;
    }
}
 

