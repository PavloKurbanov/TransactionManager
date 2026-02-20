package ui.command;

import ui.menu.ReportsMenu;
import ui.io.InputReader;
import service.CategoryService;
import service.TransactionService;
import service.WalletService;

public class OpenReportsMenuCommand implements Command {
    private final ReportsMenu reportsMenu;

    public OpenReportsMenuCommand(TransactionService transactionService, WalletService walletService, CategoryService categoryService, InputReader inputReader) {
        this.reportsMenu = new ReportsMenu(transactionService,walletService,categoryService,inputReader);
    }

    @Override
    public String choice() {
        return "4";
    }

    @Override
    public void process() {
        reportsMenu.show();
    }
}
