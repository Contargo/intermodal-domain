package api.processData.registration;

import api.masterData.dangerousGoods.DangerousGoods;

import java.util.Date;


/**
 * Contains data for registration of {@link api.masterData.barge.Barge barges} on handling points by connecting barge,
 * schedule and quantity information.
 *
 * <p>DIGIT_name: Anmeldung Binnenschiff</p>
 *
 * <p>DIGIT_english: registration barge</p>
 *
 * <p>DIGIT_definition: Enthält Daten für die Anmeldung von {@link api.masterData.barge.Barge Binnenschiffen} an
 * Umschlagpunkten durch die Verknüpfung der Binnenschiffdaten mit Zeitplänen und Mengen.</p>
 *
 * <p>DIGIT_definition_english: Contains data for registration of {@link api.masterData.barge.Barge barges} on handling
 * points by connecting barge, schedule and quantity information.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private api.masterData.barge.Barge barge;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private Date eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    private Date etd;

    /**
     * Value is optional and can be null.
     */
    private DangerousGoods dangerousGoodsIndication;

    /**
     * Number of LUs.
     */
    private int volumeToDischarge;

    /**
     * Number of LUs.
     */
    private int volumeToLoad;
}
