package main.java.com.example.ex2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) {
        Employee existingEmployee = employeeService.getEmployee(id);
        if (existingEmployee != null) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.OK).body(true);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        if(employee!=null)
        {
            employeeService.saveEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);
        }
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateDetails(@PathVariable  int id, @RequestBody Employee updatedEmployee) 
    {
        Employee existingEmployee = employeeService.getEmployee(id);
        if (existingEmployee != null) {
            existingEmployee.setEmployeeId(updatedEmployee.getEmployeeId());
            existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
            existingEmployee.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());

            employeeService.saveEmployee(existingEmployee);

            return ResponseEntity.status(HttpStatus.OK).body(existingEmployee);
        } 
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
