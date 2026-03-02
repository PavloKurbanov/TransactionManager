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

public class MainMenuBuilder {
    private final WalletService walletService;
    private final CategoryService  categoryService;
    private final TransactionService transactionService;
    private final InputReader inputReader;

    public MainMenuBuilder(TransactionService transactionService, InputReader inputReader, CategoryService categoryService, WalletService walletService) {
        this.inputReader = inputReader;
        this.transactionService = transactionService;
        this.categoryService = categoryService;
        this.walletService = walletService;
    }

    public Map<String, Command> build(){
        Map<String, Command> transaction = new HashMap<>();

        Command addTransaction = new AddTransactionCommand(transactionService, inputReader);
        Command addWallet = new AddWalletCommand(walletService, inputReader);
        Command addCategory = new AddCategoryCommand(categoryService, inputReader);
        Command showMenu = new OpenReportsMenuCommand(transactionService,walletService,categoryService,inputReader);

        transaction.put(addTransaction.choice(), addTransaction);
        transaction.put(addWallet.choice(), addWallet);
        transaction.put(addCategory.choice(), addCategory);
        transaction.put(showMenu.choice(), showMenu);

        return transaction;
    }
}
