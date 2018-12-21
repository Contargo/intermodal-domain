package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

import javax.validation.constraints.NotNull;


/**
 * Pick up of an {@link Transport}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Abholung
 * @name_english  pick up
 * @minimum_requirement  location with city and designation, earliest, mot
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class PickUp {

    @NotNull(message = "location is part of minimum requirement and must not be null")
    @LocationConstraint(message = "location city and designation are part of the minimum requirement of pickUp")
    private Location location;

    private Transport.LoadingUnit loadingUnit = new Transport.LoadingUnit();

    /**
     * @definition_german  Abrechnungsreferenz, PO-number für Dienstleister
     */
    private String billingReference;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    @NotNull(message = "earliest is part of minimum requirement and must not be null")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant earliest;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant latest;

    @NotNull(message = "mot is part of minimum requirement and must not be null")
    @JsonProperty("mot")
    private MeansOfTransport mot;

    PickUp() {

        // OK
    }

    /**
     * Creates a new builder for {@link PickUp}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link PickUp}.
     *
     * @param  pickUp  that should be copied.
     *
     * @return  new builder with values of given pickUp.
     */
    public static Builder newBuilder(PickUp pickUp) {

        return new Builder().withLocation(pickUp.getLocation())
            .withLoadingUnit(pickUp.getLoadingUnit())
            .withBillingReference(pickUp.getBillingReference())
            .withEarliest(pickUp.getEarliest())
            .withLatest(pickUp.getLatest())
            .withMeansOfTransport(pickUp.getMeansOfTransport());
    }


    public static ILocation newStepBuilder() {

        return new StepBuilder();
    }


    public String getBillingReference() {

        return billingReference;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getEarliest() {

        return earliest;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getLatest() {

        return latest;
    }


    @JsonIgnore
    public MeansOfTransport getMeansOfTransport() {

        return mot;
    }


    public Location getLocation() {

        return location;
    }


    public Transport.LoadingUnit getLoadingUnit() {

        return loadingUnit;
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

        PickUp build();


        PickUp buildAndValidate();


        IBuild withLatest(Instant latest);


        IBuild withBillingReference(String billingReference);


        IBuild withLoadingUnit(String reference, Boolean isEmpty);


        IBuild withLoadingUnitOperator(Operator operator);
    }

    public interface IMot {

        IBuild withMeansOfTransport(MeansOfTransport meansOfTransport);
    }

    public interface IEarliest {

        IMot withEarliest(Instant earliest);
    }

    public interface ILocation {

        IEarliest withLocation(Location location);
    }

    public static final class Builder {

        private Location location;
        private Transport.LoadingUnit loadingUnit = new Transport.LoadingUnit();
        private String billingReference;
        private Instant earliest;
        private Instant latest;
        private MeansOfTransport mot;

        private Builder() {
        }

        public Builder withLocation(Location location) {

            this.location = location;

            return this;
        }


        public Builder withLoadingUnit(String reference, Boolean isEmpty) {

            this.loadingUnit.setEmpty(isEmpty);
            this.loadingUnit.setReference(reference);

            return this;
        }


        Builder withLoadingUnit(Transport.LoadingUnit loadingUnit) {

            this.loadingUnit = loadingUnit;

            return this;
        }


        public Builder withLoadingUnitOperator(Operator operator) {

            this.loadingUnit.setOperator(operator);

            return this;
        }


        public Builder withBillingReference(String billingReference) {

            this.billingReference = billingReference;

            return this;
        }


        public Builder withEarliest(Instant instant) {

            this.earliest = instant;

            return this;
        }


        public Builder withLatest(Instant instant) {

            this.latest = instant;

            return this;
        }


        public Builder withMeansOfTransport(MeansOfTransport mot) {

            this.mot = mot;

            return this;
        }


        /**
         * Builds {@link PickUp} without input validation.
         *
         * @return  new {@link PickUp} with attributes specified in {@link Builder}
         */
        public PickUp build() {

            PickUp pickUp = new PickUp();
            pickUp.location = this.location;
            pickUp.loadingUnit = this.loadingUnit;
            pickUp.billingReference = this.billingReference;
            pickUp.earliest = this.earliest;
            pickUp.latest = this.latest;
            pickUp.mot = this.mot;

            return pickUp;
        }


        /**
         * Validates the input and builds {@link PickUp}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link PickUp}.
         *
         * @return  new {@link PickUp} with attributes specified in {@link Builder}
         */
        public PickUp buildAndValidate() {

            PickUp pickUp = this.build();

            MinimumRequirementValidator.validate(pickUp);

            return pickUp;
        }
    }

    public static final class StepBuilder implements IMot, IEarliest, ILocation, IBuild {

        @NotNull(message = "mot is part of minimum requirement and must not be null")
        private MeansOfTransport mot;
        private Instant latest;
        @NotNull(message = "earliest is part of minimum requirement and must not be null")
        private Instant earliest;
        private String billingReference;
        private Transport.LoadingUnit loadingUnit = new Transport.LoadingUnit();
        @NotNull(message = "location is part of minimum requirement and must not be null")
        private Location location;

        private StepBuilder() {
        }

        @Override
        public IBuild withMeansOfTransport(MeansOfTransport meansOfTransport) {

            mot = meansOfTransport;

            return this;
        }


        @Override
        public IBuild withLatest(Instant latest) {

            this.latest = latest;

            return this;
        }


        @Override
        public IMot withEarliest(Instant earliest) {

            this.earliest = earliest;

            return this;
        }


        @Override
        public IBuild withBillingReference(String billingReference) {

            this.billingReference = billingReference;

            return this;
        }


        @Override
        public IBuild withLoadingUnit(String reference, Boolean isEmpty) {

            this.loadingUnit.setEmpty(isEmpty);
            this.loadingUnit.setReference(reference);

            return this;
        }


        @Override
        public IBuild withLoadingUnitOperator(Operator operator) {

            this.loadingUnit.setOperator(operator);

            return this;
        }


        @Override
        public IEarliest withLocation(Location location) {

            this.location = location;

            return this;
        }


        /**
         * Builds {@link PickUp} without input validation.
         *
         * @return  new {@link PickUp} with attributes specified in {@link Builder}
         */
        @Override
        public PickUp build() {

            PickUp pickUp = new PickUp();
            pickUp.location = this.location;
            pickUp.loadingUnit = this.loadingUnit;
            pickUp.billingReference = this.billingReference;
            pickUp.earliest = this.earliest;
            pickUp.latest = this.latest;
            pickUp.mot = this.mot;

            return pickUp;
        }


        /**
         * Validates the input and builds {@link PickUp}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link PickUp}.
         *
         * @return  new {@link PickUp} with attributes specified in {@link Builder}
         */
        @Override
        public PickUp buildAndValidate() {

            PickUp pickUp = this.build();

            MinimumRequirementValidator.validate(pickUp);

            return pickUp;
        }
    }
}
