package api.processData.registration;

import api.masterData.goods.DangerousGoods;

import java.util.Date;


/**
 * Contains information necessary for the registration of a {@link api.masterData.vehicle.Barge}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private api.masterData.vehicle.Barge barge;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date eta;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date etd;

    private DangerousGoods dangerousGoodsIndication;

    private int volumeToDischarge;

    private int volumeToLoad;
}
