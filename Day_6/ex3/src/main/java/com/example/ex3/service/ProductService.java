package com.example.ex3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ex3.model.Product;
import com.example.ex3.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product postProduct(Product product)
    {
            return productRepo.save(product);
    }
    public List<Product> pagination(int offset,int size)
    {
        return productRepo.findAll(PageRequest.of(offset, size)).getContent();
    }
    public List<Product> sortPagination(int offset,int size,String field)
    {
        productRepo.findAll( Sort.by(""));
        return productRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }
    public Product getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
    
}
