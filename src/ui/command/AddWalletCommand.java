package ui.command;

import entity.Wallet;
import ui.io.InputReader;
import service.WalletService;

public class AddWalletCommand implements Command {
    private final WalletService walletService;
    private final InputReader inputReader;

    public AddWalletCommand(WalletService walletService, InputReader inputReader) {
        this.walletService = walletService;
        this.inputReader = inputReader;
    }
    @Override
    public String choice() {
        return "1";
    }

    @Override
    public void process() {
        try {
            String walletName = inputReader.readString("Введіть назву гаманця: ");
            Double amount = inputReader.readDouble("Введіть суму гаманця: ");
            walletService.createWallet(new Wallet(walletName, amount));
            System.out.println("Гаманець " + walletName + " створено. Сума: " + amount);
        } catch (IllegalArgumentException e) {
            System.err.println("ПОМИЛКА: " + e.getMessage());
        }
    }
}
