package com.example.cw1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.cw1.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    
}



