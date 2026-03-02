package ui.menu;

import ui.command.Command;
import ui.io.InputReader;
import service.CategoryService;
import service.TransactionService;
import service.WalletService;
import ui.command.ShowCategoriesCommand;
import ui.command.ShowWalletsCommand;
import ui.command.ShowTransactionsByDateCommand;
import ui.command.ShowTransactionsCommand;

import java.util.HashMap;
import java.util.Map;

public record ReportsMenuBuilder(TransactionService transactionService, CategoryService categoryService,
                                 WalletService walletService, InputReader inputReader) {

    public Map<String, Command> build() {
        Map<String, Command> map = new HashMap<>();

        Command allCategory = new ShowCategoriesCommand(categoryService);
        Command allTransaction = new ShowTransactionsCommand(transactionService);
        Command allWallet = new ShowWalletsCommand(walletService);
        Command getTransactionByDate = new ShowTransactionsByDateCommand(transactionService, inputReader);

        map.put(allCategory.choice(), allCategory);
        map.put(allTransaction.choice(), allTransaction);
        map.put(allWallet.choice(), allWallet);
        map.put(getTransactionByDate.choice(), getTransactionByDate);

        return map;
    }
}
