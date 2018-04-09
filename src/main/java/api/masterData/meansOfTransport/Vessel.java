package api.masterData.meansOfTransport;

import api.masterData.Operator;


/**
 * <p>In german Seeschiff</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Vessel extends MeansOfTransport {

    private String name;

    /**
     * Maritime Mobile Service Identity (9 digits).
     */
    private int mmsi;

    /**
     * International Maritime Organization (IMO plus 7 digits).
     */
    private String imo;

    private Operator operator;
}
