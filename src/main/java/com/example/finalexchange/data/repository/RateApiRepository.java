package com.example.finalexchange.data.repository;

import com.example.finalexchange.data.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateApiRepository extends JpaRepository<Transaction, Integer> {
}
