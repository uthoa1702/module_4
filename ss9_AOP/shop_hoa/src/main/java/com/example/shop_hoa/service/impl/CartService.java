package com.example.shop_hoa.service.impl;

import com.example.shop_hoa.model.Flower;
import com.example.shop_hoa.repository.IFlowerRepository;
import com.example.shop_hoa.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService implements ICartService {
    @Autowired
    private IFlowerRepository iFlowerRepository;

    public boolean checkExist(Flower flower, Map<Flower, Integer> flowerIntegerMap) {
        for (Map.Entry<Flower, Integer> e :
                flowerIntegerMap.entrySet()) {
            if (e.getKey().getId().equals(flower.getId())) {
                return true;
            }
        }
        return false;
    }

    public Map.Entry<Flower, Integer> flowerIntegerEntry(Flower flower, Map<Flower, Integer> flowerIntegerMap) {
        for (Map.Entry<Flower, Integer> f : flowerIntegerMap.entrySet()) {
            if (f.getKey().getId().equals(flower.getId())) {
                return f;
            }
        }
        return null;
    }

    @Override
    public double getTotal(Map<Flower, Integer> list) {
        double sum = 0;
        for (Map.Entry<Flower, Integer> e :
                list.entrySet()) {
            sum = sum + e.getKey().getPrice() * e.getValue();
        }
        return sum;
    }
}
