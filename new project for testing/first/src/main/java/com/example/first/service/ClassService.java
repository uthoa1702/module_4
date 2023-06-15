package com.example.first.service;

import com.example.first.model.Class;
import com.example.first.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService implements IClassService{
    @Autowired private IClassRepository iClassRepository;
    @Override
    public List <Class> findAll() {
        return iClassRepository.findAll();
    }
}
