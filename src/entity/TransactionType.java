package entity;

public enum TransactionType {
    INCOME("Дохід"),
    EXPENSE("Витрати");
    private String description;

    TransactionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
