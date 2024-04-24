package com.example.cw3.service;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.example.cw3.model.Language;
import com.example.cw3.repository.LanguageRepo;
 
@Service
public class LanguageService {
    @Autowired
    private LanguageRepo languageRepo;
 
    public Language createLanguage(Language Language) {
        return languageRepo.save(Language);
    }
    public List<Language> getAllLanguages() {
        return (List<Language>) languageRepo.findAll();
    }
    public Language getLanguageById(int LanguageId) {
        return languageRepo.findById(LanguageId).orElse(null);
    }
    public void deleteLanguagebyId(int langId){
        languageRepo.deleteById(langId);
    }
}

