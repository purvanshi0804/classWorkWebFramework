package com.example.ex1.controller;

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

import com.example.ex1.model.Product;
import com.example.ex1.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id) 
    {
    Product existingProduct = productService.getProduct(id);
    if (existingProduct != null) 
    {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body(existingProduct);
    } 
    else
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}

@PostMapping("/product")
public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
    if(product!=null)
    {
        productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    else
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
}

@PutMapping("/product/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable  int id, @RequestBody Product updatedProduct) 
{
    Product existingProduct = productService.getProduct(id);
    if (existingProduct != null) {
        existingProduct.setProductId(updatedProduct.getProductId());
        existingProduct.setProductName(updatedProduct.getProductName());
        existingProduct.setProductDescription(updatedProduct.getProductDescription());

        productService.saveProduct(existingProduct);

        return ResponseEntity.status(HttpStatus.OK).body(existingProduct);
    } 
    else
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

}
