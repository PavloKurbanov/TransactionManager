package ui.command;

import entity.Transaction;
import service.TransactionService;
import ui.io.InputReader;
import util.DateFormatter;

import java.time.LocalDate;
import java.util.List;

public record ShowTransactionsByDateCommand(TransactionService transactionService,
                                            InputReader inputReader) implements Command {

    @Override
    public void process() {
        LocalDate localDate = inputReader.readTime();
        List<Transaction> allTransactionByDate = transactionService.getAllTransactionByDate(localDate);
        if (allTransactionByDate.isEmpty()) {
            System.out.println("Не має транзакцій за " + DateFormatter.format(localDate));
            return;
        }

        System.out.println("----- ТРАНЗАКЦІЇ ЗА " + DateFormatter.format(localDate));
        for (Transaction transaction : allTransactionByDate) {
            System.out.println(transaction);
        }
    }

    @Override
    public String choice() {
        return "5";
    }
}
