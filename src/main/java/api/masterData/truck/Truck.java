package api.masterData.truck;

import api.masterData.meansOfTransport.EnvironmentBadge;
import api.masterData.meansOfTransport.MeansOfTransport;

import java.util.Date;


/**
 * Commercial vehicle which is mostly or exclusively used for carrying trailed vehicles.
 *
 * <p>DIGIT_name: Zugmaschine</p>
 *
 * <p>DIGIT_english: truck</p>
 *
 * <p>DIGIT_definition: Nutzkraftwagen, der ausschließlich oder überwiegend zum Mitführen von Anhängerfahrzeugen
 * bestimmt ist. (@see DIN 70010:2001-04, 1.2.2.3)</p>
 *
 * <p>DIGIT_definition_english: Commercial vehicle which is mostly or exclusively used for carrying trailed vehicles.
 * (@see DIN 70010:2001-04, 1.2.2.3)</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Truck extends MeansOfTransport {

    /**
     * Format: spaces included.
     */
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
