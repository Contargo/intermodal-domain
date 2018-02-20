package api.person;

import java.util.Date;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Driver extends Person {

    // TODO - type: DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX. Beispiel: 2017-06-13T13:00:00.000Z)
    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date licenseValidity;

    private String licenseNumber;

    private String id;

    // TODO - type: Ja/nein: Gültigkeit (DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX. Beispiel: 2017-06-13T13:00:00.000Z))
    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date adr;

    // TODO - type: Ja/nein: Gültigkeit (DateTime ISO 8601 inkl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX. Beispiel: 2017-06-13T13:00:00.000Z))
    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date moduleEntry95;
}
