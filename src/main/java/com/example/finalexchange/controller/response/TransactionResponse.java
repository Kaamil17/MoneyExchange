package com.example.finalexchange.controller.response;

import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {

    @Id
    private int id;
    private String sourceCurrency;
    private String targetCurrency;
    private double sourceAmount;
    private double exchangedAmount;

    private double rate;
    private String transactionId;
    private LocalDateTime localDateTime;
}
