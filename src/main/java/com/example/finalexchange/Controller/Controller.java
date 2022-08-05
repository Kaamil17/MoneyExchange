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

    // this functions gives the all datas at once.
  @GetMapping(path = "/transactions")
    public List<Transaction> getTransactionsData() {
        return fetchRepo.findAll();
    }

    // this functions gives the datas according to the id of the transaction.
    @GetMapping(path = "/transaction/{id}")
    public Optional<Transaction> getTransactionsDataById(@PathVariable int id) {
        return fetchRepo.findById(id);
    }

}
