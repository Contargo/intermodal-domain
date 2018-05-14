package net.contargo.intermodal.domain;

import net.contargo.intermodal.domain.meansOfTransport.Truck;
import net.contargo.intermodal.domain.utility.ISO8601DateFormatter;

import java.util.Date;

import javax.validation.constraints.NotNull;


/**
 * Describes the registration of road vehicles on a handling point by connecting vehicle, {@link Driver Person} and
 * {@link LUOrder}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Anmeldung Fahrzeug
 * @name_english  registration vehicle
 * @definition_german  Die Beschreibung der Anmeldung von Straßenfahrzeugen an Umschlagpunkten durch die Verknüpfungen
 *                     von Fahrzeug, Person und Auftrag wird hier dargestellt. Die Gruppe hat sowohl für die
 *                     Anlieferung von LE Gültigkeit als auch für die Abholung von LE an einem Umschlagknoten.
 * @definition_english  Describes the registration of road vehicles on a handling point by connecting vehicle,
 *                      {@link Driver Person} and {@link LUOrder}. It is valid for the delivery of loading units as
 *                      well as for the pick up of an loading unit on a handling point.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class RegistrationVehicle {

    @NotNull(message = "truck is part of minimum requirement")
    private Truck truck;

    private Chassis chassis;

    @NotNull(message = "driver is part of minimum requirement")
    private Driver driver;

    @NotNull(message = "haulierClient is part of minimum requirement")
    private String haulierClient;

    @NotNull(message = "haulierRealizing is part of minimum requirement")
    private String haulierRealizing;

    /**
     * Format: ISO 8601 inclusive UTC
     */
    @NotNull(message = "deliveryTime is part of minimum requirement")
    private String deliveryTime;

    @NotNull(message = "luOrder is part of minimum requirement")
    private LUOrder luOrder;

    public Truck getTruck() {

        return truck;
    }


    public Chassis getChassis() {

        return chassis;
    }


    public Driver getDriver() {

        return driver;
    }


    public String getHaulierClient() {

        return haulierClient;
    }


    public String getHaulierRealizing() {

        return haulierRealizing;
    }


    public String getDeliveryTime() {

        return deliveryTime;
    }


    public LUOrder getLuOrder() {

        return luOrder;
    }

    public static final class Builder {

        private Truck truck;
        private Chassis chassis;
        private Driver driver;
        private String haulierClient;
        private String haulierRealizing;
        private String deliveryTime;
        private LUOrder luOrder;

        private Builder() {
        }

        public static Builder newRegistrationVehicle() {

            return new Builder();
        }


        public Builder withTruck(Truck truck) {

            this.truck = truck;

            return this;
        }


        public Builder withChassis(Chassis chassis) {

            this.chassis = chassis;

            return this;
        }


        public Builder withDriver(Driver driver) {

            this.driver = driver;

            return this;
        }


        public Builder withHaulierClient(String haulierClient) {

            this.haulierClient = haulierClient;

            return this;
        }


        public Builder withHaulierRealizing(String haulierRealizing) {

            this.haulierRealizing = haulierRealizing;

            return this;
        }


        public Builder withDeliveryTime(int year, int month, int day, int hour, int minute) {

            this.deliveryTime = ISO8601DateFormatter.format(year, month, day, hour, minute);

            return this;
        }


        public Builder withLuOrder(LUOrder LuOrder) {

            this.luOrder = luOrder;

            return this;
        }


        public RegistrationVehicle build() {

            RegistrationVehicle registrationVehicle = new RegistrationVehicle();
            registrationVehicle.haulierClient = this.haulierClient;
            registrationVehicle.chassis = this.chassis;
            registrationVehicle.deliveryTime = this.deliveryTime;
            registrationVehicle.truck = this.truck;
            registrationVehicle.luOrder = this.luOrder;
            registrationVehicle.haulierRealizing = this.haulierRealizing;
            registrationVehicle.driver = this.driver;

            return registrationVehicle;
        }


        public RegistrationVehicle buildAndValidate() {

            RegistrationVehicle registrationVehicle = this.build();

            Validator.validate(registrationVehicle);

            return registrationVehicle;
        }
    }
}
