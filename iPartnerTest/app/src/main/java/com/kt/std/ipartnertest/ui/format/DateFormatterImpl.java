package com.kt.std.ipartnertest.ui.format;

import com.kt.std.ipartnertest.model.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateFormatterImpl implements DateFormatter {
    @Override
    public String fullDate(String date) {
        String pattern = "EE, dd MMM yyyy, HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("ru", "RU"));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String dateToday;
        dateToday = simpleDateFormat.format(new Date(Long.valueOf(date) * 1000));
        return dateToday.toUpperCase();
    }
}
