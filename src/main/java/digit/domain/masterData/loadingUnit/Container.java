package digit.domain.masterData.loadingUnit;

/**
 * Case for the transport of goods for the change to another
 * {@link digit.domain.masterData.meansOfTransport.MeansOfTransport means of transport}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Container
 * @name_english  Container
 * @definition_german  Behälter für den Gütertransport für den Wechsel von einer zur anderen
 *                     {@link digit.domain.masterData.meansOfTransport.MeansOfTransport Transportform}.
 * @definition_english  Case for the transport of goods for the change to another
 *                      {@link digit.domain.masterData.meansOfTransport.MeansOfTransport means of transport}.
 * @note_german  Containertypen können Flat-, Open-Top-, High-Cube-, Bulk-, ISO-, Reefer- oder Tank-Container sein.
 *               (@see DIN EN ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)
 * @note_english  Container types can be flat, open top, high cube, bulk, ISO, reefer- or tank containers. (@see DIN EN
 *                ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Container extends LoadingUnit {

    /**
     * ISO 6346 Container Size Type e.g. 20G0 for GENERAL PURPOSE CONTAINERS
     */
    private String sizeType;

    /**
     * e.g. flat, open top, high cube, bulk, ISO, reefer- or tank containers.
     */
    private String type;

    /**
     * in foot.
     */
    private int size;
}
