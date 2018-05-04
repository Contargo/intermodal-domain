package net.contargo.intermodal.domain.meansOfTransport;

import net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport;

import java.util.Date;


/**
 * Trailer to transport loading units.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Fahrgestell
 * @name_english  chassis
 * @definition_german  Anhänger zur Beförderung von Ladeeinheiten.
 * @definition_english  Trailer to transport loading units.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Chassis implements MeansOfTransport {

    /**
     * Format: spaces included.
     */
    private String numberPlate;

    /**
     * Ministry of Transport Test (Format: DateTime ISO 8601 inclusive UTC).
     *
     * @name_german  Hauptuntersuchung
     */
    private Date mot;

    /**
     * e.g&#046; Multichassis.
     */
    private String type;

    private Integer axles;

    /**
     * in meter.
     */
    private Double size;

    /**
     * in meter.
     */
    private Double height;

    private Boolean euAuthorization;

    /**
     * Safety test.
     *
     * @name_german  Sicherheitsprüfung
     */
    private Boolean st;

    private Boolean suitabilityDangerousGoods;

    private Boolean suitabilityWaste;

    private Boolean suitabilityReefer;

    /**
     * in kg.
     */
    private Double weightTara;
}
