package com.example.finalexchange.repo;

import com.example.finalexchange.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
}
