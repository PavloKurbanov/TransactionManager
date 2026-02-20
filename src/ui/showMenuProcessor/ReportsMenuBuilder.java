package ui.showMenuProcessor;

import ui.command.Command;
import ui.io.InputReader;
import service.CategoryService;
import service.TransactionService;
import service.WalletService;

import java.util.HashMap;
import java.util.Map;

public class ReportsMenuBuilder {
    private final InputReader inputReader;
    private final TransactionService  transactionService;
    private final CategoryService categoryService;
    private final WalletService walletService;

    public ReportsMenuBuilder(TransactionService transactionService, CategoryService categoryService, WalletService walletService, InputReader inputReader) {
        this.transactionService = transactionService;
        this.categoryService = categoryService;
        this.walletService = walletService;
        this.inputReader = inputReader;
    }

    public Map<String, Command> show(){
        Map<String, Command> map = new HashMap<>();

        Command allCategory = new ShowCategoriesCommand(categoryService);

        map.put(allCategory.choice(), allCategory);

        return map;
    }
}
