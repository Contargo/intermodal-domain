package api.processing;

import api.loadingUnit.Order;

import api.person.Person;
import api.person.Skipper;

import java.util.Date;
import java.util.List;


/**
 * Contains information necessary for loading and discharging of barges like properties of the barge, relevant persons
 * and timetables as well as information about its load and necessary documents.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Barge {

    private api.vehicle.Barge barge;

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

    // TODO - type: Eignung, falls [Abfertigung.Barge.Kegel] > 0?
    private Object adnr;

    private List<Order> loadingListLUOrder;

    private StoragePosition loadingListStoragePosition;
}
