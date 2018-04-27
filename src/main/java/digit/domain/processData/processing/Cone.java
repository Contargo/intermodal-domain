package digit.domain.processData.processing;

/**
 * Number of cones a barge has to carry to indicate its dangerous goods.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Kegel
 * @name_english  cone
 * @definition_german  Das Datenfeld, welches Informationen zu Kegeln beinhaltet, wird insbesondere für die
 *                     Rheinschifffahrt benötigt. Grund dafür sind gesetzliche Vorschriften, die durch blaue Kegel eine
 *                     besondere Kennzeichnung von gefährlichen Ladungen erfordern. Je nach Kegelanzahl gibt es
 *                     spezielle Anforderungen an operative Prozesse.
 * @definition_english  This information is needed especially for shipping on the Rhine because of regulations which
 *                      require the indication of dangerous loads through blue cones. Depending on the number of cones
 *                      there are different requirements for operative processes.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public enum Cone {

    ONE,
    TWO,
    THREE
}
