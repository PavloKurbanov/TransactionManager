package repository;


import entity.Wallet;
import util.CrudRepository;

import java.util.List;

public interface WalletRepository extends CrudRepository<Wallet, String> {

    void save(Wallet wallet);

    Wallet getById(String id);

    List<Wallet> getAll();
}
