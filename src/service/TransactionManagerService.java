package service;

import entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionManagerService {
    void createTransaction(String name, String wallet, String category, double amount);

    List<Transaction> getAllTransaction();

    List<Transaction> getAllTimeTransaction(LocalDate localDate);
}
