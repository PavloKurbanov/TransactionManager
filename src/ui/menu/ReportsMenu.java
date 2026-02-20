package ui.menu;

import ui.command.Command;
import ui.io.InputReader;
import service.CategoryService;
import service.TransactionService;
import service.WalletService;

import java.util.Map;

public class ReportsMenu {
    private final Map<String, Command> processors;
    private final InputReader inputReader;

    public ReportsMenu(TransactionService transactionService, WalletService walletService, CategoryService categoryService, InputReader inputReader) {
        this.inputReader = inputReader;
        ReportsMenuBuilder reportsMenuBuilder = new ReportsMenuBuilder(transactionService,categoryService, walletService, inputReader);
        this.processors = reportsMenuBuilder.build();
    }

    public void show() {
        while (true) {
            System.out.println("1) Всі Транзакції");
            System.out.println("2) Гаманці");
            System.out.println("3) Категорії");
            System.out.println("4) Транзакції за типом");
            System.out.println("5) Транзакції за датою");
            System.out.println("0) Назад");

            String readString = inputReader.readString("Оберіть дію: ");

            if (readString.equals("0")) {
                return;
            } else {
                Command command = processors.get(readString);
                if (command != null) {
                    command.process();
                } else {
                    System.err.println("Оберіть дію зі списку!");
                }
            }
        }
    }
}
