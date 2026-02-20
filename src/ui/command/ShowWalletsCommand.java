package ui.command;

import entity.Wallet;
import service.WalletService;

import java.util.List;

public class ShowWalletsCommand implements Command {
    private final WalletService walletService;

    public ShowWalletsCommand(WalletService walletService) {
        this.walletService = walletService;
    }

    @Override
    public String choice() {
        return "2";
    }

    @Override
    public void process() {
        List<Wallet> allWallets = walletService.getWallets();

        if (allWallets.isEmpty()) {
            System.out.println("Не має гаманців");
            return;
        }

        System.out.println("----- ГАМАНЦІ -----");

        allWallets.forEach(System.out::println);
    }
}
