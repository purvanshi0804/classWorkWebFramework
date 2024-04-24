package com.example.ex3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex3.model.Language;
import com.example.ex3.service.LanguageService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class LanguageController {
    
    @Autowired
    private LanguageService languageService;

    @GetMapping("/language")
    public ResponseEntity<List<Language>> getMethodName() {

        List<Language> obj = languageService.getLanguages();

        if(obj!=null)
            return ResponseEntity.status(HttpStatus.OK).body(obj);
        else    
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/language/{id}")
    public ResponseEntity<Language> getMethodName(@PathVariable("id") int id) {

        Language obj = languageService.getLanguageById(id);

        if(obj!=null)
              return ResponseEntity.status(HttpStatus.OK).body(obj);
        else    
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/language")
    public ResponseEntity<Language> postMethodName(@RequestBody Language entity) {
        Language obj = languageService.saveLanguage(entity);

        if(obj != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(obj);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/language/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable int id, @RequestBody Language updatedLanguage) {
        Language existingLanguage = languageService.getLanguageById(id);
        if (existingLanguage != null) {
           existingLanguage.setLanguageId(updatedLanguage.getLanguageId());
           existingLanguage.setLanguageName(updatedLanguage.getLanguageName());
           existingLanguage.setLanguageComplexity(updatedLanguage.getLanguageComplexity());
    
            languageService.saveLanguage(existingLanguage);
            
            return ResponseEntity.status(HttpStatus.OK).body(existingLanguage);
        } 
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    @DeleteMapping("/language/{id}")
    public ResponseEntity<Boolean> deleteLanguage(@PathVariable int id) {
        Language existingLanguage = languageService.getLanguageById(id);
        if (existingLanguage != null) {
            languageService.deleteLanguage(id);
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
    
    
}
