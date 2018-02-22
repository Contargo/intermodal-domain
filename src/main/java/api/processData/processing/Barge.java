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
     * format: yyyy-MM-dd'T'HH:mm:ss.SSSX
     */
    private Object eta;

    /**
     * format: yyyy-MM-dd'T'HH:mm:ss.SSSX
     */
    private Date etd;

    private Skipper skipper;

    private List<Person> passenger;

    private int reeferConnections;

    private ConeNumber cone;

    private boolean adnr;

    private List<Order> loadingListLUOrder;

    private StoragePosition loadingListStoragePosition;
}
