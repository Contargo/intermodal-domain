package api.processData.registration;

import api.masterData.dangerousGoods.DangerousGoods;

import java.util.Date;


/**
 * Contains information necessary for the registration of a {@link api.masterData.barge.Barge}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private api.masterData.barge.Barge barge;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 incl. UTC)
     */
    private Date etd;

    /**
     * Value is optional and can be null.
     */
    private DangerousGoods dangerousGoodsIndication;

    /**
     * Number of LUs.
     */
    private int volumeToDischarge;

    /**
     * Number of LUs.
     */
    private int volumeToLoad;
}
