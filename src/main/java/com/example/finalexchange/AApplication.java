package com.example.finalexchange;
import com.example.finalexchange.model.Transaction;
import com.example.finalexchange.repo.TransactionRepo;
import com.example.finalexchange.service.ApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDateTime;
import java.util.HashMap;

@EnableFeignClients
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
        ApiService apiService = new ApiService();
        Transaction transaction = new Transaction();


        // i could use constructor, but I set the values one by one for checking matters.
        // you can write your own currency abbreviations here.
        transaction.setSourceCurrency("");
        transaction.setTargetCurrency("TRY");
        transaction.setSourceAmount(10);

        datas = myApi.exchanger(transaction.getSourceCurrency(), transaction.getSourceAmount(),
                transaction.getTargetCurrency());

        transaction.setTransactionId(apiService.idGenerator());
        transaction.setRate(Double.parseDouble((datas.get("rate"))));

        transaction.setExchangedAmount(Double.parseDouble(datas.get("exchangedAmount")));
        transaction.setLocalDateTime(LocalDateTime.parse(datas.get("dateTime")));

        transactionRepo.save(transaction);
    }
}