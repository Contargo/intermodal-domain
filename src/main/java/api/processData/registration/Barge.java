package api.processData.registration;

import api.masterData.goods.DangerousGoods;

import java.util.Date;


/**
 * Contains information necessary for the registration of a {@link api.masterData.meansOfTransport.Barge}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private api.masterData.meansOfTransport.Barge barge;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 incl. UTC)
     */
    private Date etd;

    private DangerousGoods dangerousGoodsIndication;

    private int volumeToDischarge;

    private int volumeToLoad;
}
