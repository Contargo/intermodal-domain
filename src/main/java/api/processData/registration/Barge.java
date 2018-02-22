package api.processData.registration;

import api.masterData.goods.DangerousGoods;

import java.util.Date;


/**
 * Contains information necessary for the registration of a barge.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private api.masterData.vehicle.Barge barge;

    /**
     * format: yyyy-MM-dd'T'HH:mm:ss.SSSX
     */
    private Date eta;

    /**
     * format: yyyy-MM-dd'T'HH:mm:ss.SSSX
     */
    private Date etd;

    // TODO - ja; nein -> DangerousGoods
    private DangerousGoods dangerousGoodsIndication;

    private int volumeToDischarge;

    private int volumeToLoad;
}
