package com.example.finalexchange.service.impl;

import com.example.finalexchange.client.ExchangeRateFeignClient;
import com.example.finalexchange.client.response.ExchangeRate;
import com.example.finalexchange.client.response.ExchangeRateResponse;
import com.example.finalexchange.controller.response.TransactionResponse;
import com.example.finalexchange.data.model.Transaction;
import com.example.finalexchange.data.repository.RateApiRepository;
import com.example.finalexchange.service.RateApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateApiServiceImpl implements RateApiService {
    private final ExchangeRateFeignClient exchangeRateFeignClient;
    private final RateApiRepository rateApiRepository;

    @Override
    public ExchangeRateResponse getExchangeRates(String base, String target) {
        return exchangeRateFeignClient.getExchangeRates(base, target);
    }

    public void save(Transaction transaction) {
        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setSourceCurrency(new ExchangeRateResponse().getBase());
        rateApiRepository.save(transaction);
        log.info("saving new transaction");
    }

    public List<Transaction> findAll() {
        log.info("Fetching all transactions");
        return rateApiRepository.findAll();
    }


    public Transaction findOne(int id) {
        log.info("Searching transaction id {}", id);
        return rateApiRepository.findById(id).orElse(null);
    }

}
