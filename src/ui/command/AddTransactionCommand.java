package ui.command;

import entity.TransactionType;
import ui.io.InputReader;
import service.TransactionService;

public class AddTransactionCommand implements Command {
    private final InputReader inputReader;
    private final TransactionService transactionService;

    public AddTransactionCommand(TransactionService transactionService, InputReader inputReader) {
        this.inputReader = inputReader;
        this.transactionService = transactionService;
    }

    @Override
    public String choice() {
        return "3";
    }

    @Override
    public void process() {
        try {
            String string = inputReader.readString("Введіть назву витрати: ");
            String wallet = inputReader.readString("Введіть назву гаманця: ");
            String category = inputReader.readString("Введіть назву категорії: ");
            Double amount = inputReader.readDouble("Введіть суму витрати: ");
            TransactionType transactionType = inputReader.readTransactionType();

            transactionService.createTransaction(string, wallet, category, amount, transactionType);
            System.out.println("Витрату " + string + " успішно додано!");
        } catch (IllegalArgumentException e){
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
