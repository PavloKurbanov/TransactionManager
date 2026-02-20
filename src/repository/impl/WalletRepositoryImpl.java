package repository.impl;

import entity.Wallet;
import repository.WalletRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletRepositoryImpl implements WalletRepository {
    private final Map<String, Wallet> wallets;

    public WalletRepositoryImpl() {
        this.wallets = new HashMap<>();
    }

    @Override
    public List<Wallet> getAll() {
        return new ArrayList<>(wallets.values());
    }

    @Override
    public Wallet getById(String id) {
        return wallets.get(id);
    }

    @Override
    public void save(Wallet wallet) {
        wallets.put(wallet.getName(), wallet);
    }
}
