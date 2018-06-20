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

    public static Builder newBuilder() {

        return new Builder();
    }


    public String getStreet() {

        return street;
    }


    @JsonIgnore
    public String getLocationPostalCode() {

        return location.getPostalCode();
    }


    @JsonIgnore
    public String getLocationCity() {

        return location.getCity();
    }


    @JsonIgnore
    public String getCountryName() {

        return country.getName();
    }


    @JsonIgnore
    public String getCountryCode() {

        return country.getCode();
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
        private String locationPostalCode;
        private String locationCity;
        private String countryName;
        private String countryCode;

        private Builder() {
        }

        public Builder withStreet(String street) {

            this.street = street;

            return this;
        }


        public Builder withLocationPostalCode(String locationPostalCode) {

            this.locationPostalCode = locationPostalCode;

            return this;
        }


        public Builder withLocationCity(String locationCity) {

            this.locationCity = locationCity;

            return this;
        }


        public Builder withCountryName(String countryName) {

            this.countryName = countryName;

            return this;
        }


        /**
         * @param  countryCode  2 characters (UN/LOCODE).
         *
         * @return  this
         */
        public Builder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

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

            Location location = new Location();
            location.setCity(this.locationCity);
            location.setPostalCode(this.locationPostalCode);
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
