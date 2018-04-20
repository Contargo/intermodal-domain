package digit.domain.masterData.loadingUnit;

/**
 * Trailer vehicle which has no front axle so a substantial part of its total weight is transferred to a tractor unit.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Sattelanhänger
 * @DIGIT_english  semi trailer
 * @DIGIT_synonym  Sattelauflieger, Trailer
 * @DIGIT_definition  Anhängerfahrzeug, bei dem anstelle der bei Gelenk-Deichselanhägern vorhandenen ersten Achse eine
 *                    Sattelvorrichtung angeordnet ist und ein wesentlicher Teil seines Gesamtgewichts auf eine
 *                    Sattelzugmaschine übertragen wird. (@see DIN 70010:2001, 2.3 — modifiziert, „(siehe 1.2.2.3.2)
 *                    (auch Deichselachse (Dolly))“ gestrichen, Anmerkung 1 hinzugefügt)
 * @DIGIT_definition_english  Trailer vehicle which has no front axle so a substantial part of its total weight is
 *                            transferred to a tractor unit. (@see DIN 70010:2001, 2.3 — modified, „(see 1.2.2.3.2)
 *                            (auch Deichselachse (Dolly))“ gestrichen, Anmerkung 1 hinzugefügt)
 */
public class Trailer extends LoadingUnit {

    /**
     * e.g&#046; XL, ...
     */
    private String type;

    /**
     * in meter.
     */
    private double size;

    private boolean craneable;
}
