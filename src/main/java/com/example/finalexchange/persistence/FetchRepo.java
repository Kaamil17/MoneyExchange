package com.example.finalexchange.persistence;

import com.example.finalexchange.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//
@Repository
public interface FetchRepo extends JpaRepository<Transaction, Integer>{

    @Override
    List<Transaction> findAll();

    @Override
    Optional<Transaction> findById(Integer integer);

}
