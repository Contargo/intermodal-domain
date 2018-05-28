package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;


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
    private String adr;

    /**
     * DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     */
    private String moduleEntry95;

    public License getLicense() {

        return license;
    }


    public String getId() {

        return id;
    }


    public String getAdr() {

        return adr;
    }


    public String getModuleEntry95() {

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
        private String licenseValidity;

        private String licenseNumber;

        public String getLicenseValidity() {

            return licenseValidity;
        }


        public String getLicenseNumber() {

            return licenseNumber;
        }
    }

    public static final class Builder {

        private String licenseValidity;
        private String licenseNumber;
        private String name;
        private String firstName;
        private Address address;
        private String cellphone;
        private String dateOfBirth;
        private String locationCity;
        private String id;
        private String countryCode;
        private String adr;
        private String moduleEntry95;

        private Builder() {
        }

        public static Builder newDriver() {

            return new Builder();
        }


        public Builder withName(String name) {

            this.name = name;

            return this;
        }


        public Builder withFirstName(String firstName) {

            this.firstName = firstName;

            return this;
        }


        public Builder withAddress(Address address) {

            this.address = address;

            return this;
        }


        public Builder withCellphone(String cellphone) {

            this.cellphone = cellphone;

            return this;
        }


        public Builder withLicenseValidity(int year, int month, int day) {

            this.licenseValidity = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public Builder withLicenseNumber(String licenseNumber) {

            this.licenseNumber = licenseNumber;

            return this;
        }


        public Builder bornOn(int year, int month, int day) {

            this.dateOfBirth = ISO8601DateFormatter.format(year, month, day);

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


        public Builder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


        public Builder withAdr(int year, int month, int day) {

            this.adr = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public Builder withModuleEntry95(int year, int month, int day) {

            this.moduleEntry95 = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


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

            if (locationCity != null) {
                driver.setLocationCity(this.locationCity);
            }

            if (licenseValidity != null || licenseNumber != null) {
                License license = new License();
                license.licenseNumber = licenseNumber;
                license.licenseValidity = licenseValidity;
                driver.license = license;
            }

            return driver;
        }


        public Driver buildAndValidate() {

            Driver driver = this.build();

            Validator.validate(driver);

            return driver;
        }
    }
}
