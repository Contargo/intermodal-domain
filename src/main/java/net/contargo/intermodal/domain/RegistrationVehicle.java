package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

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
 * @minimum_requirement  truck, driver, haulierClient, haulierRealizing, deliveryTime, luOrder
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class RegistrationVehicle {

    @NotNull(message = "truck is part of minimum requirement and must not be null")
    private Truck truck;

    private Chassis chassis;

    @NotNull(message = "driver is part of minimum requirement and must not be null")
    private Driver driver;

    @NotNull(message = "haulierClient is part of minimum requirement and must not be null")
    private String haulierClient;

    @NotNull(message = "haulierRealizing is part of minimum requirement and must not be null")
    private String haulierRealizing;

    /**
     * Format: ISO 8601 inclusive UTC
     */
    @NotNull(message = "deliveryTime is part of minimum requirement and must not be null")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant deliveryTime;

    @NotNull(message = "luOrder is part of minimum requirement and must not be null")
    private LUOrder luOrder;

    private RegistrationVehicle() {

        // OK
    }

    /**
     * Creates a new builder for {@link RegistrationVehicle}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link RegistrationVehicle}.
     *
     * @param  registrationVehicle  that should be copied.
     *
     * @return  new builder with values of given registrationVehicle.
     */
    public static Builder newBuilder(RegistrationVehicle registrationVehicle) {

        return new Builder().withHaulierClient(registrationVehicle.getHaulierClient())
            .withChassis(registrationVehicle.getChassis())
            .withDeliveryTime(registrationVehicle.getDeliveryTime())
            .withTruck(registrationVehicle.getTruck())
            .withLuOrder(registrationVehicle.getLuOrder())
            .withHaulierRealizing(registrationVehicle.getHaulierRealizing())
            .withDriver(registrationVehicle.getDriver());
    }


    /**
     * Starts a new step builder pattern for {@link RegistrationVehicle}. Other than the normal {@link Builder} the
     * {@link StepBuilder} will enforce the order in which fields are set to make sure the minimum requirements are
     * fulfilled.
     *
     * @return  ITruck
     */
    public static ITruck newStepBuilder() {

        return new StepBuilder();
    }


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


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getDeliveryTime() {

        return deliveryTime;
    }


    public LUOrder getLuOrder() {

        return luOrder;
    }


    @Override
    public String toString() {

        try {
            return this.getClass().getSimpleName() + ": " + JsonStringMapper.map(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }

    public interface IBuild {

        RegistrationVehicle build();


        RegistrationVehicle buildAndValidate();


        IBuild withChassis(Chassis chassis);
    }

    public interface ILuOrder {

        IBuild withLuOrder(LUOrder luOrder);
    }

    public interface IDeliveryTime {

        ILuOrder withDeliveryTime(Instant deliveryTime);
    }

    public interface IHaulierRealizing {

        IDeliveryTime withHaulierRealizing(String haulierRealizing);
    }

    public interface IHaulierClient {

        IHaulierRealizing withHaulierClient(String haulierClient);
    }

    public interface IDriver {

        IHaulierClient withDriver(Driver driver);
    }

    public interface ITruck {

        IDriver withTruck(Truck truck);
    }

    public static final class Builder {

        private Truck truck;
        private Chassis chassis;
        private Driver driver;
        private String haulierClient;
        private String haulierRealizing;
        private Instant deliveryTime;
        private LUOrder luOrder;

        private Builder() {
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


        public Builder withDeliveryTime(Instant instant) {

            this.deliveryTime = instant;

            return this;
        }


        public Builder withLuOrder(LUOrder luOrder) {

            this.luOrder = luOrder;

            return this;
        }


        /**
         * Builds {@link RegistrationVehicle} without input validation.
         *
         * @return  new {@link RegistrationVehicle} with attributes specified in {@link Builder}
         */
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


        /**
         * Validates the input and builds {@link RegistrationVehicle}. Throws IllegalStateException if input doesn't
         * fulfill the minimum requirement of {@link RegistrationVehicle}.
         *
         * @return  new {@link RegistrationVehicle} with attributes specified in {@link Builder}
         */
        public RegistrationVehicle buildAndValidate() {

            RegistrationVehicle registrationVehicle = this.build();

            MinimumRequirementValidator.validate(registrationVehicle);

            return registrationVehicle;
        }
    }

    public static final class StepBuilder implements ILuOrder, IDeliveryTime, IHaulierRealizing, IHaulierClient,
        IDriver, ITruck, IBuild {

        @NotNull(message = "luOrder is part of minimum requirement and must not be null")
        private LUOrder luOrder;
        @NotNull(message = "deliveryTime is part of minimum requirement and must not be null")
        private Instant deliveryTime;
        @NotNull(message = "haulierRealizing is part of minimum requirement and must not be null")
        private String haulierRealizing;
        @NotNull(message = "haulierClient is part of minimum requirement and must not be null")
        private String haulierClient;
        @NotNull(message = "driver is part of minimum requirement and must not be null")
        private Driver driver;
        private Chassis chassis;
        @NotNull(message = "truck is part of minimum requirement and must not be null")
        private Truck truck;

        private StepBuilder() {
        }

        @Override
        public IBuild withLuOrder(LUOrder val) {

            luOrder = val;

            return this;
        }


        @Override
        public ILuOrder withDeliveryTime(Instant val) {

            deliveryTime = val;

            return this;
        }


        @Override
        public IDeliveryTime withHaulierRealizing(String val) {

            haulierRealizing = val;

            return this;
        }


        @Override
        public IHaulierRealizing withHaulierClient(String val) {

            haulierClient = val;

            return this;
        }


        @Override
        public IHaulierClient withDriver(Driver val) {

            driver = val;

            return this;
        }


        @Override
        public IBuild withChassis(Chassis val) {

            chassis = val;

            return this;
        }


        @Override
        public IDriver withTruck(Truck val) {

            truck = val;

            return this;
        }


        /**
         * Builds {@link RegistrationVehicle} without input validation.
         *
         * @return  new {@link RegistrationVehicle} with attributes specified in {@link Builder}
         */
        @Override
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


        /**
         * Validates the input and builds {@link RegistrationVehicle}. Throws IllegalStateException if input doesn't
         * fulfill the minimum requirement of {@link RegistrationVehicle}.
         *
         * @return  new {@link RegistrationVehicle} with attributes specified in {@link Builder}
         */
        @Override
        public RegistrationVehicle buildAndValidate() {

            RegistrationVehicle registrationVehicle = this.build();

            MinimumRequirementValidator.validate(registrationVehicle);

            return registrationVehicle;
        }
    }
}
