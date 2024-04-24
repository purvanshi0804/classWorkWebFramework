package com.example.ex3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex3.model.Language;
import com.example.ex3.repository.LanguageRepo;

@Service
public class LanguageService 
{
    @Autowired
    private LanguageRepo languageRepo;
    
    public Language saveLanguage(Language language)
    {
            return languageRepo.save(language);
    }
    public List<Language> getLanguages()
    {
        return languageRepo.findAll();
    }
    public void deleteLanguage(int id)
    {
        languageRepo.deleteById(id);   
    }
    public Language getLanguageById(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }
}
