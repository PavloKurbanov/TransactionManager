package repository;

import entity.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepositoryImpl implements TransactionRepository{
    private final Map<String, Transaction> transactions;

    public TransactionRepositoryImpl(){
        this.transactions = new HashMap<>();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactions.put(transaction.getName(), transaction);
    }

    @Override
    public List<Transaction> getDateTransactions(LocalDate date) {
        List<Transaction> getAllTransactionDate = new ArrayList<>();

        for (Transaction transaction : transactions.values()) {
            if(transaction.getDate().equals(date)){
                getAllTransactionDate.add(transaction);
            }
        }

        return getAllTransactionDate;
    }

    @Override
    public Transaction getTransaction(String name) {
        return transactions.get(name);
    }

    @Override
    public List<Transaction> getAll() {
        return new ArrayList<>(transactions.values());
    }
}
