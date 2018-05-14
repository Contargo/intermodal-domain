package net.contargo.intermodal.domain;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
class ISO8601DateFormatter {

    public static String format(int year, int month, int day) {

        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        simpleDateFormat.setTimeZone(utc);

        Date time = new GregorianCalendar(year, month - 1, day, 1, 0).getTime();

        return simpleDateFormat.format(time);
    }


    public static String format(int year, int month, int day, int hour, int minute) {

        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        simpleDateFormat.setTimeZone(utc);

        Date time = new GregorianCalendar(year, month - 1, day, hour, minute).getTime();

        return simpleDateFormat.format(time);
    }
}
