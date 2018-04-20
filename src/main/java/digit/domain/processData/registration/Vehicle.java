package digit.domain.processData.registration;

import digit.domain.masterData.chassis.Chassis;
import digit.domain.masterData.person.Driver;
import digit.domain.masterData.truck.Truck;

import digit.domain.processData.loadingUnit.Order;

import java.util.Date;


/**
 * Describes the registration of road vehicles on a handling point by connecting vehicle,
 * {@link digit.domain.masterData.person.Driver Person} and {@link digit.domain.processData.loadingUnit.Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @DIGIT_name  Anmeldung Fahrzeug
 * @DIGIT_name_english  registration vehicle
 * @DIGIT_definition  Die Beschreibung der Anmeldung von Straßenfahrzeugen an Umschlagpunkten durch die Verknüpfungen
 *                    von Fahrzeug, Person und Auftrag wird hier dargestellt. Die Gruppe hat sowohl für die Anlieferung
 *                    von LE Gültigkeit als auch für die Abholung von LE an einem Umschlagknoten.
 * @DIGIT_definition_english  Describes the registration of road vehicles on a handling point by connecting vehicle,
 *                            {@link digit.domain.masterData.person.Driver Person} and
 *                            {@link digit.domain.processData.loadingUnit.Order}. It is valid for the delivery of
 *                            loading units as well as for the pick up of an loading unit on a handling point.
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
