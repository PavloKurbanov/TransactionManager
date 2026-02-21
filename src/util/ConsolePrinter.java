package util;

import java.util.List;

public class ConsolePrinter {

    /**
     * Універсальний метод для друку будь-якого списку.
     * Повертає true, якщо список порожній (щоб ми могли зупинити команду).
     */
    public static <T> boolean printList(List<T> list, String emptyMessage, String header) {
        if (list.isEmpty()) {
            System.out.println("❌ " + emptyMessage);
            return true; // Сигнал, що далі йти не треба
        }

        System.out.println(header);
        list.forEach(System.out::println);
        return false; // Сигнал, що все добре, дані є
    }
}