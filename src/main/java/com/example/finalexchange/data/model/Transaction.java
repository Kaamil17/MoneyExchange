package com.example.finalexchange.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String sourceCurrency;
    private String targetCurrency;
    private double sourceAmount;
    private double exchangedAmount;

    private double rate;
    private String transactionId;
    private LocalDateTime localDateTime;
}
