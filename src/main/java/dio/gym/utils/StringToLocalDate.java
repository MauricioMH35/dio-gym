package dio.gym.utils;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDate {

    @Value("${application.date-formatter:yyyy-MM-dd}")
    private static String DATE_FORMATTER = "yyyy-MM-dd";

    public String getFormatter() {
        return DATE_FORMATTER;
    }

    public void setFormatter(String formatter) {
        DATE_FORMATTER = formatter;
    }

    public static LocalDate parse(String target) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        return LocalDate.parse(target, formatter);
    }

    public static String parse(LocalDate target) {
        return target.toString();
    }
}
