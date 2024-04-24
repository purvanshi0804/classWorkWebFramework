package com.example.cw2.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.example.cw2.model.Employee;
 
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
 
    
}
