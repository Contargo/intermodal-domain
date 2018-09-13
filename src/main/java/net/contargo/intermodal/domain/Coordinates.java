package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * Coordinates of a {@link Location}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @source  Contargo specific
 */
public class Coordinates {

    @NotNull(message = "latitude is part of minimum requirement and must not be null")
    private Double latitude;

    @NotNull(message = "longitude is part of minimum requirement and must not be null")
    private Double longitude;

    private Coordinates() {
    }

    /**
     * Creates a new builder for {@link Coordinates}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Coordinates}.
     *
     * @param  coordinates  that should be copied.
     *
     * @return  new builder with values of given coordinates.
     */
    public static Builder newBuilder(Coordinates coordinates) {

        return new Builder().withLatitude(coordinates.getLatitude()).withLongitude(coordinates.getLongitude());
    }


    public Double getLongitude() {

        return longitude;
    }


    public Double getLatitude() {

        return latitude;
    }

    public static final class Builder {

        private Double latitude;
        private Double longitude;

        private Builder() {
        }

        public Builder withLatitude(Double latitude) {

            this.latitude = latitude;

            return this;
        }


        public Builder withLongitude(Double longitude) {

            this.longitude = longitude;

            return this;
        }


        /**
         * Builds {@link Coordinates} without input validation.
         *
         * @return  new {@link Coordinates} with attributes specified in {@link Builder}
         */
        public Coordinates build() {

            Coordinates coordinates = new Coordinates();
            coordinates.latitude = this.latitude;
            coordinates.longitude = this.longitude;

            return coordinates;
        }


        /**
         * Validates the input and builds {@link Coordinates}. Throws IllegalStateException if input doesn't fulfill
         * the minimum requirement of {@link Coordinates}.
         *
         * @return  new {@link Coordinates} with attributes specified in {@link Builder}
         */
        public Coordinates buildAndValidate() {

            Coordinates coordinates = this.build();

            MinimumRequirementValidator.validate(coordinates);

            return coordinates;
        }
    }
}
