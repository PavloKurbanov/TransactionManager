package ui.menu;

import ui.command.AddCategoryCommand;
import ui.command.AddTransactionCommand;
import ui.command.AddWalletCommand;
import ui.command.Command;
import ui.io.InputReader;
import service.CategoryService;
import service.TransactionService;
import service.WalletService;
import ui.command.OpenReportsMenuCommand;

import java.util.HashMap;
import java.util.Map;

public record MainMenuBuilder(TransactionService transactionService, InputReader inputReader,
                              CategoryService categoryService, WalletService walletService) {

    public Map<String, Command> build() {
        Map<String, Command> transaction = new HashMap<>();

        Command addTransaction = new AddTransactionCommand(transactionService, inputReader, walletService, categoryService);
        Command addWallet = new AddWalletCommand(walletService, inputReader);
        Command addCategory = new AddCategoryCommand(categoryService, inputReader);
        Command showMenu = new OpenReportsMenuCommand(transactionService, walletService, categoryService, inputReader);

        transaction.put(addTransaction.choice(), addTransaction);
        transaction.put(addWallet.choice(), addWallet);
        transaction.put(addCategory.choice(), addCategory);
        transaction.put(showMenu.choice(), showMenu);

        return transaction;
    }
}
