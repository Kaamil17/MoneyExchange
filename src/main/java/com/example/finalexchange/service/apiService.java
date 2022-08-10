package com.example.finalexchange.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface apiService {

    HashMap<String, String> exchanger(String baseCurrency, double sourceAmount, String targetCurrency);
}
