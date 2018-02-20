package api.vehicle;

import api.transport.Operator;


/**
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
