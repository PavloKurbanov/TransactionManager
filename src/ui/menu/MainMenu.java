package ui.menu;

import ui.command.Command;
import ui.io.InputReader;
import service.CategoryService;
import service.TransactionService;
import service.WalletService;

import java.util.Map;

public class MainMenu {
    private final InputReader inputReader;
    private final Map<String, Command> builder;

    public MainMenu(TransactionService transactionService, WalletService walletService, CategoryService  categoryService, InputReader inputReader) {
        this.inputReader = inputReader;
        MainMenuBuilder mainMenuBuilder = new MainMenuBuilder(transactionService, inputReader,categoryService, walletService);
        this.builder = mainMenuBuilder.build();
    }

    public void start(){
        while(true){
            System.out.println("1) Додайте гаманець");
            System.out.println("2) Додайте категорію");
            System.out.println("3) Додайте транзакцію");
            System.out.println("4) Переглянути:");
            System.out.println("0) Вийти");

            String choice = inputReader.readString("Введіть цифру: ");

            if(choice.equals("0")){
                System.out.println("Дякуємо! Гарного дня!");
                return;
            } else{
                Command command = builder.get(choice);

                if(command != null){
                    command.process();
                } else {
                    System.out.println("Введіть цифру з меню!");
                }
            }
        }
    }
}
