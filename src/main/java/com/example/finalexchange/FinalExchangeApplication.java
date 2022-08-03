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
import java.util.UUID;

@SpringBootApplication
public class FinalExchangeApplication implements CommandLineRunner {

    @Autowired
    TransactionRepo transactionRepo;

    public static void main(String[] args) throws JSONException {
        SpringApplication.run(FinalExchangeApplication.class, args);

      //  com.example.finalexchange.Api.RateApi myApi = new com.example.finalexchange.Api.RateApi();

    }

    @Override
    public void run(String... args) throws Exception {
        HashMap<String, String> datas = new HashMap<>();
        com.example.finalexchange.Api.RateApi myApi = new com.example.finalexchange.Api.RateApi();
        MyMethods myMethods = new MyMethods();
        Transaction transaction = new Transaction();




        // i could use constructor, but I set the values one by one for checking matters.
        transaction.setSourceCurrency("GBP");
        transaction.setTargetCurrency("TRY");
        transaction.setSourceAmount(1000);

        datas = myApi.exchanger(transaction.getSourceCurrency(), transaction.getSourceAmount(),
                transaction.getTargetCurrency());

        transaction.setTransactionId(myMethods.idGenerator());
        transaction.setRate(Double.parseDouble((datas.get("rate"))));

        transaction.setExchangedAmount(Double.parseDouble(datas.get("exchangedAmount")));
        transaction.setLocalDateTime(LocalDateTime.parse(datas.get("dateTime")));






        transactionRepo.save(transaction);
    }
}