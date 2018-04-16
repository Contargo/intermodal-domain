package api.processData.processing;

import api.masterData.person.Person;
import api.masterData.person.Skipper;

import api.processData.loadingUnit.Order;

import java.util.Date;
import java.util.List;


/**
 * Contains data the data necessary for processing of loading and discharging {@link api.masterData.barge.Barge barges}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Abfertigung Binnenschiff
 * @DIGIT_english  processing barge
 * @DIGIT_definition  Nach erfolgreicher Anmeldung kommt es zur Abfertigung der Verkehrsmittel im Umschlagpunkt. In
 *                    dieser Gruppe werden die Daten, die für die Abwicklung der Be- und Entladungsvorgänge am
 *                    Binnenschiff notwendig sind, zusammengefasst. Die Prozesse werden durch die Verknüpfung von
 *                    Eigenschaften des {@link api.masterData.barge.Barge Binnenschiffs}, relevanten
 *                    {@link api.masterData.person.Person Personen}, Fahrplänen sowie Beladungen und nötigen
 *                    Dokumenteninformationen dargestellt.
 * @DIGIT_definition_english  After successful registration the means of transport is processed on the handling point.
 *                            In this class the data necessary for processing of loading and discharging barges is
 *                            summarized. The processes are described by connecting properties of the
 *                            {@link api.masterData.barge.Barge}, relevant {@link api.masterData.person.Person Persons}
 *                            and schedules as well as loads and necessary document information.
 */
public class Barge {

    private api.masterData.barge.Barge barge;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 inclusive UTC)
     */
    private Date eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 inclusive UTC)
     */
    private Date etd;

    private Skipper skipper;

    private List<Person> passenger;

    private int reeferConnections;

    private Cone cone;

    /**
     * ADNR (fr: Accord europèen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 inclusive) UTC.
     */
    private boolean adnr;

    private List<Order> loadingListLUOrder;

    private StoragePosition loadingListStoragePosition;
}
