package service;

import entity.Transaction;
import entity.TransactionType;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    void createTransaction(String name, String wallet, String category, double amount, TransactionType transactionType);

    List<Transaction> getAllTransaction();

    List<Transaction> getAllTransactionByDate(LocalDate localDate);

    List<Transaction> getAllTransactionByType(TransactionType transactionType);
}
