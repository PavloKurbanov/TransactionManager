package repository.impl;

import entity.Transaction;
import entity.TransactionType;
import repository.TransactionRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepositoryImpl implements TransactionRepository {
    private final List<Transaction> transactions;
    private int transactionId = 1;

    public TransactionRepositoryImpl() {
        this.transactions = new ArrayList<>();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transaction.setId(transactionId++);
        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getDateTransactions(LocalDate date) {
        List<Transaction> getAllTransactionDate = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getDate().equals(date)) {
                getAllTransactionDate.add(transaction);
            }
        }

        return getAllTransactionDate;
    }

    @Override
    public List<Transaction> getTransactionByType(TransactionType transactionType) {
        List<Transaction> getAllTransactionType = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if(transaction.getType().equals(transactionType)) {
                getAllTransactionType.add(transaction);
            }
        }
        return getAllTransactionType;
    }

    @Override
    public Transaction getTransaction(int id) {
        for (Transaction transaction : transactions) {
            if(transaction.getId() == id) {
                return transaction;
            }
        }
        throw new IllegalArgumentException("Не має транзакції з ID: " + id);
    }

    @Override
    public List<Transaction> getAll() {
        return new ArrayList<>(transactions);
    }
}
