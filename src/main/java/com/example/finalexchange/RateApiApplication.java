package com.example.finalexchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
@Slf4j
public class RateApiApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(RateApiApplication.class, args);
        log.info("Rate Api Application Running!");
    }

    @Override
    public void run(String... args) {
//        transactionRepo.save(transaction);
    }
}