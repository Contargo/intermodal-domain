package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

import javax.validation.constraints.NotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class PickUp {

    @NotNull(message = "location is part of minimum requirement")
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
    @NotNull(message = "earliest is part of minimum requirement")
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant earliest;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant latest;

    @NotNull(message = "mot is part of minimum requirement")
    private MeansOfTransport mot;

    public static Builder newBuilder() {

        return new Builder();
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

    public static final class Builder {

        private Location location;
        private Transport.LoadingUnit loadingUnit = new Transport.LoadingUnit();
        private String billingReference;
        private Instant earliest;
        private Instant latest;
        private MeansOfTransport mot;

        private Builder() {
        }

        public Builder withLocation(String city, String designation, String type) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);
            this.location.setType(type);

            return this;
        }


        public Builder withLocation(String city, String designation) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);

            return this;
        }


        public Builder withLoadingUnit(String reference, Boolean isEmpty) {

            this.loadingUnit.setEmpty(isEmpty);
            this.loadingUnit.setReference(reference);

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


        public PickUp buildAndValidate() {

            PickUp pickUp = this.build();

            Validator.validate(pickUp);

            return pickUp;
        }
    }
}