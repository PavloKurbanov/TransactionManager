package ui.command;

import entity.Transaction;
import service.TransactionService;

import java.util.List;

public class ShowTransactionsCommand implements Command {
    private final TransactionService transactionService;

    public ShowTransactionsCommand(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public String choice() {
        return "1";
    }

    @Override
    public void process() {
        List<Transaction> allTransaction = transactionService.getAllTransaction();
        if (allTransaction.isEmpty()) {
            System.out.println("Не має транзакцій");
            return;
        }
        System.out.print("----- ТРАНЗАКЦІЇ -----");

        allTransaction.forEach(System.out::println);
    }
}
