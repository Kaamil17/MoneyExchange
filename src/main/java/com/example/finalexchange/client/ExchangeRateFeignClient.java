package com.example.finalexchange.client;

import com.example.finalexchange.client.response.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "exchange-rate", url = "${myapi.url}")
public interface ExchangeRateFeignClient {

    @GetMapping()
    ExchangeRateResponse getExchangeRates(@RequestParam String base,
                                          @RequestParam String target);

}
