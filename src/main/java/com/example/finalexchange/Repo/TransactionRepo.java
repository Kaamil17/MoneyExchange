package com.example.finalexchange.Repo;

import com.example.finalexchange.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
}
