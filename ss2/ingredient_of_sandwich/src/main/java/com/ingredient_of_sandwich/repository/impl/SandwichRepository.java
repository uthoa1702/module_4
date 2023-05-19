package com.ingredient_of_sandwich.repository.impl;

import com.ingredient_of_sandwich.model.Sandwich;
import com.ingredient_of_sandwich.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class SandwichRepository implements ISandwichRepository {
    private static List<Sandwich> sandwichList = new ArrayList<>();

    @Override
    public void save(Sandwich sandwich) {
        sandwichList.add(sandwich);
    }
}
