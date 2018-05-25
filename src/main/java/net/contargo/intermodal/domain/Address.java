package net.contargo.intermodal.domain;

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

    public String getStreet() {

        return street;
    }


    public String getLocationPostalCode() {

        return location.getPostalCode();
    }


    public String getLocationCity() {

        return location.getCity();
    }


    public String getCountryName() {

        return country.getName();
    }


    public String getCountryCode() {

        return country.getCode();
    }


    public Location getLocation() {

        return location;
    }


    public Country getCountry() {

        return country;
    }

    public static final class Builder {

        private String street;
        private String locationPostalCode;
        private String locationCity;
        private String countryName;
        private String countryCode;

        private Builder() {
        }

        public static Builder newAddress() {

            return new Builder();
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


        public Builder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


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


        public Address buildAndValidate() {

            Address address = this.build();

            Validator.validate(address);

            return address;
        }
    }
}
