package api.transport;

/**
 * Status of mean of transport for communication between agents.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class MeansOfTransportationStatus {

    private String atd;

    private String eta;

    private String ata;

    // TODO - type: Bereitstellung / Bearbeitungsstart
    private String handlingStart;

    // TODO - type: Ladeschluss
    private String handlingEnd;

    // TODO
    private String waggongTechnicalInspection;
}
