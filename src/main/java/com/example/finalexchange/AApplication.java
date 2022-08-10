package com.example.finalexchange;

import com.example.finalexchange.extraneous.MyMethods;
import com.example.finalexchange.model.Transaction;
import com.example.finalexchange.repo.TransactionRepo;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.HashMap;
/*
 TODO: CHANGE FIRST LETTER OF PACKAGE NAMES -> DONE!
 TODO: USE LOMBOK INSTEAD OF SET/GET/CONSTRUCTOR -> DONE!
 TODO: READ THE FILES
 TODO: CHANGE THE HARD CODED API URL AND USE CLOUD FEIGN INSTEAD
 TODO: THROW THE RIGHT EXCEPTION INSTEAD OF PRINTSTPACE.-> DONE
*/


@SpringBootApplication
public class AApplication implements CommandLineRunner {

    final TransactionRepo transactionRepo;

    public AApplication(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(AApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        HashMap<String, String> datas;
        com.example.finalexchange.myapi.RateApi myApi = new com.example.finalexchange.myapi.RateApi();
        MyMethods myMethods = new MyMethods();
        Transaction transaction = new Transaction();


        // i could use constructor, but I set the values one by one for checking matters.
        // you can write your own currency abbreviations here.
        transaction.setSourceCurrency("USD");
        transaction.setTargetCurrency("TRY");
        transaction.setSourceAmount(100);

        datas = myApi.exchanger(transaction.getSourceCurrency(), transaction.getSourceAmount(),
                transaction.getTargetCurrency());

        transaction.setTransactionId(myMethods.idGenerator());
        transaction.setRate(Double.parseDouble((datas.get("rate"))));

        transaction.setExchangedAmount(Double.parseDouble(datas.get("exchangedAmount")));
        transaction.setLocalDateTime(LocalDateTime.parse(datas.get("dateTime")));

        transactionRepo.save(transaction);
    }
}