package api.masterData.loadingUnit;

/**
 * Case for the transport of goods for the change to another mean of transport.
 *
 * <p>DIGIT_name: Container</p>
 *
 * <p>DIGIT_english: Container</p>
 *
 * <p>DIGIT_definition: Behälter für den Gütertransport für den Wechsel von einer zur anderen Transportform.</p>
 *
 * <p>DIGIT_definition_english: Case for the transport of goods for the change to another means of transport.</p>
 *
 * <p>DIGIT_annotation: Containertypen können Flat-, Open-Top-, High-Cube-, Bulk-, ISO-, Reefer- oder Tank-Container
 * sein. (@see DIN EN ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)</p>
 *
 * <p>DIGIT_annotation_english: Container types can be flat, open top, high cube, bulk, ISO, reefer- or tank
 * containers. (@see DIN EN ISO 17261:2012-12, 3.14 — modifiziert, Änderung der Anmerkung)</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
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
