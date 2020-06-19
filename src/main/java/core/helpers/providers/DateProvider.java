package core.helpers.providers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

public class DateProvider {

    public static final DateTimeFormatter DASH_MMddyyyy_HHmmss = ofPattern("MM-dd-yyyy HH:mm:ss");

    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }
}
