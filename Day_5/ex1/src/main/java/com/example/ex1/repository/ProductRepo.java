package com.example.ex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ex1.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{
    
}
