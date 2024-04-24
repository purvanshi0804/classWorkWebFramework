package com.example.ex1.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex1.model.Children;
import com.example.ex1.service.ChildrenService;

@RestController
@RequestMapping("/api")
public class ChildrenController {
    
    @Autowired
    private ChildrenService childrenService;

    @PostMapping("/children")
    public ResponseEntity<Children> addChildren(@RequestBody Children children){
        if(children!=null)
        {
            childrenService.saveChildren(children);
            return ResponseEntity.status(HttpStatus.CREATED).body(children);
        }
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

     @GetMapping("/children/sortBy/{field}")
    public ResponseEntity<List<Children>> getMethodName(@PathVariable("field") String field) {
        List<Children> list = childrenService.getSortedChildrens(field);
        if(list.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    
    @GetMapping("/children/{offset}/{pagesize}")
    public ResponseEntity<List<Children>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<Children> list = childrenService.getPaginationChildrens(offset,size);
        if(list.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    
    @GetMapping("/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<Children> list = childrenService.getSortedPaginationChildrens(offset,size,field);
        if(list.size() == 0)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }


}
