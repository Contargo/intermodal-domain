package api.masterData.customs;

/**
 * Group of data necessary for customs proceedings.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Zolldaten
 * @DIGIT_english  customs
 * @DIGIT_definition  Gruppe der Daten, die für Zollverfahren notwendig sind bzw. während der Zollverfahren anfallen.
 * @DIGIT_definition_english  Group of data necessary for customs proceedings.
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
