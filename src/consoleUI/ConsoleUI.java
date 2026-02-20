package consoleUI;

import consoleUI.menu.processor.Processor;
import consoleUI.menu.processor.mapbuildedr.MapBuilder;
import io.InputReader;
import service.TransactionManagerService;

import java.util.Map;

public class ConsoleUI {
    private final InputReader inputReader;
    private Map<String, Processor> builder;

    public ConsoleUI(TransactionManagerService transactionManagerService){
        this.inputReader = new InputReader();
        MapBuilder mapBuilder = new MapBuilder(transactionManagerService, inputReader);
        this.builder = mapBuilder.build();
    }

    public void start(){
        while(true){
            System.out.println("1) Додайте транзакцію");

            String choice = inputReader.readString("Введіть цифру:");

            if(choice.equals("0")){
                return;
            } else{
                Processor processor = builder.get(choice);

                if(processor != null){
                    processor.process();
                } else {
                    System.out.println("Введіть цифру з меню!");
                }
            }
        }
    }
}
