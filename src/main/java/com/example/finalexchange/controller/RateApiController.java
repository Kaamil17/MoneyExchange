package com.example.finalexchange.controller;

import com.example.finalexchange.client.response.ExchangeRateResponse;
import com.example.finalexchange.controller.response.TransactionResponse;
import com.example.finalexchange.mapper.ExchangeRateMapper;
import com.example.finalexchange.service.RateApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application
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
}
