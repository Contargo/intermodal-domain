package api.masterData.loadingUnit;

/**
 * Trailer vehicle which has no front axle, so a substantial part of its total weight is transferred to a tractor unit.
 *
 * <p>DIGIT_name: Sattelanhänger</p>
 *
 * <p>DIGIT_english: semi trailer</p>
 *
 * <p>DIGIT_synonym: Sattelauflieger, Trailer</p>
 *
 * <p>DIGIT_definition: Anhängerfahrzeug, bei dem anstelle der bei Gelenk-Deichselanhägern vorhandenen ersten Achse
 * eine Sattelvorrichtung angeordnet ist und ein wesentlicher Teil seines Gesamtgewichts auf eine Sattelzugmaschine
 * übertragen wird. (@see DIN 70010:2001, 2.3 — modifiziert, „(siehe 1.2.2.3.2) (auch Deichselachse (Dolly))“
 * gestrichen, Anmerkung 1 hinzugefügt)</p>
 *
 * <p>DIGIT_definition_english: Trailer vehicle which has no front axle, so a substantial part of its total weight is
 * transferred to a tractor unit.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Trailer extends LoadingUnit {

    /**
     * e.g. XL, ...
     */
    private String type;

    /**
     * in meter.
     */
    private double size;

    private boolean craneable;
}
