package api.masterData.customs;

/**
 * Group of data necessary for customs proceedings.
 *
 * <p>DIGIT_name: Zolldaten</p>
 *
 * <p>DIGIT_english: customs</p>
 *
 * <p>DIGIT_definition: Gruppe der Daten, die für Zollverfahren notwendig sind bzw. während der Zollverfahren
 * anfallen.</p>
 *
 * <p>DIGIT_definition_english: Group of data necessary for customs proceedings.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Customs {

    /**
     * e.g. T1, EX, GW.
     */
    private String customProcess;

    /**
     * e.g. MNR.
     */
    private String customDocumentNumber;

    private String seal;
}
