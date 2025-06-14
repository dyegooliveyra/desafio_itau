package com.diegobrito.desafio.itau.services;

import com.diegobrito.desafio.itau.entities.Transaction;
import com.diegobrito.desafio.itau.repositories.TransactionRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepositorie transactionRepositorie;

    public Transaction createTransaction(Transaction transaction) {
        Transaction transactionSaved = transactionRepositorie.save(transaction);
        return transactionSaved;
    }

    public void clearAllTransactions() {
        transactionRepositorie.deleteAll();
    }

    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        List<Transaction> transactions = transactionRepositorie.findAll();

       return transactions.stream()
               .filter((t) -> t.getMoment().isAfter(now.minusSeconds(60)))
               .mapToDouble(Transaction::getAmount)
               .summaryStatistics();
    }
}
