package api.processData.registration;

import api.masterData.chassis.Chassis;

import api.masterData.person.Driver;

import api.masterData.truck.Truck;

import api.processData.loadingUnit.Order;

import java.util.Date;


/**
 * Describes the registration of road vehicles on a handling point by connecting vehicle,
 * {@link api.masterData.person.Driver Person} and {@link api.processData.loadingUnit.Order}.
 *
 * <p>DIGIT_name: Anmeldung Fahrzeug</p>
 *
 * <p>DIGIT_english: registration vehicle</p>
 *
 * <p>DIGIT_definition: Die Beschreibung der Anmeldung von Straßenfahrzeugen an Umschlagpunkten durch die Verknüpfungen
 * von Fahrzeug, Person und Auftrag wird hier dargestellt. Die Gruppe hat sowohl für die Anlieferung von LE Gültigkeit
 * als auch für die Abholung von LE an einem Umschlagknoten.</p>
 *
 * <p>DIGIT_definition_english: Describes the registration of road vehicles on a handling point by connecting vehicle,
 * {@link api.masterData.person.Driver Person} and {@link api.processData.loadingUnit.Order}. It is valid for the
 * delivery of loading units as well as for the pick up of an loading unit on a handling point.</p>
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
