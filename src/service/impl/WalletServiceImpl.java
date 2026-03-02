package service.impl;

import entity.Wallet;
import repository.WalletRepository;
import service.WalletService;

import java.util.List;

public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public void createWallet(Wallet wallet) {
        if (wallet == null) {
            throw new IllegalArgumentException("Введіть коректну назву");
        }
        if (wallet.getAmount() < 0) {
            throw new IllegalArgumentException("Сума не може бути менше 0");
        }
        walletRepository.save(wallet);
    }

    @Override
    public Wallet getWalletByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Введіть коректну назву");
        }
        return walletRepository.getById(name);
    }

    @Override
    public List<Wallet> getWallets() {
        return walletRepository.getAll();
    }
}
