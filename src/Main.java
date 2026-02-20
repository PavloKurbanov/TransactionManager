import ui.ConsoleUI;
import repository.*;
import repository.impl.CategoryRepositoryImpl;
import repository.impl.TransactionRepositoryImpl;
import repository.impl.WalletRepositoryImpl;
import service.CategoryService;
import service.TransactionService;
import service.WalletService;
import service.impl.CategoryServiceImpl;
import service.impl.TransactionServiceImpl;
import service.impl.WalletServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    CategoryRepository categoryRepository = new CategoryRepositoryImpl();
    WalletRepository walletRepository = new WalletRepositoryImpl();
    TransactionRepository transactionRepository = new TransactionRepositoryImpl();

    CategoryService categoryService = new CategoryServiceImpl(categoryRepository);
    WalletService walletService = new WalletServiceImpl(walletRepository);

    TransactionService transactionService = new TransactionServiceImpl(categoryRepository, walletRepository, transactionRepository);
    ConsoleUI consoleUI = new ConsoleUI(transactionService, walletService, categoryService);

    consoleUI.start();
}
