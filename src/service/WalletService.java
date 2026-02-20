package service;

import entity.Wallet;

import java.util.List;

public interface WalletService {
    void createWallet(Wallet wallet);

    Wallet getWalletByName(String name);

    List<Wallet> getWallets();
}
