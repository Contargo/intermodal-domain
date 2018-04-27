package digit.domain.masterData.customs;

/**
 * Group of data necessary for customs proceedings.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @DIGIT_name_german  Zolldaten
 * @DIGIT_name_english  customs
 * @DIGIT_definition_german  Gruppe der Daten, die für Zollverfahren notwendig sind bzw. während der Zollverfahren
 *                           anfallen.
 * @DIGIT_definition_english  Group of data necessary for customs proceedings.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Customs {

    /**
     * e.g&#046; T1, EX, GW.
     */
    private String customProcess;

    /**
     * e.g&#046; MNR.
     */
    private String customDocumentNumber;

    private String seal;
}
