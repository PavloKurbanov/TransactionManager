package entity;

import java.util.Objects;

public class Wallet {
    private final String name;
    private double amount;

    public Wallet(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Сума повинна бути бульше 0");
        }
        this.amount += amount;
    }

    public void withdraw(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Сума повинна бути бульше 0");
        }
        if(this.amount < amount){
            throw new IllegalArgumentException("Не достатньо коштів");
        }
        this.amount -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Double.compare(amount, wallet.amount) == 0 && Objects.equals(name, wallet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount);
    }
}
