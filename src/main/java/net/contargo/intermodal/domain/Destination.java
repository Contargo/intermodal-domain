package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class Destination {

    private Vessel vessel;

    private Seaport seaport;

    @NotNull(message = "location is part of minimum requirement")
    private Location location;

    /**
     * 2 characters (UN/LOCODE).
     */
    private Country country;

    public String getCountryCode() {

        return country.getCode();
    }


    public Location getLocation() {

        return location;
    }


    public Vessel getVessel() {

        return vessel;
    }


    public Seaport getSeaport() {

        return seaport;
    }

    public static final class Builder {

        private Vessel vessel;
        private Seaport seaport;
        private Location location;
        private Country country;

        private Builder() {
        }

        public static Builder newDestination() {

            return new Builder();
        }


        public Builder withCountry(String code) {

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


        public Builder withLocation(Location location) {

            this.location = location;

            return this;
        }


        public Builder withCountry(Country country) {

            this.country = country;

            return this;
        }


        public Builder withSeaport(String name) {

            this.seaport = new Seaport(name);

            return this;
        }


        public Builder withLocation(String city, String designation) {

            this.location = new Location();
            this.location.setCity(city);
            this.location.setDesignation(designation);

            return this;
        }


        public Builder withLocation(String designation) {

            this.location = new Location();
            this.location.setDesignation(designation);

            return this;
        }


        public Destination build() {

            Destination destination = new Destination();
            destination.vessel = vessel;
            destination.seaport = seaport;
            destination.location = location;
            destination.country = country;

            return destination;
        }


        public Destination buildAndValidate() {

            Destination destination = this.build();

            Validator.validate(destination);

            return destination;
        }
    }
}
