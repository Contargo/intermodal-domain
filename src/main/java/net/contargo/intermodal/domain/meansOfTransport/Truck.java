package net.contargo.intermodal.domain.meansOfTransport;

import net.contargo.intermodal.domain.meansOfTransport.EnvironmentBadge;
import net.contargo.intermodal.domain.meansOfTransport.MeansOfTransport;

import java.util.Date;


/**
 * Commercial vehicle which is mostly or exclusively used for carrying trailed vehicles.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Zugmaschine
 * @name_english  truck
 * @definition_german  Nutzkraftwagen, der ausschließlich oder überwiegend zum Mitführen von Anhängerfahrzeugen
 *                     bestimmt ist. (@see DIN 70010:2001-04, 1.2.2.3)
 * @definition_english  Commercial vehicle which is mostly or exclusively used for carrying trailed vehicles. (@see DIN
 *                      70010:2001-04, 1.2.2.3)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Truck implements MeansOfTransport {

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
     * <p>Format: DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).</p>
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
