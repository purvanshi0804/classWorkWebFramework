package com.example.cw1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cw1.model.Product;
import com.example.cw1.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }
    public Product getProductById(int productId) {
        return productRepo.findById(productId).orElse(null);
     }
     public void delete(int id) {
        productRepo.deleteById(id);
     }
}
