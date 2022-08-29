package com.example.finalexchange.client;

import com.example.finalexchange.client.response.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "exchange-rate", url = "${myapi.url}")
public interface ExchangeRateFeignClient {

    @RequestMapping(method = RequestMethod.GET)
    ExchangeRateResponse getExchangeRates(@RequestParam String base,
                                          @RequestParam String target);

}
