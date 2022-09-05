package com.example.finalexchange.controller;

import com.example.finalexchange.client.response.ExchangeRateResponse;
import com.example.finalexchange.controller.response.TransactionResponse;
import com.example.finalexchange.data.model.Transaction;
import com.example.finalexchange.mapper.ExchangeRateMapper;
import com.example.finalexchange.service.RateApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
class RateApiController {
    private final RateApiService rateApiService;
    private final ExchangeRateMapper exchangeRateMapper;

    @GetMapping("/exchange-rates/{id}")
    TransactionResponse findOne(@PathVariable("id") int id) {
        return exchangeRateMapper.transactionToTransactionResponse(rateApiService.findOne(id));
    }

    @GetMapping("/fullList")
    List<TransactionResponse> findAll() {
        return exchangeRateMapper.transactionToTransactionResponses(rateApiService.findAll());
    }

    @GetMapping(path = "/exchange-rates")
    ExchangeRateResponse getExchangeRates(@RequestParam String base, @RequestParam String target) {
        log.info("Request received base: {} target: {}", base, target);
        ExchangeRateResponse exchangeRateResponse = rateApiService.getExchangeRates(base, target);
        log.info("Response: {}", exchangeRateResponse);
        return exchangeRateResponse;
    }



    public void save(TransactionResponse transactionResponse) {
        log.info("Saving: {}", transactionResponse);
        Transaction transaction = exchangeRateMapper.dtoToModel(transactionResponse);
        rateApiService.save(transaction);
    }
}
