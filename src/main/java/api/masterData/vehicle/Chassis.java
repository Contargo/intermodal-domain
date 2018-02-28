package api.masterData.vehicle;

import java.util.Date;


/**
 * <p>In german Fahrgestell</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Chassis {

    private String numberPlate;

    /**
     * DateTime ISO 8601 incl. UTC.
     */
    // TODO - Ministry of Transport? Länderspezifisch?
    private Date mot;

    /**
     * e.g. Multichassis
     */
    private String type;

    private int axles;

    /**
     * in meter.
     */
    private double size;

    /**
     * in meter.
     */
    private double height;

    private boolean euAuthorization;

    // TODO - type: Sicherheitsprüfung ?
    private boolean st;

    private boolean suitabilityDangerousGoods;

    private boolean suitabilityWaste;

    private boolean suitabilityReefer;

    /**
     * in kg.
     */
    private double weightTara;
}
