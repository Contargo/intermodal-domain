package api.vehicle;

import api.transport.Operator;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private String name;

    /**
     * Maritime Mobile Service Identity.
     */
    private String mmsi;

    /**
     * European Number of Identification.
     */
    private String eni;

    private Operator operatorMd;

    /**
     * in meters.
     */
    private double length;

    /**
     * in meters.
     */
    private double width;

    /**
     * in meters.
     */
    private double draught;

    private int bays;

    private int rows;

    private int tiers;

    private boolean suitabilityDangerousGoods;

    private double capacityTeu;

    /**
     * in tons.
     */
    private double capacityTons;
}
