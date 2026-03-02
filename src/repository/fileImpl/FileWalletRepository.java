package repository.fileImpl;

import entity.Wallet;
import repository.WalletRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileWalletRepository implements WalletRepository {
    private final Path filePath;
    private final Map<String, Wallet> wallets;

    public FileWalletRepository(Path filePath) {
        this.filePath = filePath;
        this.wallets = new HashMap<>();
        try{
            if(!Files.exists(filePath)){
                Files.createFile(filePath);
            } else {
                loadFile();
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Wallet wallet) {
        wallets.put(wallet.getName(), wallet);
        try {
            saveFile();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Wallet getById(String id) {
        return wallets.get(id);
    }

    @Override
    public List<Wallet> getAll() {
        return new ArrayList<>(wallets.values());
    }

    private void saveFile() throws IOException {
        List<String> lines = new ArrayList<>();
        for (Wallet wallet : wallets.values()) {
            String walletInfo = wallet.getName() + "," + wallet.getAmount();
            lines.add(walletInfo);
        }
        Files.write(filePath, lines);
    }

    private void loadFile() throws IOException {
        boolean exists = Files.exists(filePath);
        if(!exists){
            return;
        }
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] fields = line.split(",");

            String name = fields[0];
            Double amount = Double.parseDouble(fields[1]);

            Wallet wallet = new Wallet(name, amount);
            wallets.put(name, wallet);
        }
    }
}
