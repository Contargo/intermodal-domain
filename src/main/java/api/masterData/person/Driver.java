package api.masterData.person;

import java.util.Date;


/**
 * <p>In german Fahrer</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Driver extends Person {

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date licenseValidity;

    private String licenseNumber;

    private String id;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date adr;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date moduleEntry95;
}
