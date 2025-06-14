package com.diegobrito.desafio.itau.repositories;

import com.diegobrito.desafio.itau.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepositorie  extends JpaRepository<Transaction, String> {
}
