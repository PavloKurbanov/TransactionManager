package ui.command;

import entity.Category;
import entity.TransactionType;
import entity.Wallet;
import service.CategoryService;
import service.WalletService;
import ui.io.InputReader;
import service.TransactionService;
import util.ConsolePrinter;

import java.util.List;

public class AddTransactionCommand implements Command {
    private final InputReader inputReader;
    private final TransactionService transactionService;
    private final WalletService walletService;
    private final CategoryService categoryService;

    public AddTransactionCommand(TransactionService transactionService, InputReader inputReader, WalletService walletService, CategoryService categoryService) {
        this.inputReader = inputReader;
        this.transactionService = transactionService;
        this.categoryService = categoryService;
        this.walletService = walletService;
    }

    @Override
    public String choice() {
        return "3";
    }

    @Override
    public void process() {
        try {
            List<Wallet> wallets = walletService.getWallets();
            List<Category> allCategories = categoryService.getAllCategories();

            if (ConsolePrinter.printList(wallets, "Щоб створити транзакцію, створіть гаманець!")) {
                return;
            }

            if (ConsolePrinter.printList(allCategories, "Щоб створити транзакцію, створіть категорію!")) {
                return;
            }

            String transactionName = inputReader.readString("Введіть назву витрати: ");

            ConsolePrinter.extracted(wallets, "----- ГАМАНЦІ -----");
            String wallet = inputReader.readString("Введіть назву гаманця: ");

            ConsolePrinter.extracted(allCategories, "----- КАТЕГОРІЇ -----");
            String category = inputReader.readString("Введіть назву категорії: ");

            Double amount = inputReader.readDouble("Введіть суму витрати: ");

            TransactionType transactionType = inputReader.readTransactionType();
            transactionService.createTransaction(transactionName, wallet, category, amount, transactionType);

            System.out.println("Витрату " + transactionName + " успішно додано!");

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
