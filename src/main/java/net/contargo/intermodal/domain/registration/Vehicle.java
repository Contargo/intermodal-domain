package net.contargo.intermodal.domain.registration;

import net.contargo.intermodal.domain.loadingUnit.Order;
import net.contargo.intermodal.domain.meansOfTransport.Chassis;
import net.contargo.intermodal.domain.meansOfTransport.Truck;
import net.contargo.intermodal.domain.person.Driver;

import java.util.Date;


/**
 * Describes the registration of road vehicles on a handling point by connecting vehicle,
 * {@link net.contargo.intermodal.domain.person.Driver Person} and
 * {@link net.contargo.intermodal.domain.loadingUnit.Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Anmeldung Fahrzeug
 * @name_english  registration vehicle
 * @definition_german  Die Beschreibung der Anmeldung von Straßenfahrzeugen an Umschlagpunkten durch die Verknüpfungen
 *                     von Fahrzeug, Person und Auftrag wird hier dargestellt. Die Gruppe hat sowohl für die
 *                     Anlieferung von LE Gültigkeit als auch für die Abholung von LE an einem Umschlagknoten.
 * @definition_english  Describes the registration of road vehicles on a handling point by connecting vehicle,
 *                      {@link net.contargo.intermodal.domain.person.Driver Person} and
 *                      {@link net.contargo.intermodal.domain.loadingUnit.Order}. It is valid for the delivery of
 *                      loading units as well as for the pick up of an loading unit on a handling point.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Vehicle {

    private Truck truck;

    private Chassis chassis;

    private Driver driver;

    private String haulierClient;

    private String haulierRealizing;

    /**
     * Format: ISO 8601 inclusive UTC
     */
    private Date deliveryTime;

    private Order luOrder;
}