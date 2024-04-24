package com.example.ex3.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex3.model.Door;

public interface DoorRepo extends JpaRepository<Door,Integer>{
    List<Door> findByDoorId(int id);
    List<Door>  findByAccessType(String a);
}
