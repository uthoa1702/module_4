package com.example.calculator.service.impl;

import com.example.calculator.service.ICalculatorService;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public int add(Integer num1, Integer num2) {
        return num1 + num2;
    }

    @Override
    public int sub(Integer num1, Integer num2) {
        return num1 - num2;
    }

    @Override
    public int div(Integer num1, Integer num2) {
        return num1 / num2;
    }

    @Override
    public int mul(Integer num1, Integer num2) {
        return num1 * num2;
    }
}
