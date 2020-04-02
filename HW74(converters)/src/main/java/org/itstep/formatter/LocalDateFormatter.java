package org.itstep.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;

@Slf4j
public class LocalDateFormatter implements Formatter<LocalDate> {
    @Override
    public LocalDate parse(String s, Locale locale) throws ParseException {
        log.info("log in LocalDateFormatter = " + s);
        return LocalDate.parse(s);
    }

    @Override
    public String print(LocalDate localDate, Locale locale) {

        return localDate.toString();
    }
}
