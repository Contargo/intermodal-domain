package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.Instant;


/**
 * A {@link Person} transported on a {@link Barge} as described in {@link ProcessingBarge}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Passagier
 * @name_english  passenger
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Passenger extends Person {

    @Override
    public String toString() {

        try {
            return this.getClass().getSimpleName() + ": " + JsonStringMapper.map(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "";
    }


    public static Builder newBuilder() {

        return new Builder();
    }

    public static final class Builder {

        private String name;
        private String firstName;
        private Address address;
        private String cellphone;
        private Instant dateOfBirth;
        private String locationCity;
        private String countryCode;

        private Builder() {
        }

        public static Builder aPassenger() {

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


        public Builder withDateOfBirth(Instant dateOfBirth) {

            this.dateOfBirth = dateOfBirth;

            return this;
        }


        public Builder withLocation(String locationCity) {

            this.locationCity = locationCity;

            return this;
        }


        public Builder withCountryCode(String countryCode) {

            this.countryCode = countryCode;

            return this;
        }


        /**
         * Builds {@link Passenger} without input validation.
         *
         * @return  new {@link Passenger} with attributes specified in {@link Builder}
         */
        public Passenger build() {

            Passenger passenger = new Passenger();
            passenger.setName(name);
            passenger.setFirstName(firstName);
            passenger.setAddress(address);
            passenger.setCellphone(cellphone);
            passenger.setDateOfBirth(dateOfBirth);
            passenger.setLocationCity(this.locationCity);
            passenger.setCountryCode(this.countryCode);

            return passenger;
        }


        /**
         * Validates the input and builds {@link Passenger}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Passenger}.
         *
         * @return  new {@link Passenger} with attributes specified in {@link Builder}
         */
        public Passenger buildAndValidate() {

            Passenger passenger = this.build();

            MinimumRequirementValidator.validate(passenger);

            return passenger;
        }
    }
}
