package io;

import dataformated.TimeFormat;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class InputReader {
    private final Scanner scanner;

    public InputReader(){
        scanner = new Scanner(System.in);
    }

    public String readString(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public Double readDouble(String prompt){
        while(true){
            try{
                System.out.print(prompt);
                String nextLine = scanner.nextLine();
                return Double.parseDouble(nextLine);
            } catch (IllegalArgumentException e){
                System.err.println("Введіть число!");
            }
        }
    }

    public LocalDate readTime(){
        System.out.println("Введіть дату через '-' ");
        LocalDate dateTime = null;
        while (dateTime == null) {
            try{
                dateTime = LocalDate.parse(scanner.nextLine(), TimeFormat.FORMATTED);
            } catch (IllegalArgumentException | DateTimeException e){
                System.err.println("Помилка: " + e.getMessage());
            }
        }
        return dateTime;
    }
}
