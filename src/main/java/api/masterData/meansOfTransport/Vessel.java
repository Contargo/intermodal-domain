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
     * Maritime Mobile Service Identity (9 Characters).
     */
    private String mmsi;

    /**
     * International Maritime Organization.
     */
    private String imo;

    private Operator operator;
}
