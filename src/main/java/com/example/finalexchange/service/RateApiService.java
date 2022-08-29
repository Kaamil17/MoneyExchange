package com.example.finalexchange.service;

import com.example.finalexchange.client.response.ExchangeRateResponse;
import com.example.finalexchange.data.model.Transaction;
import java.util.List;


public interface RateApiService {

    List<Transaction> findAll();

    ExchangeRateResponse getExchangeRates(String base, String target);

}
