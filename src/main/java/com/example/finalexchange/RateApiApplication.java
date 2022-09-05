package com.example.finalexchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
@Slf4j
public class RateApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(RateApiApplication.class, args);
        log.info("Rate Api Application Running!");
    }

}