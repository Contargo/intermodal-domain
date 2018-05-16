package net.contargo.intermodal.domain;

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

    public static final class DriverBuilder {

        private License license = new License();
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

        private DriverBuilder() {
        }

        public static DriverBuilder newDriver() {

            return new DriverBuilder();
        }


        public DriverBuilder withName(String name) {

            this.name = name;

            return this;
        }


        public DriverBuilder withFirstName(String firstName) {

            this.firstName = firstName;

            return this;
        }


        public DriverBuilder withAddress(Address address) {

            this.address = address;

            return this;
        }


        public DriverBuilder withCellphone(String cellphone) {

            this.cellphone = cellphone;

            return this;
        }


        public DriverBuilder withLicenseValidity(int year, int month, int day) {

            this.license.licenseNumber = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public DriverBuilder withLicenseNumber(String licenseNumber) {

            this.license.licenseNumber = licenseNumber;

            return this;
        }


        public DriverBuilder withDateOfBirth(int year, int month, int day) {

            this.dateOfBirth = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public DriverBuilder withLocationCity(String locationCity) {

            this.locationCity = locationCity;

            return this;
        }


        public DriverBuilder withId(String id) {

            this.id = id;

            return this;
        }


        public DriverBuilder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


        public DriverBuilder withAdr(int year, int month, int day) {

            this.adr = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public DriverBuilder withModuleEntry95(int year, int month, int day) {

            this.moduleEntry95 = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public Driver build() {

            Driver driver = new Driver();
            driver.setCellphone(this.cellphone);
            driver.setLocationCity(this.locationCity);
            driver.setCountryCode(this.countryCode);
            driver.setDateOfBirth(this.dateOfBirth);
            driver.setName(this.name);
            driver.setAddress(this.address);
            driver.setFirstName(this.firstName);
            driver.license = this.license;
            driver.moduleEntry95 = this.moduleEntry95;
            driver.id = this.id;
            driver.adr = this.adr;

            return driver;
        }


        public Driver buildAndValidate() {

            Driver driver = this.build();

            Validator.validate(driver);

            return driver;
        }
    }
}
