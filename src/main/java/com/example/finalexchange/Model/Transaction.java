package com.example.finalexchange.Model;


import com.example.finalexchange.Extraneous.MyMethods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transaction {

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

    public Transaction( int id, double rate, String sourceCurrency, String targetCurrency, double sourceAmount, double exchangedAmount,
                       String transactionId, LocalDateTime localDateTime) {
        this.id = id;
        this.rate = rate;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.sourceAmount = sourceAmount;
        this.exchangedAmount = exchangedAmount;
        this.transactionId = transactionId;
        this.localDateTime = localDateTime;

    }

    public int getId() {
        return id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Transaction() {
    }


    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }



    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getSourceAmount() {
        return sourceAmount;
    }

    public void setSourceAmount(double sourceAmount) {
        this.sourceAmount = sourceAmount;
    }

    public double getExchangedAmount() {
        return exchangedAmount;
    }

    public void setExchangedAmount(double exchangedAmount) {
        this.exchangedAmount = exchangedAmount;
    }

    public String getTransactionId() {
      //  transactionId = UUID.fromString(UUID.randomUUID().toString().replace("-","").substring(0,8));
        return transactionId;
    }

    public void setTransactionId(String transactionId) {

        MyMethods myMethods = new MyMethods();
        transactionId = myMethods.idGenerator();
        this.transactionId = transactionId;
    }
}
