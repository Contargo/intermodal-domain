package api.masterData.vehicle;

import api.masterData.Operator;


/**
 * <p>In german Binnenschiff</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 Characters).
     */
    private String mmsi;

    /**
     * European Number of Identification e.g. 040-059 for Germany.
     */
    private String eni;

    private Operator operator;

    /**
     * in meter.
     */
    private double length;

    /**
     * in meter.
     */
    private double width;

    /**
     * in meter.
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
