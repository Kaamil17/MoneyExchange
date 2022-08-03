package com.example.finalexchange;

import com.example.finalexchange.Model.Transaction;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class FinalExchangeApplication implements CommandLineRunner {

    @Autowired
    com.example.finalexchange.Repo.TransactionRepo transactionRepo;

    public static void main(String[] args) throws JSONException {
        SpringApplication.run(FinalExchangeApplication.class, args);

        com.example.finalexchange.Api.RateApi myApi = new com.example.finalexchange.Api.RateApi();

      //  System.out.println(myApi.conversionTotalFinder(100, "USD", "RUB"));
    }

    @Override
    public void run(String... args) throws Exception {
        com.example.finalexchange.Api.RateApi myApi = new com.example.finalexchange.Api.RateApi();
        Transaction firstTransaction = new Transaction();


        // i could use constructor, but i set the values one by one for checking matters.
        firstTransaction.setSourceCurrency("USD");
        firstTransaction.setTargetCurrency("RUB");
        firstTransaction.setSourceAmount(1000);
        firstTransaction.setTransactionId(UUID.randomUUID());
        firstTransaction.setRate(myApi.rateFinder(firstTransaction.getSourceCurrency(), firstTransaction.getTargetCurrency()));
     //   firstTransaction.setExchangedAmount(Double.parseDouble(myApi.conversionTotalFinder(firstTransaction.getSourceAmount(),firstTransaction.getSourceCurrency(), firstTransaction.getTargetCurrency()).get("Amount")));

        transactionRepo.save(firstTransaction);
    }
}