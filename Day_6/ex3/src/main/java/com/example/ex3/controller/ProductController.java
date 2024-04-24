package com.example.ex3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex3.model.Product;
import com.example.ex3.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

     @PostMapping("/api/product")
    public ResponseEntity<Product> postMethodName(@RequestBody Product product) {
        if(product!=null)
        {
            productService.postProduct(product);
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/product/{offset}/{pagesize}")
    public ResponseEntity<List<Product>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<Product> list = productService.pagination(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Product>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<Product> list = productService.sortPagination(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/product/{productId}")
    public ResponseEntity<Product> getMethodName(@PathVariable("productId") int id) {
        Product product = productService.getProductById(id);
        if(product==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    
}
