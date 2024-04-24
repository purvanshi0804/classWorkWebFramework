package com.example.ex3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ex3.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

    
}