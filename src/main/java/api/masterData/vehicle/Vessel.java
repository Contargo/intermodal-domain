package api.masterData.vehicle;

import api.masterData.Operator;


/**
 * <p>In german Seeschiff</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Vessel {

    private String name;

    /**
     * Maritime Mobile Service Identity.
     */
    private String mmsi;

    /**
     * International Maritime Organization.
     */
    private String imo;

    private Operator operator;
}
