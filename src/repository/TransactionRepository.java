package repository;

import entity.Transaction;
import entity.TransactionType;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository {
    void saveTransaction(Transaction transaction);

    List<Transaction> getDateTransactions(LocalDate date);

    List<Transaction> getTransactionByType(TransactionType transactionType);

    Transaction getTransaction(int id);

    List<Transaction> getAll();
}
