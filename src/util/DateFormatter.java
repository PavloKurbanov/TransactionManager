package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class DateFormatter {
    public final static DateTimeFormatter FORMATTED = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String format(LocalDate localDate){
        return (localDate == null) ? "N/A" : localDate.format(FORMATTED);
    }

    public static LocalDate parse(String text) throws DateTimeParseException {
        return LocalDate.parse(text, FORMATTED);
    }
}
