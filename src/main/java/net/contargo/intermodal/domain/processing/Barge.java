package net.contargo.intermodal.domain.processing;

import net.contargo.intermodal.domain.loadingUnit.Order;
import net.contargo.intermodal.domain.person.Person;
import net.contargo.intermodal.domain.person.Skipper;

import java.util.Date;
import java.util.List;


/**
 * Contains data the data necessary for processing of loading and discharging
 * {@link net.contargo.intermodal.domain.meansOfTransport.Barge barges}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Abfertigung Binnenschiff
 * @name_english  processing barge
 * @definition_german  Nach erfolgreicher Anmeldung kommt es zur Abfertigung der Verkehrsmittel im Umschlagpunkt. In
 *                     dieser Gruppe werden die Daten, die für die Abwicklung der Be- und Entladungsvorgänge am
 *                     Binnenschiff notwendig sind, zusammengefasst. Die Prozesse werden durch die Verknüpfung von
 *                     Eigenschaften des {@link net.contargo.intermodal.domain.meansOfTransport.Barge Binnenschiffs},
 *                     relevanten {@link net.contargo.intermodal.domain.person.Person Personen}, Fahrplänen sowie
 *                     Beladungen und nötigen Dokumenteninformationen dargestellt.
 * @definition_english  After successful registration the means of transport is processed on the handling point. In
 *                      this class the data necessary for processing of loading and discharging barges is summarized.
 *                      The processes are described by connecting properties of the
 *                      {@link net.contargo.intermodal.domain.meansOfTransport.Barge}, relevant
 *                      {@link net.contargo.intermodal.domain.person.Person Persons} and schedules as well as loads and
 *                      necessary document information.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Barge {

    private net.contargo.intermodal.domain.meansOfTransport.Barge barge;

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

    private Integer reeferConnections;

    private Cone cone;

    /**
     * ADNR (fr: Accord europèen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 inclusive) UTC.
     */
    private Boolean adnr;

    private List<Order> loadingListLUOrder;

    private StoragePosition loadingListStoragePosition;
}
