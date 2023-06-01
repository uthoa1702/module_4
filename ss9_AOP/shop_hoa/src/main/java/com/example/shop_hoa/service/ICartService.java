package com.example.shop_hoa.service;

import com.example.shop_hoa.model.Flower;

import java.util.Map;

public interface ICartService {
    boolean checkExist(Flower flower, Map<Flower, Integer> flowerList);

    Map.Entry<Flower, Integer> flowerIntegerEntry(Flower flower, Map<Flower, Integer> flowerList);

    double getTotal(Map<Flower, Integer> list);
}
