package api.masterData.meansOfTransport;

import java.util.Date;


/**
 * Trailer to transport loading units.
 *
 * <p>DIGIT_name: Fahrgestell</p>
 *
 * <p>DIGIT_english: chassis</p>
 *
 * <p>DIGIT_definition: Anhänger zur Beförderung von Ladeeinheiten.</p>
 *
 * <p>DIGIT_definition_english: Trailer to transport loading units.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Chassis extends MeansOfTransport {

    /**
     * Format: spaces included.
     */
    private String numberPlate;

    /**
     * Ministry of Transport test. (In german Hauptuntersuchung (TÜV))
     *
     * <p>Format: DateTime ISO 8601 incl. UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).</p>
     */
    private Date mot;

    /**
     * e.g. Multichassis.
     */
    private String type;

    private int axles;

    /**
     * in meter.
     */
    private double size;

    /**
     * in meter.
     */
    private double height;

    private boolean euAuthorization;

    /**
     * Safety test (in german Sicherheitsprüfung).
     */
    private boolean st;

    private boolean suitabilityDangerousGoods;

    private boolean suitabilityWaste;

    private boolean suitabilityReefer;

    /**
     * in kg.
     */
    private double weightTara;
}
