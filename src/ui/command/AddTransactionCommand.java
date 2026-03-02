package ui.command;

import entity.Category;
import entity.Wallet;
import service.CategoryService;
import service.WalletService;
import ui.io.InputReader;
import service.TransactionService;
import util.ConsolePrinter;

import java.util.List;

public record AddTransactionCommand(TransactionService transactionService, InputReader inputReader,
                                    WalletService walletService, CategoryService categoryService) implements Command {

    @Override
    public String choice() {
        return "3";
    }

    @Override
    public void process() {
        try {
            // 1. Дістаємо списки
            List<Wallet> wallets = walletService.getWallets();
            List<Category> categories = categoryService.getAllCategories();

            // 2. Одразу друкуємо і перевіряємо! (Fail Fast)
            if (ConsolePrinter.printList(wallets, "Спочатку створіть гаманець!")) {
                return;
            }
            if (ConsolePrinter.printList(categories, "Спочатку створіть категорію!")) {
                return;
            }

            // 3. Якщо ми дійшли сюди, значить і гаманці, і категорії надруковані на екран.
            // Можемо безпечно збирати дані.
            String transactionName = inputReader.readString("Введіть назву витрати: ");
            ConsolePrinter.showList(wallets, "----- ГАМАНЦІ -----");
            String wallet = inputReader.readString("Оберіть гаманець (введіть назву): ");
            ConsolePrinter.showList(categories, "----- КАТЕГОРІЇ -----");
            String category = inputReader.readString("Введіть назву категорії: ");
            Double amount = inputReader.readDouble("Введіть суму витрати: ");
            //TransactionType transactionType = inputReader.readTransactionType();

            transactionService.createTransaction(transactionName, wallet, category, amount);
            System.out.println("✅ Витрату '" + transactionName + "' успішно додано!");

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Помилка: " + e.getMessage());
        }
    }
}
