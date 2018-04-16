package api.masterData.chassis;

import api.masterData.meansOfTransport.MeansOfTransport;

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
public class Chassis implements MeansOfTransport {

    /**
     * Format: spaces included.
     */
    private String numberPlate;

    /**
     * Ministry of Transport Test (Format: DateTime ISO 8601 inclusive UTC).
     *
     * <p>DIGIT_name: Hauptuntersuchung</p>
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
