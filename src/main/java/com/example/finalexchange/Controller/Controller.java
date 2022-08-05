package com.example.finalexchange.Controller;
import com.example.finalexchange.Model.Transaction;
import com.example.finalexchange.Repo.FetchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    FetchRepo fetchRepo;

  @GetMapping(path = "/transactions")
    public List<Transaction> getTransactionsData() {
        return fetchRepo.findAll();

    }
}
