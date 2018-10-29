package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * A location used in drop off, pick up and stops of an {@link Transport}. Also used to specify the city of birth of a
 * {@link Person}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Ort
 * @name_english  location
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    /**
     * @definition_german  Eigenname Terminal
     * @definition_english  name of terminal
     */
    private String designation;
    private String city;

    /**
     * e.g. loading place, sea or hinterland terminal
     */
    private String type;

    private String postalCode;

    private Coordinates coordinates;

    Location() {

        // OK
    }

    /**
     * Creates a new builder for {@link Location}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Location}.
     *
     * @param  location  that should be copied.
     *
     * @return  new builder with values of given location.
     */
    public static Builder newBuilder(Location location) {

        return new Builder().withDesignation(location.getDesignation())
            .withCity(location.getCity())
            .withCoordinates(location.getCoordinates())
            .withPostalCode(location.getPostalCode())
            .withType(location.getType());
    }


    public String getDesignation() {

        return designation;
    }


    public String getCity() {

        return city;
    }


    public String getType() {

        return type;
    }


    public String getPostalCode() {

        return postalCode;
    }


    public Coordinates getCoordinates() {

        return coordinates;
    }

    public static final class Builder {

        private String designation;
        private String city;
        private String type;
        private String postalCode;
        private Coordinates coordinates;

        private Builder() {
        }

        public Builder withDesignation(String designation) {

            this.designation = designation;

            return this;
        }


        public Builder withCity(String city) {

            this.city = city;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withPostalCode(String postalCode) {

            this.postalCode = postalCode;

            return this;
        }


        public Builder withCoordinates(Coordinates coordinates) {

            this.coordinates = coordinates;

            return this;
        }


        public Location build() {

            Location location = new Location();
            location.coordinates = this.coordinates;
            location.postalCode = this.postalCode;
            location.city = this.city;
            location.designation = this.designation;
            location.type = this.type;

            return location;
        }


        /**
         * Validates the input and builds {@link Location}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Location}.
         *
         * @return  new {@link Location} with attributes specified in {@link Builder}
         */
        public Location buildAndValidate() {

            Location location = this.build();

            MinimumRequirementValidator.validate(location);

            return location;
        }
    }
}
