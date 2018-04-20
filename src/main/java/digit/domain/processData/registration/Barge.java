package digit.domain.processData.registration;

import digit.domain.masterData.dangerousGoods.DangerousGoods;

import java.util.Date;


/**
 * Contains data for registration of {@link digit.domain.masterData.barge.Barge barges} on handling points by
 * connecting barge, schedule and quantity information.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Anmeldung Binnenschiff
 * @DIGIT_english  registration barge
 * @DIGIT_definition  Enthält Daten für die Anmeldung von {@link digit.domain.masterData.barge.Barge Binnenschiffen} an
 *                    Umschlagpunkten durch die Verknüpfung der Binnenschiffdaten mit Zeitplänen und Mengen.
 * @DIGIT_definition_english  Contains data for registration of {@link digit.domain.masterData.barge.Barge barges} on
 *                            handling points by connecting barge, schedule and quantity information.
 */
public class Barge {

    private digit.domain.masterData.barge.Barge barge;

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
