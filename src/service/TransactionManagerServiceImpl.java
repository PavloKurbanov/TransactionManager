package service;

import entity.Category;
import entity.Transaction;
import entity.Wallet;
import repository.CategoryRepository;
import repository.TransactionRepository;
import repository.WalletRepository;
import repository.WalletRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class TransactionManagerServiceImpl implements TransactionManagerService {
    private final CategoryRepository categoryRepository;
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public TransactionManagerServiceImpl(CategoryRepository categoryRepository, WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.categoryRepository = categoryRepository;
        this.transactionRepository = transactionRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    public void createTransaction(String name, String walletName, String categoryName, double amount) {

        Wallet wallet = walletRepository.getWallet(walletName);
        if (wallet == null) {
            throw new IllegalArgumentException("Не має такого гаманця");
        }

        Category category = categoryRepository.getCategory(categoryName);
        if (category == null) {
            throw new IllegalArgumentException("Не має такої категорії");
        }

        wallet.withdraw(amount);

        walletRepository.saveWallet(wallet);

        Transaction transaction = new Transaction(name, walletName, categoryName, amount);

        transactionRepository.saveTransaction(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.getAll();
    }

    @Override
    public List<Transaction> getAllTimeTransaction(LocalDate localDate) {
        return transactionRepository.getDateTransactions(localDate);
    }
}
