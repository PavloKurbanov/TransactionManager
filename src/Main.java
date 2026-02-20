import consoleUI.ConsoleUI;
import dataformated.TimeFormat;
import entity.Category;
import entity.Transaction;
import entity.Wallet;
import io.InputReader;
import repository.*;
import service.TransactionManagerService;
import service.TransactionManagerServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    WalletRepository walletRepository = new WalletRepositoryImpl();
    TransactionRepository transactionRepository = new TransactionRepositoryImpl();

    TransactionManagerService transactionManagerService = new TransactionManagerServiceImpl(categoryRepository, walletRepository, transactionRepository);
    ConsoleUI consoleUI = new ConsoleUI(transactionManagerService);

    consoleUI.start();
}
