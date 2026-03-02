package service.impl;

import util.DateFormatter;
import entity.Category;
import entity.Transaction;
import entity.Wallet;
import repository.CategoryRepository;
import repository.TransactionRepository;
import repository.WalletRepository;
import service.TransactionService;

import java.time.LocalDate;
import java.util.List;

public record TransactionServiceImpl(CategoryRepository categoryRepository, WalletRepository walletRepository,
                                     TransactionRepository transactionRepository) implements TransactionService {

    @Override
    public void createTransaction(String name, String walletName, String categoryName, double amount) {

        Wallet wallet = walletRepository.getById(walletName);
        if (wallet == null) {
            throw new IllegalArgumentException("Не має такого гаманця");
        }

        Category category = categoryRepository.getCategory(categoryName);
        if (category == null) {
            throw new IllegalArgumentException("Не має такої категорії");
        }
        wallet.withdraw(amount);
        walletRepository.save(wallet);

        Transaction transaction = new Transaction(0, name, walletName, categoryName, amount);

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
            throw new IllegalArgumentException("Не має транзакцій за " + DateFormatter.format(localDate));
        }
        return dateTransactions;
    }
}
