package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Adresse
 * @name_english  address
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Address {

    private String street;

    private Location location;

    private Country country;

    private Address() {

        // OK
    }

    /**
     * Creates a new builder for {@link Address}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Address}.
     *
     * @param  address  that should be copied.
     *
     * @return  new builder with values of given address.
     */
    public static Builder newBuilder(Address address) {

        return new Builder().withStreet(address.getStreet())
            .withLocation(address.getLocation())
            .withCountryName(address.getCountryName())
            .withCountryCode(address.getCountryCode());
    }


    public String getStreet() {

        return street;
    }


    @JsonIgnore
    public String getLocationPostalCode() {

        if (location != null) {
            return location.getPostalCode();
        }

        return null;
    }


    @JsonIgnore
    public String getLocationCity() {

        if (location != null) {
            return location.getCity();
        }

        return null;
    }


    @JsonIgnore
    public String getCountryName() {

        if (country != null) {
            return country.getName();
        }

        return null;
    }


    @JsonIgnore
    public String getCountryCode() {

        if (country != null) {
            return country.getCode();
        }

        return null;
    }


    public Location getLocation() {

        return location;
    }


    public Country getCountry() {

        return country;
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

        private String street;
        private Location location;
        private String countryName;
        private String countryCode;

        private Builder() {
        }

        public Builder withStreet(String street) {

            this.street = street;

            return this;
        }


        public Builder withCountryName(String countryName) {

            this.countryName = countryName;

            return this;
        }


        /**
         * @param  unLocode  2 characters (UN/LOCODE).
         *
         * @return  this
         */
        public Builder withCountryCode(String unLocode) {

            this.countryCode = unLocode;

            return this;
        }


        public Builder withLocation(Location location) {

            this.location = location;

            return this;
        }


        /**
         * Builds {@link Address} without input validation.
         *
         * @return  new {@link Address} with attributes specified in {@link Builder}
         */
        public Address build() {

            Address address = new Address();
            address.street = this.street;

            Country country = new Country();
            country.setCode(this.countryCode);
            country.setName(this.countryName);
            address.country = country;
            address.location = location;

            return address;
        }


        /**
         * Validates the input and builds {@link Address}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Address}.
         *
         * @return  new {@link Address} with attributes specified in {@link Builder}
         */
        public Address buildAndValidate() {

            Address address = this.build();

            MinimumRequirementValidator.validate(address);

            return address;
        }
    }
}
