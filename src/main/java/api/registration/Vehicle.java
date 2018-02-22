package api.registration;

import api.loadingUnit.Order;

import api.person.Driver;

import api.vehicle.Chassis;
import api.vehicle.Truck;

import java.util.Date;


/**
 * Contains information necessary for the registration of a vehicle.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Vehicle {

    private Truck truck;

    private Chassis chassis;

    private Driver driver;

    // TODO - type: (vgl. §7 c GüKG) („Sofa“)
    private Object haulierClient;

    // TODO - type: (vgl. §7 c GüKG) („Sub“)
    private Object haulierRealizing;

    /**
     * format: ISO 8601 incl. UTC
     */
    private Date deliveryTime;

    private Order luOrderPd;
}
