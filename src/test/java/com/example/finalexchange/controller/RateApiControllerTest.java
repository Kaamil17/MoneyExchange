package com.example.finalexchange.controller;

import com.example.finalexchange.data.model.Transaction;
import com.example.finalexchange.data.repository.RateApiRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RateApiControllerTest {

//    @Autowired
//    RateApiRepository rateApiRepository;
//    @Test
//    void getTransactionsDataByIdTest() {
//        RateApiController rateApiController = new RateApiController(rateApiRepository);
//        Optional<Transaction> response = rateApiController.getTransactionsDataById(40);
//        assertEquals(
//                "USD", response.get().getSourceCurrency());
//        assertEquals(
//                "717.9382499999999", String.valueOf(response.get().getExchangedAmount()));
//        assertEquals(
//                "0.957251", String.valueOf(response.get().getRate()));
//        assertEquals(
//                "CHF", String.valueOf(response.get().getTargetCurrency()));
//        assertEquals(
//                "750.0", String.valueOf(response.get().getSourceAmount()));
//        assertEquals(
//                "2022-08-09T12:12:28.338136", String.valueOf(response.get().getLocalDateTime()));
//    }
}