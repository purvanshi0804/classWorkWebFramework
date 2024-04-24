package com.example.ex3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@jakarta.persistence.Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @jakarta.persistence.Id
    private int productId;
    private String productName;
    private String category;
    private int price;
}

