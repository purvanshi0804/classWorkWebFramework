package com.example.cw1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cw1.model.Product;
import com.example.cw1.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService pro;
    @PostMapping("/product") 
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdproduct = pro.createProduct(product);
        if (createdproduct != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdproduct);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @PutMapping("/product/{productId}")
    public Product getvalue(@PathVariable("productId") int id, @RequestBody Product p) {
        Product product = pro.getProductById(id);
        if(product != null) {
            product.setProductId(p.getProductId());
            product.setProductName(p.getProductName());
            product.setProductDescription(p.getProductDescription());
        }
        return product;
    }
    @DeleteMapping("/product/{productId}")
public boolean deleteProductById(@PathVariable("productId") int id) {
    Product product = pro.getProductById(id);
    if (product != null) {
        pro.delete(id);
        return true;
    }
    else {
        return false;
    }
}
    
}

