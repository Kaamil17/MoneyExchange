package com.example.finalexchange.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExchangeRateResponse {
    private String base;

    @JsonProperty("exchange_rates")
    private Object exchangeRate;
}
