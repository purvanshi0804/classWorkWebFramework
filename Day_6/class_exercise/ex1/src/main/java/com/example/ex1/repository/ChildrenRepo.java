package com.example.ex1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex1.model.Children;

public interface ChildrenRepo extends JpaRepository<Children,Integer>
{

    
} 
