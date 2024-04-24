package com.example.ex1.model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@jakarta.persistence.Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product 
{
    @jakarta.persistence.Id
    private int productId;
    private String productName;
    private String productDescription;
}
