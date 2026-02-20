package service.impl;

import util.DateFormatter;
import entity.Category;
import entity.Transaction;
import entity.TransactionType;
import entity.Wallet;
import repository.CategoryRepository;
import repository.TransactionRepository;
import repository.WalletRepository;
import service.TransactionService;

import java.time.LocalDate;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private final CategoryRepository categoryRepository;
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(CategoryRepository categoryRepository, WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    public void createTransaction(String name, String walletName, String categoryName, double amount, TransactionType transactionType) {

        Wallet wallet = walletRepository.getById(walletName);
        if (wallet == null) {
            throw new IllegalArgumentException("Не має такого гаманця");
        }

        Category category = categoryRepository.getCategory(categoryName);
        if (category == null) {
            throw new IllegalArgumentException("Не має такої категорії");
        }

        if(transactionType == TransactionType.EXPENSE){
            wallet.withdraw(amount);
        } else {
            wallet.deposit(amount);
        }

        walletRepository.save(wallet);

        Transaction transaction = new Transaction(0, name, walletName, categoryName, amount, transactionType);

        transactionRepository.saveTransaction(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.getAll();
    }

    @Override
    public List<Transaction> getAllTransactionByDate(LocalDate localDate) {
        List<Transaction> dateTransactions = transactionRepository.getDateTransactions(localDate);
        if (dateTransactions.isEmpty()) {
            throw new IllegalArgumentException("Не має транзакцій за " + localDate.format(DateFormatter.FORMATTED));
        }
        return dateTransactions;
    }

    @Override
    public List<Transaction> getAllTransactionByType(TransactionType transactionType) {
        List<Transaction> transactionByType = transactionRepository.getTransactionByType(transactionType);
        if (transactionByType.isEmpty()) {
            throw new IllegalArgumentException("Не має транзакцій за типом " + transactionType.getDescription());
        }
        return transactionByType;
    }
}
