package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.Instant;
import java.time.LocalDate;


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
     * @definition_german  ADNR-Schulungsbescheinigung (Format: DateTime ISO 8601 inclusive UTC) ist ein
     *                     Gefahrgutführerschein für internationale Beförderung gefährlicher Güter auf Wasserstraßen.
     *                     Das ADNR gilt nicht für Seeschiffe auf Seeschifffahrtsstraßen.
     * @definition_english  ADNR (Format: DateTime ISO 8601 inclusive UTC) is a European certificate needed for the
     *                      international transport of dangerous goods by waterway. The ADNR is not relevant for
     *                      vessels on sea lanes.
     */
    @JsonDeserialize(using = InstantJsonDeserializer.class)
    private Instant adnr;

    private Skipper() {

        // OK
    }

    /**
     * Creates a new builder for {@link Skipper}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Skipper}.
     *
     * @param  skipper  that should be copied.
     *
     * @return  new builder with values of given skipper.
     */
    public static Builder newBuilder(Skipper skipper) {

        return new Builder().named(skipper.getFirstName(), skipper.getName())
            .withAddress(skipper.getAddress())
            .withCellphoneNumber(skipper.getCellphone())
            .bornOn(skipper.getDateOfBirth())
            .bornIn(skipper.getCityOfBirth())
            .withNationality(skipper.getNationality())
            .withAdnr(skipper.getAdnr());
    }


    @JsonSerialize(using = InstantJsonSerializer.class)
    public Instant getAdnr() {

        return adnr;
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
        private String countryCode;
        private Instant adnr;

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


        public Builder withNationality(String unLocode) {

            this.countryCode = unLocode;

            return this;
        }


        public Builder withAdnr(Instant instant) {

            this.adnr = instant;

            return this;
        }


        /**
         * Builds {@link Skipper} without input validation.
         *
         * @return  new {@link Skipper} with attributes specified in {@link Builder}
         */
        public Skipper build() {

            Skipper skipper = new Skipper();
            skipper.setName(name);
            skipper.setFirstName(firstName);
            skipper.setAddress(address);
            skipper.setCellphone(cellphone);
            skipper.setDateOfBirth(dateOfBirth);

            skipper.setCityOfBirth(location);

            if (countryCode != null) {
                skipper.setNationality(countryCode);
            }

            skipper.adnr = this.adnr;

            return skipper;
        }


        /**
         * Validates the input and builds {@link Skipper}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Skipper}.
         *
         * @return  new {@link Skipper} with attributes specified in {@link Builder}
         */
        public Skipper buildAndValidate() {

            Skipper skipper = this.build();

            MinimumRequirementValidator.validate(skipper);

            return skipper;
        }
    }
}
