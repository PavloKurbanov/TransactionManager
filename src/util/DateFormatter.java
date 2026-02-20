package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateFormatter {
    public final static DateTimeFormatter FORMATTED = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static String format(LocalDate localDate){
        return (localDate == null) ? "N/A" : localDate.format(FORMATTED);
    }
}
