package net.contargo.intermodal.domain.registration;

import net.contargo.intermodal.domain.DangerousGoods;

import java.util.Date;


/**
 * Contains data for registration of {@link net.contargo.intermodal.domain.meansOfTransport.Barge barges} on handling
 * points by connecting barge, schedule and quantity information.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Anmeldung Binnenschiff
 * @name_english  registration barge
 * @definition_german  Enthält Daten für die Anmeldung von
 *                     {@link net.contargo.intermodal.domain.meansOfTransport.Barge Binnenschiffen} an Umschlagpunkten
 *                     durch die Verknüpfung der Binnenschiffdaten mit Zeitplänen und Mengen.
 * @definition_english  Contains data for registration of
 *                      {@link net.contargo.intermodal.domain.meansOfTransport.Barge barges} on handling points by
 *                      connecting barge, schedule and quantity information.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Barge {

    private net.contargo.intermodal.domain.meansOfTransport.Barge barge;

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
