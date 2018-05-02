package net.contargo.intermodal.domain.utility;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class ISO8601DateFormatter {

    public static String format(int year, int month, int day) {

        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        simpleDateFormat.setTimeZone(utc);

        Date time = new GregorianCalendar(year, month - 1, day, 1, 0).getTime();

        return simpleDateFormat.format(time);
    }
}
