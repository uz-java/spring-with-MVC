package org.example.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

/**
 * @author "Tojaliyev Asliddin"
 * @since 28/07/22 19:52 (Thursday)
 * Spring_mvc/IntelliJ IDEA
 */
public class Utils {
    public static boolean isParsable(String timeAsString) {
        try {
            LocalDateTime.parse(timeAsString);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDateTime toLocalDateTime(String timeAsString) {
        try {
            return LocalDateTime.parse(timeAsString);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
