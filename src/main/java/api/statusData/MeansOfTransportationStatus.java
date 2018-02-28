package api.statusData;

import java.util.Date;


/**
 * Status of mean of transport for communication between agents.
 *
 * <p>In german Verkehrsmittelstatus</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class MeansOfTransportationStatus {

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date atd;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date eta;

    private String ata;

    // TODO - type: Bereitstellung / Bearbeitungsstart Date?
    private String handlingStart;

    // TODO - type: Ladeschluss Date?
    private String handlingEnd;

    // TODO
    private String waggonTechnicalInspection;
}
