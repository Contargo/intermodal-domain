package api.processData.processing;

import api.masterData.person.Person;
import api.masterData.person.Skipper;

import api.processData.loadingUnit.Order;

import java.util.Date;
import java.util.List;


/**
 * Contains information necessary for loading and discharging of a {@link api.masterData.vehicle.Barge} like properties
 * of the barge, relevant persons and timetables as well as information about its load and necessary documents.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private api.masterData.vehicle.Barge barge;

    /**
     * Estimated Time of Arrival (Format: ISO 8601 incl. UTC)
     */
    private Date eta;

    /**
     * Estimated Time of Departure (Format: ISO 8601 incl. UTC)
     */
    private Date etd;

    private Skipper skipper;

    private List<Person> passenger;

    private int reeferConnections;

    private ConeNumber cone;

    /**
     * ADNR (fr: Accord europèen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 incl.) UTC.
     */
    private boolean adnr;

    private List<Order> loadingListLUOrder;

    private StoragePosition loadingListStoragePosition;
}
