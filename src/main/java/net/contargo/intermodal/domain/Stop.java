package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;


/**
 * A stop which is part of a {@link Transport} of an {@link Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Stop {

    @NotNull(message = "location is part of minimum requirement")
    private List<Location> location;

    /**
     * Sequence of stops.
     */
    private Integer sequence;

    /**
     * Format: ISO 8601 inclusive UTC.
     */

    private String earliest;

    /**
     * Format: ISO 8601 inclusive UTC.
     */
    private String latest;

    private String reference;

    private String billingReference;

    private MeansOfTransport mot;

    public List<Location> getLocation() {

        return location;
    }


    public Integer getSequence() {

        return sequence;
    }


    public String getEarliest() {

        return earliest;
    }


    public String getLatest() {

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

        private String earliest;
        private String latest;
        private String reference;
        private String billingReference;
        private MeansOfTransport mot;

        private Builder() {
        }

        public static Builder newStop() {

            return new Builder();
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


        public Builder withEarliest(String earliest) {

            this.earliest = earliest;

            return this;
        }


        public Builder withLatest(String latest) {

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


        public Builder withMot(MeansOfTransport mot) {

            this.mot = mot;

            return this;
        }


        public Stop build() {

            Stop stop = new Stop();
            stop.billingReference = this.billingReference;
            stop.latest = this.latest;
            stop.earliest = this.earliest;
            stop.mot = this.mot;
            stop.location = this.location;
            stop.sequence = this.sequence;
            stop.reference = this.reference;

            return stop;
        }


        public Stop buildAndValidate() {

            Stop stop = this.build();

            Validator.validate(stop);

            return stop;
        }
    }
}
