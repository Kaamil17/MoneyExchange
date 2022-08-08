package com.example.finalexchange.repo;

import com.example.finalexchange.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


//
public interface FetchRepo extends JpaRepository<Transaction, Integer>{

    @Override
    List<Transaction> findAll();

    @Override
    Optional<Transaction> findById(Integer integer);

}
