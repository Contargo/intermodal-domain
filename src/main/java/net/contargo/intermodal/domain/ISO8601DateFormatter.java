package net.contargo.intermodal.domain;

import java.text.SimpleDateFormat;

import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * Date formatter for ISO8601 dates.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ISO8601DateFormatter {

    public static String format(int year, int month, int day) {

        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        simpleDateFormat.setTimeZone(utc);

        GregorianCalendar calendar = new GregorianCalendar(utc);
        calendar.set(year, month - 1, day, 0, 0, 0);

        return simpleDateFormat.format(calendar.getTime());
    }


    public static String format(int year, int month, int day, int hour, int minute) {

        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        simpleDateFormat.setTimeZone(utc);

        GregorianCalendar calendar = new GregorianCalendar(utc);
        calendar.set(year, month - 1, day, hour, minute, 0);

        return simpleDateFormat.format(calendar.getTime());
    }
}
