package com.ingredient_of_sandwich.service.impl;

import com.ingredient_of_sandwich.model.Sandwich;
import com.ingredient_of_sandwich.repository.ISandwichRepository;
import com.ingredient_of_sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SandwichService implements ISandwichService {
    @Autowired
    ISandwichRepository sandwichRepository;
    @Override
    public void save(Sandwich sandwich) {
        sandwichRepository.save(sandwich);
    }
}
