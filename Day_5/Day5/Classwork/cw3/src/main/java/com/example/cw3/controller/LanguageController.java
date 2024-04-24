package com.example.cw3.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.cw3.model.Language;
import com.example.cw3.service.LanguageService;
 
@RestController
public class LanguageController{
    @Autowired
    private LanguageService languageService;
    @PostMapping("/language")
    public ResponseEntity<Language> createLanguage(@RequestBody Language language) {
        Language createdLanguage = languageService.createLanguage(language);
        if(createdLanguage != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLanguage);
        else    
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
        @GetMapping("/language")
        public List<Language> getAllLanguages() {
            List<Language> Languages = languageService.getAllLanguages();
            return Languages;
        }
        @GetMapping("/language/{languageId}")
        public Language getLanguageById(@PathVariable("languageId") int id) {
            Language Language = languageService.getLanguageById(id);
            return Language;
        }
        @PutMapping("/language/{languageId}")
        public Language updateLanguage(@PathVariable("languageId") int id, @RequestBody Language lang){
            Language ex = languageService.getLanguageById(id);
            if(ex != null){
                ex.setLanguageName(lang.getLanguageName());
                ex.setLanguageComplexity(lang.getLanguageComplexity());
                // languageService.createLanguage(ex);
            }
            return ex;
        }

        @DeleteMapping("/language/{languageId}")
        public boolean deleteLanguagebyId(@PathVariable("languageId") int id){
            languageService.deleteLanguagebyId(id);
            return true;
        }
}
