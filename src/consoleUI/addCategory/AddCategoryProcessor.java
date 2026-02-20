package consoleUI.addCategory;

import consoleUI.menu.processor.Processor;
import io.InputReader;
import service.TransactionManagerService;

public class AddCategoryProcessor implements Processor {
    private final InputReader inputReader;
    private final TransactionManagerService transactionManagerService;

    public AddCategoryProcessor(TransactionManagerService transactionManagerService, InputReader inputReader) {
        this.inputReader = inputReader;
        this.transactionManagerService = transactionManagerService;
    }

    @Override
    public String choice() {
        return "1";
    }

    @Override
    public void process() {
        try {
            String string = inputReader.readString("Введіть назву витрати: ");
            String wallet = inputReader.readString("Введіть назву гаманця: ");
            String category = inputReader.readString("Введіть назву категорії: ");
            Double amount = inputReader.readDouble("Введіть суму витрати: ");

            transactionManagerService.createTransaction(string, wallet, category, amount);
            System.out.println("Витрату " + string + " успішно додано!");
        } catch (IllegalArgumentException e){
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
