package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * A stop which is part of a {@link Transport} of an {@link Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @minimum_requirement  locations with city and designation
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Stop {

    /**
     * Multi stops possible.
     */
    @NotNull(message = "locations is part of minimum requirement and must not be null")
    @StopLocationConstraint(message = "locations city and designation are part of the minimum requirement of stop")
    private List<Location> locations;

    /**
     * Sequence of stops.
     */
    private Integer sequence;

    /**
     * Format: ISO 8601 inclusive UTC.
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant earliest;

    /**
     * Format: ISO 8601 inclusive UTC.
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant latest;

    private String reference;

    private String billingReference;

    private MeansOfTransport mot;

    private Stop() {

        // OK
    }

    /**
     * Creates a new builder for {@link Stop}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Stop}.
     *
     * @param  stop  that should be copied.
     *
     * @return  new builder with values of given stop.
     */
    public static Builder newBuilder(Stop stop) {

        return new Builder().withBillingReference(stop.getBillingReference())
            .withLatest(stop.getLatest())
            .withEarliest(stop.getEarliest())
            .withMeansOfTransport(stop.getMot())
            .withLocations(stop.getLocations())
            .withSequence(stop.getSequence())
            .withReference(stop.getReference());
    }


    private void setLocations(List<Location> location) {

        this.locations = location;
    }


    public List<Location> getLocations() {

        return locations;
    }


    public Integer getSequence() {

        return sequence;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getEarliest() {

        return earliest;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getLatest() {

        return latest;
    }


    public String getReference() {

        return reference;
    }


    public String getBillingReference() {

        return billingReference;
    }


    public MeansOfTransport getMot() {

        return mot;
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

        private List<Location> location = new ArrayList<>();
        private Integer sequence;

        private Instant earliest;
        private Instant latest;
        private String reference;
        private String billingReference;
        private MeansOfTransport mot;

        private Builder() {
        }

        Builder withLocations(List<Location> locations) {

            this.location.addAll(locations);

            return this;
        }


        public Builder withLocation(String city, String designation, String type) {

            Location location = new Location();
            location.setCity(city);
            location.setDesignation(designation);
            location.setType(type);
            this.location.add(location);

            return this;
        }


        public Builder withLocation(String city, String designation) {

            Location location = new Location();
            location.setCity(city);
            location.setDesignation(designation);
            this.location.add(location);

            return this;
        }


        public Builder withSequence(Integer sequence) {

            this.sequence = sequence;

            return this;
        }


        public Builder withEarliest(Instant earliest) {

            this.earliest = earliest;

            return this;
        }


        public Builder withLatest(Instant latest) {

            this.latest = latest;

            return this;
        }


        public Builder withReference(String reference) {

            this.reference = reference;

            return this;
        }


        public Builder withBillingReference(String billingReference) {

            this.billingReference = billingReference;

            return this;
        }


        public Builder withMeansOfTransport(MeansOfTransport mot) {

            this.mot = mot;

            return this;
        }


        public Stop build() {

            Stop stop = new Stop();
            stop.billingReference = this.billingReference;
            stop.latest = this.latest;
            stop.earliest = this.earliest;
            stop.mot = this.mot;
            stop.locations = this.location;
            stop.sequence = this.sequence;
            stop.reference = this.reference;

            return stop;
        }


        public Stop buildAndValidate() {

            Stop stop = this.build();

            MinimumRequirementValidator.validate(stop);

            return stop;
        }
    }
}
