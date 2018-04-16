package api.statusData;

import java.util.Date;


/**
 * Status of means of transport for communication flow of intermodal freight transport.
 *
 * <p>DIGIT_name: Verkehrsmittelstatus</p>
 *
 * <p>DIGIT_english: means of transportation status</p>
 *
 * <p>DIGIT_definition: Verkehrsmittelstatus für den Informationsfluss in der intermodalen Kette. Über den
 * Verkehrsmittelstatus und den {@link api.statusData.StatusLU Ladeeinheitenstatus} kann ein reibungsloser Austausch
 * zwischen den Akteuren sichergestellt werden. Prinzipiell sollten die beiden Status als Paket verstanden werden. Die
 * Kerndaten sind jeweils immer gleich und werden durch den jeweiligen Status konkretisiert. Dabei gibt es zwei Blöcke
 * pro Statuspaket. Zum einen die Identifikation des Handelnden inklusive Begleitinformationen und zum anderen die
 * Konkretisierung was genau zu welchem Zeitpunkt passiert. Begleitinformationen beim Verkehrsmittel betreffen die
 * Transportrelation.</p>
 *
 * <p>DIGIT_definition_english: Status of means of transport for communication flow of intermodal freight transport.
 * The means of transportation status and {@link api.statusData.StatusLU loading unit status} ensure a fluent exchange
 * between actors. Both statuses should be seen as package. Their core data is similar and is concretized by their
 * status. There are two blocks per status package. On one hand the identification of the doer on the other hand the
 * schedule of the different operational steps.</p>
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class MeansOfTransportationStatus {

    /**
     * Actual Time of Departure (Format: ISO 8601 incl. UTC)
     */
    private Date atd;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date eta;

    /**
     * Actual Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date ata;

    /**
     * Actual Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date handlingStart;

    /**
     * Actual Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date handlingEnd;

    private int waggonTechnicalInspection;
}
