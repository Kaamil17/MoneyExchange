package com.example.finalexchange.controller;

import com.example.finalexchange.model.Transaction;
import com.example.finalexchange.repo.FetchRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ControllerTest {

    @Autowired
    FetchRepo fetchRepo;

    @Test
    void getTransactionsDataByIdTest() {
        Controller controller = new Controller(fetchRepo);
        Optional<Transaction> response = controller.getTransactionsDataById(40);
        assertEquals(
                "USD", response.get().getSourceCurrency());
        assertEquals(
                "717.9382499999999", String.valueOf(response.get().getExchangedAmount()));
        assertEquals(
                "0.957251", String.valueOf(response.get().getRate()));
        assertEquals(
                "CHF", String.valueOf(response.get().getTargetCurrency()));
        assertEquals(
                "750.0", String.valueOf(response.get().getSourceAmount()));
        assertEquals(
                "2022-08-09T12:12:28.338136", String.valueOf(response.get().getLocalDateTime()));
    }
}