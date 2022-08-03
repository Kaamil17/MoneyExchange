package com.example.finalexchange.Repo;

import com.example.finalexchange.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
}
