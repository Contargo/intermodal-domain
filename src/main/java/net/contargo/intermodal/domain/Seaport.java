package net.contargo.intermodal.domain;

/**
 * Port that can be accessed by vessels.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Seehafen
 * @name_english  seaport
 * @definition_german  Hafen, der von (Hoch-)Seeschiffen angelaufen werden kann.
 * @definition_english  Port that can be accessed by vessels.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */

public class Seaport {

    private String name;

    private Seaport() {

        // OK
    }

    /**
     * Creates a new builder for {@link Seaport}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Seaport}.
     *
     * @param  seaport  that should be copied.
     *
     * @return  new builder with values of given seaport.
     */
    public static Builder newBuilder(Seaport seaport) {

        return new Builder().withName(seaport.getName());
    }


    public String getName() {

        return name;
    }

    public static final class Builder {

        private String name;

        private Builder() {
        }

        public static Builder aSeaport() {

            return new Builder();
        }


        public Builder withName(String name) {

            this.name = name;

            return this;
        }


        public Seaport build() {

            Seaport seaport = new Seaport();
            seaport.name = this.name;

            return seaport;
        }


        /**
         * Validates the input and builds {@link Seaport}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Seaport}.
         *
         * @return  new {@link Seaport} with attributes specified in {@link Builder}
         */
        public Seaport buildAndValidate() {

            Seaport seaport = this.build();

            MinimumRequirementValidator.validate(seaport);

            return seaport;
        }
    }
}
