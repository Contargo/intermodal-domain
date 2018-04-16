package api.processData.processing;

/**
 * Number of cones a barge has to carry to indicate its dangerous goods.
 *
 * <p>DIGIT_name: Kegel</p>
 *
 * <p>DIGIT_english: cone</p>
 *
 * <p>DIGIT_definition: Das Datenfeld, welches Informationen zu Kegeln beinhaltet, wird insbesondere für die
 * Rheinschifffahrt benötigt. Grund dafür sind gesetzliche Vorschriften, die durch blaue Kegel eine besondere
 * Kennzeichnung von gefährlichen Ladungen erfordern. Je nach Kegelanzahl gibt es spezielle Anforderungen an operative
 * Prozesse.</p>
 *
 * <p>DIGIT_definition_english: This information is needed especially for shipping on the Rhine because of regulations
 * which require the indication of dangerous loads through blue cones. Depending on the number of cones there are
 * different requirements for operative processes.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public enum Cone {

    ONE,
    TWO,
    THREE
}
