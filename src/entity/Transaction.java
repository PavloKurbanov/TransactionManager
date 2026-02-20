package entity;

import dataformated.TimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private final String name;
    private final String walletName;
    private final String categoryName;
    private final LocalDate date;
    private double amount;

    public Transaction(String name, String walletName, String categoryName, double amount) {
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

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(name, that.name) && Objects.equals(walletName, that.walletName) && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, walletName, categoryName, amount);
    }

    @Override
    public String toString() {
        return String.format("%s | Гоманець: %s | Категорія: %s |Сума: %.2f | Дата: %s", name, walletName, categoryName, amount, date.format(TimeFormat.FORMATTED));
    }
}