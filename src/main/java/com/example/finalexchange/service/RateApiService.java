package com.example.finalexchange.service;

import com.example.finalexchange.client.response.ExchangeRateResponse;
import com.example.finalexchange.data.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RateApiService {
    ExchangeRateResponse getExchangeRates(String base, String target);

    void save(Transaction transaction);

    List<Transaction> findAll();

    Transaction findOne(int id);
}
