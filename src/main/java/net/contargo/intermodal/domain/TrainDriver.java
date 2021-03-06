package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;
import java.time.LocalDate;


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
     * Validity Date in DateTime ISO 8601 inclusive UTC (yyyy-MM-dd'T'HH:mm:ss.SSSX).
     *
     * @definition_german  RID-Schulungsbescheinigung (Format: DateTime ISO 8601 inclusive UTC) ist ein europäischer
     *                     Gefahrgutführerschein für internationale Beförderung gefährlicher Güter per Schienenverkehr.
     * @definition_english  RID (Format: DateTime ISO 8601 inclusive UTC) is a European certificate needed for the
     *                      international transport of dangerous goods in rail transport.
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant rid;

    private TrainDriver() {

        // OK
    }

    /**
     * Creates a new builder for {@link TrainDriver}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link TrainDriver}.
     *
     * @param  trainDriver  that should be copied.
     *
     * @return  new builder with values of given trainDriver.
     */
    public static Builder newBuilder(TrainDriver trainDriver) {

        return new Builder().withName(trainDriver.getName())
            .withFirstName(trainDriver.getFirstName())
            .withAddress(trainDriver.getAddress())
            .withCellphone(trainDriver.getCellphone())
            .bornOn(trainDriver.getDateOfBirth())
            .bornIn(trainDriver.getCityOfBirth())
            .withNationality(trainDriver.getNationality())
            .withRid(trainDriver.getRid());
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getRid() {

        return rid;
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

        private String name;
        private String firstName;
        private Address address;
        private String cellphone;
        private LocalDate dateOfBirth;
        private Location location;
        private Instant rid;
        private String countryCode;

        private Builder() {
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


        public Builder bornOn(String dateOfBirth) {

            this.dateOfBirth = LocalDate.parse(dateOfBirth);

            return this;
        }


        Builder bornOn(LocalDate dateOfBirth) {

            this.dateOfBirth = dateOfBirth;

            return this;
        }


        public Builder bornIn(Location location) {

            this.location = location;

            return this;
        }


        public Builder withRid(Instant instant) {

            this.rid = instant;

            return this;
        }


        public Builder withNationality(String unLocode) {

            this.countryCode = unLocode;

            return this;
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


        /**
         * Builds {@link TrainDriver} without input validation.
         *
         * @return  new {@link TrainDriver} with attributes specified in {@link Builder}
         */
        public TrainDriver build() {

            TrainDriver trainDriver = new TrainDriver();
            trainDriver.setName(name);
            trainDriver.setFirstName(firstName);
            trainDriver.setAddress(address);
            trainDriver.setCellphone(cellphone);
            trainDriver.setDateOfBirth(dateOfBirth);

            trainDriver.setCityOfBirth(location);

            if (countryCode != null) {
                trainDriver.setNationality(countryCode);
            }

            trainDriver.rid = this.rid;

            return trainDriver;
        }


        /**
         * Validates the input and builds {@link TrainDriver}. Throws IllegalStateException if input doesn't fulfill
         * the minimum requirement of {@link TrainDriver}.
         *
         * @return  new {@link TrainDriver} with attributes specified in {@link Builder}
         */
        public TrainDriver buildAndValidate() {

            TrainDriver trainDriver = this.build();

            MinimumRequirementValidator.validate(trainDriver);

            return trainDriver;
        }
    }
}
