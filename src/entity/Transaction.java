package entity;

import util.DateFormatter;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private Integer id;
    private final String name;
    private final String walletName;
    private final String categoryName;
    private final LocalDate date;
    private final double amount;

    public Transaction(Integer id, String name, String walletName, String categoryName, double amount) {
        this.id = id;
        this.name = name;
        this.walletName = walletName;
        this.categoryName = categoryName;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getWalletName() {
        return walletName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(name, that.name) && Objects.equals(
                walletName, that.walletName) && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, walletName, categoryName, amount);
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Назва: %s | Гаманець: %s | Категорія: %s |Сума: %.2f | Дата: %s",
                id, name, walletName, categoryName, amount, DateFormatter.format(date));
    }
}