package com.example.finalexchange.Controller;
import com.example.finalexchange.Model.Transaction;
import com.example.finalexchange.Repo.FetchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class Controller {

    @Autowired
    FetchRepo fetchRepo;

    // this functions gives the all data at once. checked by postman. works fine!
  @GetMapping(path = "/transactions")
    public List<Transaction> getTransactionsData() {
        return fetchRepo.findAll();
    }

    // this functions gives the data according to the id of the transaction. i checked it using postman.
    @GetMapping(path = "/transaction/{id}")
    public Optional<Transaction> getTransactionsDataById(@PathVariable int id) {
        return fetchRepo.findById(id);
    }

}
