package repository.fileImpl;

import entity.Transaction;
import repository.TransactionRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileTransactionRepository implements TransactionRepository {
    private final Path filePath;
    private final List<Transaction> transactions;
    private Integer transactionId = 1;

    public FileTransactionRepository(Path filePath) {
        this.filePath = filePath;
        this.transactions = new ArrayList<>();
        try{
            if(!Files.exists(filePath)){
                Files.createFile(filePath);
            } else {
                loadFile();
            }
        } catch(IOException e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        if(transaction.getId() == null){
            transaction.setId(transactionId++);
        }
        transactions.add(transaction);
        try{
            saveFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Transaction> getDateTransactions(LocalDate date) {
        List<Transaction> getAllTransactionDate = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getDate().equals(date)) {
                getAllTransactionDate.add(transaction);
            }
        }
        return getAllTransactionDate;
    }

    @Override
    public Transaction getTransaction(int id) {
        for (Transaction transaction : transactions) {
            if(transaction.getId() == id) {
                return transaction;
            }
        }
        throw new IllegalArgumentException("Не має транзакції з ID: " + id);
    }

    @Override
    public List<Transaction> getAll() {
        return new ArrayList<>(transactions);
    }

    private void saveFile() throws IOException {
        List<String> list = new ArrayList<>();
        for (Transaction transaction : transactions) {
            String parse = transaction.getId() + "," + transaction.getName() + "," + transaction.getWalletName() + ","
                    + transaction.getCategoryName() + "," + transaction.getAmount() + "," + transaction.getDate();

            list.add(parse);
        }
        Files.write(filePath, list);
    }

    private void loadFile() throws IOException {
        boolean exists = Files.exists(filePath);
        if(!exists){
            return;
        }
        List<String> list = Files.readAllLines(filePath);

        for (String transaction : list) {
            String[] parse = transaction.split(",");
            int transactionId = Integer.parseInt(parse[0]);
            String name = parse[1];
            String walletName = parse[2];
            String categoryName = parse[3];
            Double amount = Double.parseDouble(parse[4]);

            Transaction newTransaction = new Transaction(transactionId, name, walletName, categoryName, amount);
            transactions.add(newTransaction);
            if( transactionId >= this.transactionId){
                this.transactionId = transactionId + 1;
            }
        }
    }
}
