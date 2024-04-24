package com.example.ex1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex1.model.Product;
import com.example.ex1.repository.ProductRepo;

@Service
public class ProductService 
{
    @Autowired
    private ProductRepo productRepo;    
    
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(int id) {
        return productRepo.findById(id).orElse(null);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}
