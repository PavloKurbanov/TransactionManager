package ui.command;

import entity.Transaction;
import entity.TransactionType;
import service.TransactionService;
import ui.io.InputReader;

import java.util.List;

public class ShowTransactionsByTypeCommand implements Command {
    private final TransactionService transactionService;
    private final InputReader inputReader;

    public ShowTransactionsByTypeCommand(TransactionService transactionService, InputReader inputReader) {
        this.transactionService = transactionService;
        this.inputReader = inputReader;
    }

    @Override
    public void process() {
        TransactionType transactionType = inputReader.readTransactionType();
        List<Transaction> allTransactionByType = transactionService.getAllTransactionByType(transactionType);

        if (allTransactionByType.isEmpty()) {
            System.out.println("Не має транзакцій за датою " + transactionType.getDescription());
            return;
        }

        System.out.println("----- Транзакції типу " + transactionType.getDescription() + " -----");

        allTransactionByType.forEach(System.out::println);
    }

    @Override
    public String choice() {
        return "4";
    }
}
