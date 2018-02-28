package api.statusData;

/**
 * Status of mean of transport for communication between agents.
 *
 * <p>In german Verkehrsmittelstatus</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class MeansOfTransportationStatus {

    private String atd;

    private String eta;

    private String ata;

    // TODO - type: Bereitstellung / Bearbeitungsstart Date?
    private String handlingStart;

    // TODO - type: Ladeschluss Date?
    private String handlingEnd;

    // TODO
    private String waggonTechnicalInspection;
}
