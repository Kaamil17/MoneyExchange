package com.example.finalexchange.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExchangeRate {

    @JsonProperty("EUR")
    private Double euro;

    @JsonProperty("TRY")
    private Double turkishLira;
}
