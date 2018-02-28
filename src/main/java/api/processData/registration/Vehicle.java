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

    private String haulierClient;

    private String haulierRealizing;

    /**
     * Format: ISO 8601 incl. UTC
     */
    private Date deliveryTime;

    private Order luOrder;
}
