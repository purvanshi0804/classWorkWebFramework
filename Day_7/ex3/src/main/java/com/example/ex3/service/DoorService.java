package com.example.ex3.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex3.model.Door;
import com.example.ex3.repository.DoorRepo;



@Service
public class DoorService {
    @Autowired
    private DoorRepo doorRepo;

    public Door post(Door door)
    {
        return doorRepo.save(door);
    }

    public List<Door> getAll()
    {
        return doorRepo.findAll();
    }

    public List<Door> getbyDoorId(int doorId)
    {
        return doorRepo.findByDoorId(doorId);
    }
    public List<Door> getbyType(String type)
    {
        return doorRepo.findByAccessType(type);
    }
    
}
