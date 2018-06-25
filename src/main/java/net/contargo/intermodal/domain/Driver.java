package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;


/**
 * A {@link Person} driving a motor vehicle.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Fahrer
 * @name_english  driver
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Driver extends Person {

    private License license;

    /**
     * @name_german  Fahrerkartennummer
     */
    private String id;

    /**
     * ADR (fr: Accord européen relatif au transport international des marchandises dangereuses par route): european
     * treaty for international transport of dangerous goods. (Format: DateTime ISO 8601 inclusive UTC
     * (yyyy-MM-dd'T'HH:mm:ss.SSSX).)
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant adr;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant moduleEntry95;

    /**
     * Creates a new builder for {@link Driver}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Driver}.
     *
     * @param  driver  that should be copied.
     *
     * @return  new builder with values of given driver.
     */
    public static Builder newBuilder(Driver driver) {

        return new Builder().withCellphoneNumber(driver.getCellphone())
            .withNationality(driver.getNationality())
            .bornOn(driver.getDateOfBirth())
            .named(driver.getFirstName(), driver.getLastName())
            .withAddress(driver.getAddress())
            .withModuleEntry95(driver.getModuleEntry95())
            .withId(driver.getId())
            .withAdr(driver.getAdr())
            .bornIn(driver.getCityOfBirth())
            .withLicense(driver.getLicense());
    }


    public License getLicense() {

        return license;
    }


    public String getId() {

        return id;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getAdr() {

        return adr;
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getModuleEntry95() {

        return moduleEntry95;
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

    public static class License {

        /**
         * format: DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
         */
        @JsonDeserialize(using = InstantJsonDeserializer.class)
        private Instant validity;

        private String number;

        @JsonSerialize(using = InstantJsonSerializer.class)
        public Instant getValidity() {

            return validity;
        }


        public String getNumber() {

            return number;
        }
    }

    public static final class Builder {

        private String name;
        private String firstName;
        private Address address;
        private String cellphone;
        private Instant dateOfBirth;
        private String locationCity;
        private String id;
        private String countryCode;
        private Instant adr;
        private Instant moduleEntry95;
        private License license;

        private Builder() {
        }

        public Builder named(String firstName, String lastName) {

            this.firstName = firstName;
            this.name = lastName;

            return this;
        }


        public Builder withAddress(Address address) {

            this.address = address;

            return this;
        }


        public Builder withCellphoneNumber(String cellphone) {

            this.cellphone = cellphone;

            return this;
        }


        public Builder withLicense(String number, Instant validity) {

            License license = new License();
            license.validity = validity;
            license.number = number;
            this.license = license;

            return this;
        }


        Builder withLicense(License license) {

            this.license = license;

            return this;
        }


        public Builder bornOn(Instant instant) {

            this.dateOfBirth = instant;

            return this;
        }


        public Builder bornIn(String city) {

            this.locationCity = city;

            return this;
        }


        public Builder withId(String id) {

            this.id = id;

            return this;
        }


        public Builder withNationality(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


        public Builder withAdr(Instant instant) {

            this.adr = instant;

            return this;
        }


        public Builder withModuleEntry95(Instant instant) {

            this.moduleEntry95 = instant;

            return this;
        }


        /**
         * Builds {@link Driver} without input validation.
         *
         * @return  new {@link Driver} with attributes specified in {@link Builder}
         */
        public Driver build() {

            Driver driver = new Driver();
            driver.setCellphone(this.cellphone);

            if (countryCode != null) {
                driver.setCountryCode(this.countryCode);
            }

            driver.setDateOfBirth(this.dateOfBirth);
            driver.setName(this.name);
            driver.setAddress(this.address);
            driver.setFirstName(this.firstName);
            driver.moduleEntry95 = this.moduleEntry95;
            driver.id = this.id;
            driver.adr = this.adr;
            driver.license = this.license;

            if (locationCity != null) {
                driver.setLocationCity(this.locationCity);
            }

            return driver;
        }


        /**
         * Validates the input and builds {@link Driver}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Driver}.
         *
         * @return  new {@link Driver} with attributes specified in {@link Builder}
         */
        public Driver buildAndValidate() {

            Driver driver = this.build();

            MinimumRequirementValidator.validate(driver);

            return driver;
        }
    }
}
