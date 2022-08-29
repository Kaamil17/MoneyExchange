package com.example.finalexchange.controller;

import com.example.finalexchange.client.response.ExchangeRateResponse;
import com.example.finalexchange.service.RateApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// name of .com
// https://plugins.jetbrains.com/plugin/7973-sonarlint
// sonarint
// spring AOP
// https://www.baeldung.com/spring-tutorial
// controller rename. get specific
//https://www.baeldung.com/mapstruct

//https://www.baeldung.com/entity-to-and-from-dto-for-a-java-spring-application


//https://www.baeldung.com/spring-boot-clean-architecture
@RestController
@RequiredArgsConstructor
@Slf4j
class RateApiController {

    // rename fetchRepo
    // check the names of methods and class
    // change it to service
    private final RateApiService rateApiService;

    // this functions gives the data according to the id of the transaction. i checked it using postman.
//    @GetMapping(path = "/transaction/{id}")
//    Optional<Transaction> getTransactionsDataById(@PathVariable int id) {
//        return rateApiService.findById(id);
//    }


    @GetMapping(path = "/exchange-rates")
    ExchangeRateResponse getExchangeRates(@RequestParam String base, @RequestParam String target) {
        log.info("Request received base: {} target: {}", base, target);
        ExchangeRateResponse exchangeRateResponse = rateApiService.getExchangeRates(base, target);
        log.info("Response: {}", exchangeRateResponse);
        return exchangeRateResponse;
    }


}
