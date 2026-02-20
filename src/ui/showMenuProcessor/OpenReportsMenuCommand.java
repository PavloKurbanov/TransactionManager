package ui.showMenuProcessor;

import ui.command.Command;
import ui.io.InputReader;
import service.CategoryService;
import service.TransactionService;
import service.WalletService;

public class OpenReportsMenuCommand implements Command {
    private final ReportsMenuBuilder reportsMenuBuilder;

    public OpenReportsMenuCommand(TransactionService transactionService, WalletService walletService, CategoryService categoryService, InputReader inputReader) {
        this.reportsMenuBuilder = new ReportsMenuBuilder(transactionService, categoryService, walletService, inputReader);
    }

    @Override
    public String choice() {
        return "4";
    }

    @Override
    public void process() {
        reportsMenuBuilder.show();
    }
}
