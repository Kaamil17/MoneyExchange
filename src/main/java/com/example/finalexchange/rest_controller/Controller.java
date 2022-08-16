package com.example.finalexchange.rest_controller;

import com.example.finalexchange.model.Transaction;
import com.example.finalexchange.persistence.FetchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
class Controller {
    private final FetchRepo fetchRepo;

    // this functions gives the all data at once. checked by postman. works fine!
    @GetMapping(path = "/transactions")
     List<Transaction> getTransactionsData() {
        return fetchRepo.findAll();
    }

    // this functions gives the data according to the id of the transaction. i checked it using postman.
    @GetMapping(path = "/transaction/{id}")
     Optional<Transaction> getTransactionsDataById(@PathVariable int id) {
        return fetchRepo.findById(id);
    }

}
