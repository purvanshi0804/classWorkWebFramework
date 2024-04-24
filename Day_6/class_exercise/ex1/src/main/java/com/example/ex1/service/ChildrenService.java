package com.example.ex1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.example.ex1.model.Children;
import com.example.ex1.repository.ChildrenRepo;

@Service
public class ChildrenService {
    
    @Autowired
    private ChildrenRepo childrenRepo;

    public Children saveChildren(Children children){
        return childrenRepo.save(children);
    }

    public List<Children> getSortedChildrens(String field)
    {
        return childrenRepo.findAll(Sort.by(field));
    }
    public List<Children> getPaginationChildrens(int offset,int size)
    {
        return childrenRepo.findAll(PageRequest.of(offset, size)).getContent();                        
    }
    public List<Children> getSortedPaginationChildrens(int offset,int size,String field)
    {
        return childrenRepo.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }



}
