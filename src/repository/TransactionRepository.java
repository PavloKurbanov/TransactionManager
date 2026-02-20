package repository;

import entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository {
    void saveTransaction(Transaction transaction);

    List<Transaction> getDateTransactions(LocalDate date);

    Transaction getTransaction(String name);

    List<Transaction> getAll();
}
