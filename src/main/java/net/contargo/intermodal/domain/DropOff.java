package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

import javax.validation.constraints.NotNull;


/**
 * Drop off of an {@link Transport}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Anlieferung
 * @name_english  drop off
 * @minimum_requirement  location with city and designation, mot
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class DropOff {

    @NotNull(message = "location is part of minimum requirement and must not be null")
    @LocationConstraint(message = "location city and designation are part of the minimum requirement of dropOff")
    private Location location;

    private Transport.LoadingUnit loadingUnit = new Transport.LoadingUnit();

    /**
     * Abrechnungsreferenz, PO-number für Dienstl.
     */
    private String billingReference;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant earliest;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant latest;

    /**
     * @see  MeansOfTransport
     */
    @NotNull(message = "mot is part of minimum requirement and must not be null")
    private MeansOfTransport mot;

    DropOff() {

        // OK
    }


    private DropOff(StepBuilder builder) {

        location = builder.location;
        loadingUnit = builder.loadingUnit;
        billingReference = builder.billingReference;
        earliest = builder.earliest;
        latest = builder.latest;
        mot = builder.mot;
    }

    /**
     * Creates a new builder for {@link DropOff}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link DropOff}.
     *
     * @param  dropOff  that should be copied.
     *
     * @return  new builder with values of given dropOff.
     */
    public static Builder newBuilder(DropOff dropOff) {

        return new Builder().withLocation(dropOff.getLocation())
            .withLoadingUnit(dropOff.getLoadingUnit())
            .withBillingReference(dropOff.getBillingReference())
            .withEarliest(dropOff.getEarliest())
            .withLatest(dropOff.getLatest())
            .withMeansOfTransport(dropOff.getMot());
    }


    /**
     * Starts a new step builder pattern for {@link DropOff}. Other than the normal {@link Builder} the
     * {@link StepBuilder} will enforce the order in which fields are set to make sure the minimum requirements are
     * fulfilled.
     *
     * @return  ILoadingUnit
     */
    public static ILocation newStepBuilder() {

        return new StepBuilder();
    }


    public Location getLocation() {

        return location;
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


    public MeansOfTransport getMot() {

        return mot;
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

        DropOff build();


        DropOff buildAndValidate();


        IBuild withLatest(Instant latest);


        IBuild withEarliest(Instant earliest);


        IBuild withBillingReference(String billingReference);


        IBuild withLoadingUnit(String reference, Boolean isEmpty);


        IBuild withLoadingUnitOperator(Operator operator);
    }

    public interface ILocation {

        IMot withLocation(Location location);
    }

    public interface IMot {

        IBuild withMeansOfTransport(MeansOfTransport meansOfTransport);
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
         * Builds {@link DropOff} without input validation.
         *
         * @return  new {@link DropOff} with attributes specified in {@link Builder}
         */
        public DropOff build() {

            DropOff dropOff = new DropOff();
            dropOff.location = this.location;
            dropOff.loadingUnit = this.loadingUnit;
            dropOff.billingReference = this.billingReference;
            dropOff.earliest = this.earliest;
            dropOff.latest = latest;
            dropOff.mot = mot;

            return dropOff;
        }


        /**
         * Validates the input and builds {@link DropOff}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link DropOff}.
         *
         * @return  new {@link DropOff} with attributes specified in {@link Builder}
         */
        public DropOff buildAndValidate() {

            DropOff dropOff = this.build();

            MinimumRequirementValidator.validate(dropOff);

            return dropOff;
        }
    }

    public static final class StepBuilder implements IMot, ILocation, IBuild {

        @NotNull(message = "mot is part of minimum requirement and must not be null")
        private MeansOfTransport mot;
        private Instant latest;
        private Instant earliest;
        private String billingReference;
        private Transport.LoadingUnit loadingUnit = new Transport.LoadingUnit();

        @NotNull(message = "location is part of minimum requirement and must not be null")
        @LocationConstraint(message = "location city and designation are part of the minimum requirement of dropOff")
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
        public IBuild withEarliest(Instant earliest) {

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
        public IMot withLocation(Location location) {

            this.location = location;

            return this;
        }


        /**
         * Builds {@link DropOff} without input validation.
         *
         * @return  new {@link DropOff} with attributes specified in {@link Builder}
         */
        @Override
        public DropOff build() {

            return new DropOff(this);
        }


        /**
         * Validates the input and builds {@link DropOff}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link DropOff}.
         *
         * @return  new {@link DropOff} with attributes specified in {@link Builder}
         */
        @Override
        public DropOff buildAndValidate() {

            DropOff dropOff = this.build();

            MinimumRequirementValidator.validate(dropOff);

            return dropOff;
        }
    }
}
