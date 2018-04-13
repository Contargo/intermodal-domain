package api.processData.registration;

import api.masterData.operator.Operator;

import java.util.Date;


/**
 * Contains information necessary for the registration of a Train.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Train {

    private String trainTitle;

    private Operator railwayOperator;

    private Operator operator;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date terminalEta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 incl. UTC)
     */
    private Date terminalEtd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date shuntingYardEta;

    private String shunter;

    /**
     * in meter.
     */
    private double totalLength;

    private int waggonQuantity;

    /**
     * Number of LUs.
     */
    private int volumeToDischarge;

    /**
     * Number of LUs.
     */
    private int volumeToLoad;

    private String trainPaths;
}
