package com.example.finalexchange;

import com.example.finalexchange.Extraneous.MyMethods;
import com.example.finalexchange.Model.Transaction;
import com.example.finalexchange.Repo.TransactionRepo;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootApplication
public class AApplication implements CommandLineRunner {

    @Autowired
    TransactionRepo transactionRepo;

    public static void main(String[] args) throws JSONException {
        SpringApplication.run(AApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        HashMap<String, String> datas = new HashMap<>();
        com.example.finalexchange.MyApi.RateApi myApi = new com.example.finalexchange.MyApi.RateApi();
        MyMethods myMethods = new MyMethods();
        Transaction transaction = new Transaction();


        // i could use constructor, but I set the values one by one for checking matters.
        transaction.setSourceCurrency("USD");
        transaction.setTargetCurrency("JPY");
        transaction.setSourceAmount(500);

        datas = myApi.exchanger(transaction.getSourceCurrency(), transaction.getSourceAmount(),
                transaction.getTargetCurrency());

        transaction.setTransactionId(myMethods.idGenerator());
        transaction.setRate(Double.parseDouble((datas.get("rate"))));

        transaction.setExchangedAmount(Double.parseDouble(datas.get("exchangedAmount")));
        transaction.setLocalDateTime(LocalDateTime.parse(datas.get("dateTime")));

        transactionRepo.save(transaction);

    }
}