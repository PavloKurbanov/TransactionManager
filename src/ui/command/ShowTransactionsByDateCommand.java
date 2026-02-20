package ui.command;

import entity.Transaction;
import service.TransactionService;
import ui.io.InputReader;
import util.DateFormatter;

import java.time.LocalDate;
import java.util.List;

public class ShowTransactionsByDateCommand implements Command {
    private final TransactionService transactionService;
    private final InputReader inputReader;

    public ShowTransactionsByDateCommand(TransactionService transactionService, InputReader inputReader) {
        this.transactionService = transactionService;
        this.inputReader = inputReader;
    }

    @Override
    public void process() {
        LocalDate localDate = inputReader.readTime();
        List<Transaction> allTransactionByDate = transactionService.getAllTransactionByDate(localDate);
        if (allTransactionByDate.isEmpty()) {
            System.out.println("Не має тратзакцій за " + localDate.format(DateFormatter.FORMATTED));
            return;
        }

        System.out.println("----- ТРАНЗАКЦІЇ ЗА " + localDate.format(DateFormatter.FORMATTED));
        for (Transaction transaction : allTransactionByDate) {
            System.out.println(transaction);
        }
    }

    @Override
    public String choice() {
        return "5";
    }
}
