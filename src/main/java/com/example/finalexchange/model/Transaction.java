package com.example.finalexchange.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

//
@Entity
@RequiredArgsConstructor
public @Data class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String sourceCurrency;
    String targetCurrency;
    double sourceAmount;
    double exchangedAmount;

    double rate;
    String transactionId;
    LocalDateTime localDateTime;
}
