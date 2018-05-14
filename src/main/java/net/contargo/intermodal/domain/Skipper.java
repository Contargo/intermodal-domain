package net.contargo.intermodal.domain;

/**
 * A {@link Person} driving a ship.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Schiffsführer
 * @name_english  skipper
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Skipper extends Person {

    /**
     * ADNR (fr: Accord européen relatif au transport international des marchandises dangereuses par voie de navigation
     * intérieure sur le Rhin): european treaty for transport of dangerous goods on the Rhine. (Format: DateTime ISO
     * 8601 inclusive) UTC.
     */
    private String adnr;

    public Skipper withAdnr(int year, int month, int day) {

        this.adnr = ISO8601DateFormatter.format(year, month, day);

        return this;
    }


    public String getAdnr() {

        return adnr;
    }

    public static final class SkipperBuilder {

        private String name;
        private String firstName;
        private Address address;
        private String cellphone;
        private String dateOfBirth;
        private String locationCity;
        private String countryCode;
        private String adnr;

        private SkipperBuilder() {
        }

        public static SkipperBuilder newSkipper() {

            return new SkipperBuilder();
        }


        public SkipperBuilder withName(String name) {

            this.name = name;

            return this;
        }


        public SkipperBuilder withFirstName(String firstName) {

            this.firstName = firstName;

            return this;
        }


        public SkipperBuilder withAddress(Address address) {

            this.address = address;

            return this;
        }


        public SkipperBuilder withCellphone(String cellphone) {

            this.cellphone = cellphone;

            return this;
        }


        public SkipperBuilder withDateOfBirth(int year, int month, int day) {

            this.dateOfBirth = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public SkipperBuilder withLocationCity(String locationCity) {

            this.locationCity = locationCity;

            return this;
        }


        public SkipperBuilder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


        public SkipperBuilder withAdnr(int year, int month, int day) {

            this.adnr = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public Skipper build() {

            Skipper skipper = new Skipper();
            skipper.setName(name);
            skipper.setFirstName(firstName);
            skipper.setAddress(address);
            skipper.setCellphone(cellphone);
            skipper.setDateOfBirth(dateOfBirth);
            skipper.setLocationCity(locationCity);
            skipper.setCountryCode(countryCode);
            skipper.adnr = this.adnr;

            return skipper;
        }


        public Skipper buildAndValidate() {

            Skipper skipper = this.build();

            Validator.validate(skipper);

            return skipper;
        }
    }
}
