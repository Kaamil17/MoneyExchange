package com.example.finalexchange.service.impl;

import com.example.finalexchange.client.ExchangeRateFeignClient;
import com.example.finalexchange.client.response.ExchangeRateResponse;
import com.example.finalexchange.data.model.Transaction;
import com.example.finalexchange.data.repository.RateApiRepository;
import com.example.finalexchange.service.RateApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RateApiServiceImpl implements RateApiService {

    private final RateApiRepository rateApiRepository;
    private final ExchangeRateFeignClient exchangeRateFeignClient;

    @Override
    public List<Transaction> findAll() {
        return rateApiRepository.findAll();
    }

    @Override
    public ExchangeRateResponse getExchangeRates(String base, String target) {
        return exchangeRateFeignClient.getExchangeRates(base, target);
    }
}
