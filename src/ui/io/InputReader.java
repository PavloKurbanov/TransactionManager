package ui.io;

import util.DateFormatter;
import entity.TransactionType;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public Double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String nextLine = scanner.nextLine();
                return Double.parseDouble(nextLine);
            } catch (IllegalArgumentException e) {
                System.err.println("Введіть число!");
            }
        }
    }

    public LocalDate readTime() {
        System.out.println("Введіть дату через '-' ");
        LocalDate dateTime = null;
        while (dateTime == null) {
            try {
                dateTime = LocalDate.parse(scanner.nextLine(), DateFormatter.FORMATTED);
            } catch (IllegalArgumentException | DateTimeException e) {
                System.err.println("Помилка: " + e.getMessage());
            }
        }
        return dateTime;
    }

    public TransactionType readTransactionType() {
        TransactionType[] transactionTypes = TransactionType.values();
        TransactionType transactionType = null;
        do {
            try {
                System.out.println("Оберіть тип транзакції: ");
                for (int i = 0; i < transactionTypes.length; i++) {
                    System.out.println((i + 1) + ". " + transactionTypes[i].getDescription());
                }
                int transactionTypeId = Integer.parseInt(scanner.nextLine());
                if (transactionTypeId >= 1 && transactionTypeId <= transactionTypes.length) {
                    transactionType = transactionTypes[transactionTypeId - 1];
                }
            } catch (NumberFormatException e) {
                System.err.println("Введіть коректне число!");
            }
        } while (transactionType == null);
        return transactionType;
    }
}
