package agility.season.controllers.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javafx.util.StringConverter;

public class LocalDateStringConverter extends StringConverter<LocalDate> {
    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd MMM yyyy").withLocale(Locale.FRENCH);
    // static {
    // fmt.withZone(ZoneId.of("Europe/Paris"));
    // }

    @Override
    public String toString(LocalDate date) {
	return date.format(fmt);
    }

    @Override
    public LocalDate fromString(String string) {
	return null;
    }
}
