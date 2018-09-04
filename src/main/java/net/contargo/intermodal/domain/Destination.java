package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.validation.constraints.NotNull;


/**
 * The final destination specified in an {@link Order}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Reiseziel
 * @name_english  destination
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Destination {

    private Vessel vessel;

    private Seaport seaport;

    @NotNull(message = "location is part of minimum requirement and must not be null")
    @DestinationLocationConstraint(message = "location designation is part of the minimum requirement of designation")
    private Location location;

    /**
     * 2 characters (UN/LOCODE).
     */
    private Country country;

    private Destination() {

        // OK
    }

    public static Builder newBuilder() {

        return new Builder();
    }


    @JsonIgnore
    public String getCountryCode() {

        if (country != null) {
            return country.getCode();
        }

        return null;
    }


    @JsonIgnore
    public String getSeaportName() {

        if (seaport != null) {
            return seaport.getName();
        }

        return null;
    }


    public Seaport getSeaport() {

        return seaport;
    }


    public Country getCountry() {

        return country;
    }


    public Location getLocation() {

        return location;
    }


    public Vessel getVessel() {

        return vessel;
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

        private Vessel vessel;
        private Seaport seaport;
        private Location location;
        private Country country;

        private Builder() {
        }

        public Builder withCountry(Country country) {

            this.country = country;

            return this;
        }


        public Builder withCountryCode(String code) {

            this.country = new Country();
            this.country.setCode(code);

            return this;
        }


        public Builder withVessel(Vessel vessel) {

            this.vessel = vessel;

            return this;
        }


        public Builder withSeaport(Seaport seaport) {

            this.seaport = seaport;

            return this;
        }


        public Builder withLocation(String city, String designation) {

            Location location = new Location();
            location.setCity(city);
            location.setDesignation(designation);
            this.location = location;

            return this;
        }


        public Builder withLocation(String designation) {

            Location location = new Location();
            location.setDesignation(designation);
            this.location = location;

            return this;
        }


        /**
         * Builds {@link Destination} without input validation.
         *
         * @return  new {@link Destination} with attributes specified in {@link Builder}
         */
        public Destination build() {

            Destination destination = new Destination();
            destination.vessel = this.vessel;
            destination.seaport = this.seaport;
            destination.location = this.location;
            destination.country = this.country;

            return destination;
        }


        /**
         * Validates the input and builds {@link Destination}. Throws IllegalStateException if input doesn't fulfill
         * the minimum requirement of {@link Destination}.
         *
         * @return  new {@link Destination} with attributes specified in {@link Builder}
         */
        public Destination buildAndValidate() {

            Destination destination = this.build();

            MinimumRequirementValidator.validate(destination);

            return destination;
        }
    }
}
