package api.masterData.vehicle;

import java.util.Date;


/**
 * <p>In german Zugmaschine</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Truck {

    private String numberPlate;

    /**
     * 2 Characters (UN/LOCODE).
     */
    private String countryCode;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    private Date mot;

    private EnvironmentBadge environmentBadge;

    private String type;

    private boolean euAuthorization;

    // TODO - type: Sicherheitsprüfung?
    private boolean st;

    private boolean suitabilityDangerousGoods;

    private boolean suitabilityWaste;

    /**
     * in kg.
     */
    private double weightTara;
}
