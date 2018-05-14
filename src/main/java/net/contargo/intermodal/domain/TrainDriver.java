package net.contargo.intermodal.domain;

/**
 * A {@link Person} driving a train.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Lokführer
 * @name_english  train driver
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class TrainDriver extends Person {

    /**
     * RID (fr: Règlement concernant le transport international ferroviaire de marchandises dangereuses): treaty for
     * regulation of international transport of dangerous goods in rail transport. (Format: DateTime ISO 8601 inclusive
     * UTC.)
     */
    private String rid;

    public TrainDriver withRid(int year, int month, int day) {

        this.rid = ISO8601DateFormatter.format(year, month, day);

        return this;
    }


    public String getRid() {

        return rid;
    }

    public static final class TrainDriverBuilder {

        private String name;
        private String firstName;
        private Address address;
        private String cellphone;
        private String dateOfBirth;
        private String locationCity;
        private String rid;
        private String countryCode;

        private TrainDriverBuilder() {
        }

        public static TrainDriverBuilder newTrainDriver() {

            return new TrainDriverBuilder();
        }


        public TrainDriverBuilder withName(String name) {

            this.name = name;

            return this;
        }


        public TrainDriverBuilder withFirstName(String firstName) {

            this.firstName = firstName;

            return this;
        }


        public TrainDriverBuilder withAddress(Address address) {

            this.address = address;

            return this;
        }


        public TrainDriverBuilder withCellphone(String cellphone) {

            this.cellphone = cellphone;

            return this;
        }


        public TrainDriverBuilder withDateOfBirth(int year, int month, int day) {

            this.dateOfBirth = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public TrainDriverBuilder withLocationCity(String locationCity) {

            this.locationCity = locationCity;

            return this;
        }


        public TrainDriverBuilder withRid(int year, int month, int day) {

            this.rid = ISO8601DateFormatter.format(year, month, day);

            return this;
        }


        public TrainDriverBuilder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


        public TrainDriver build() {

            TrainDriver trainDriver = new TrainDriver();
            trainDriver.setName(name);
            trainDriver.setFirstName(firstName);
            trainDriver.setAddress(address);
            trainDriver.setCellphone(cellphone);
            trainDriver.setDateOfBirth(dateOfBirth);
            trainDriver.setLocationCity(locationCity);
            trainDriver.setCountryCode(countryCode);
            trainDriver.rid = this.rid;

            return trainDriver;
        }


        public TrainDriver buildAndValidate() {

            TrainDriver trainDriver = this.build();

            Validator.validate(trainDriver);

            return trainDriver;
        }
    }
}
