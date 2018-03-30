package ua.epam.spring.hometask.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class util {

    public static LocalDateTime convertLocalDateTime(String source) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        return LocalDateTime.parse(source, formatter);
    }

    public static LocalDate convertLocalDate(String source) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        return LocalDate.parse(source, formatter);
    }
}
