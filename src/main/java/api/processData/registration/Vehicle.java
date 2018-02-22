package api.processData.registration;

import api.masterData.person.Driver;

import api.masterData.vehicle.Chassis;
import api.masterData.vehicle.Truck;

import api.processData.loadingUnit.Order;

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
