package repository;



import entity.Wallet;

import java.util.List;

public interface WalletRepository {

    void saveWallet(Wallet wallet);

    Wallet getWallet(String name);

    List<Wallet> getAll();
}
