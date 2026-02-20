package consoleUI.menu.processor.mapbuildedr;

import consoleUI.addCategory.AddCategoryProcessor;
import consoleUI.menu.processor.Processor;
import io.InputReader;
import service.TransactionManagerService;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {
    private final TransactionManagerService transactionManagerService;
    private final InputReader inputReader;

    public MapBuilder(TransactionManagerService transactionManagerService, InputReader inputReader){
        this.inputReader = inputReader;
        this.transactionManagerService = transactionManagerService;
    }

    public Map<String, Processor> build(){
        Map<String, Processor> transaction = new HashMap<>();

        Processor addTransaction = new AddCategoryProcessor(transactionManagerService, inputReader);

        transaction.put(addTransaction.choice(), addTransaction);

        return transaction;
    }
}
