package com.dictionary.service.impl;

import com.dictionary.reposiitory.IDictionaryRepository;
import com.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    IDictionaryRepository dictionaryRepository;
    @Override
    public String translate(String english) {
        return dictionaryRepository.translate(english);
    }
}
