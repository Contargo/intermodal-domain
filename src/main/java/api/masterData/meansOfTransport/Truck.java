package api.masterData.meansOfTransport;

import java.util.Date;


/**
 * <p>In german Zugmaschine</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Truck extends MeansOfTransport {

    private String numberPlate;

    /**
     * 2 Characters (UN/LOCODE).
     */
    private String countryCode;

    /**
     * Ministry of Transport test. (In german Hauptuntersuchung (TÜV))
     *
     * <p>Format: DateTime ISO 8601 incl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).</p>
     */
    private Date mot;

    private EnvironmentBadge environmentBadge;

    private String type;

    private boolean euAuthorization;

    /**
     * Security test.
     */
    private boolean st;

    private boolean suitabilityDangerousGoods;

    private boolean suitabilityWaste;

    /**
     * in kg.
     */
    private double weightTara;
}
