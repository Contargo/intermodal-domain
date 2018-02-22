package api.processData.registration;

import api.masterData.Operator;

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
     * format: ISO 8601 incl. UTC
     */
    private Date terminalEta;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date terminalEtd;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date shuntingYardEta;

    private String shunter;

    /**
     * in meters.
     */
    private double totalLength;

    private int waggonQuantity;

    private int volumeToDischarge;

    private int volumeToLoad;

    private String trainPaths;
}
