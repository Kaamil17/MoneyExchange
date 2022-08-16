package com.example.finalexchange.rest_controller;

import com.example.finalexchange.model.Transaction;
import com.example.finalexchange.persistence.FetchRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



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