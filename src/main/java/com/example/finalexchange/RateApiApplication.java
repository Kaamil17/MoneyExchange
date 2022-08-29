package com.example.finalexchange;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class RateApiApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RateApiApplication.class, args);
    }

    @Override
    public void run(String... args) {
//        transactionRepo.save(transaction);
    }
}