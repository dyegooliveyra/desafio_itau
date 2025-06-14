package com.diegobrito.desafio.itau.controllers;

import com.diegobrito.desafio.itau.dto.StatisticsResponseDTO;
import com.diegobrito.desafio.itau.dto.TransactionRequestDTO;
import com.diegobrito.desafio.itau.entities.Transaction;
import com.diegobrito.desafio.itau.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequestDTO transaction) {
        if(transaction.getMoment().isAfter(OffsetDateTime.now()) || transaction.getAmount() <= 0) return ResponseEntity.unprocessableEntity().build();
        transactionService.createTransaction(new Transaction(transaction.getAmount(), transaction.getMoment()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearAllTransactions() {
        transactionService.clearAllTransactions();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponseDTO> getStatistics() {
        DoubleSummaryStatistics statistics = transactionService.getStatistics();
        return ResponseEntity.ok().body(new StatisticsResponseDTO(statistics));
    }
}
