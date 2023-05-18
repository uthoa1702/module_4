package com.change_currency.service.impl;

import com.change_currency.service.IConvertService;
import org.springframework.stereotype.Service;

@Service

public class ConvertService implements IConvertService {
    @Override
    public int usdToVnd(int usd, int vnd) {
        return usd*vnd;
    }
}
