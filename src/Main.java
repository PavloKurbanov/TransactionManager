import repository.fileImpl.FIleCategoryRepository;
import repository.fileImpl.FileTransactionRepository;
import repository.fileImpl.FileWalletRepository;
import ui.menu.MainMenu;
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
import ui.io.InputReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Path wallets = Paths.get("wallets.txt");
    Path transactions = Paths.get("transactions.txt");
    Path categories = Paths.get("categories.txt");
    InputReader  inputReader = new InputReader();
    CategoryRepository categoryRepository = new FIleCategoryRepository(categories);
    WalletRepository walletRepository = new FileWalletRepository(wallets);
    TransactionRepository transactionRepository = new FileTransactionRepository(transactions);

    CategoryService categoryService = new CategoryServiceImpl(categoryRepository);
    WalletService walletService = new WalletServiceImpl(walletRepository);

    TransactionService transactionService = new TransactionServiceImpl(categoryRepository, walletRepository, transactionRepository);
    MainMenu mainMenu = new MainMenu(transactionService, walletService, categoryService, inputReader);

    mainMenu.start();
}
