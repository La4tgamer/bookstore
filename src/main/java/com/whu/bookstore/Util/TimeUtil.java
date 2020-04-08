package com.whu.bookstore.Util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author qx.w
 * @date 2020/3/16 15.59
 */
public class TimeUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static LocalDate getCurrentLocalDateTime() {
        Date date = new Date();
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * 字符串转LocaDateTime
     * @param dateTime
     * @param formatter
     * @return
     */
    public static LocalDateTime parserString2LocalDateTime(final String dateTime, final String formatter) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDateTime dateTest = LocalDateTime.parse(dateTime, df);
        return dateTest;
    }
}
