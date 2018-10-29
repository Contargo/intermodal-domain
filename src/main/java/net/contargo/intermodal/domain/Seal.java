package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * A seal used in {@link Customs} and {@link LUOrder}.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Siegel
 * @name_english  seal
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Seal {

    private String type;

    private String number;

    private Seal() {

        // OK
    }

    /**
     * Creates a new builder for {@link Seal}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Seal}.
     *
     * @param  seal  that should be copied.
     *
     * @return  new builder with values of given seal.
     */
    public static Builder newBuilder(Seal seal) {

        return new Builder().withType(seal.getType()).withNumber(seal.getNumber());
    }


    public String getType() {

        return type;
    }


    void setType(String type) {

        this.type = type;
    }


    public String getNumber() {

        return number;
    }


    void setNumber(String number) {

        this.number = number;
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

        private String type;
        private String number;

        private Builder() {
        }

        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withNumber(String number) {

            this.number = number;

            return this;
        }


        /**
         * Builds {@link Seal} without input validation.
         *
         * @return  new {@link Seal} with attributes specified in {@link Builder}
         */
        public Seal build() {

            Seal seal = new Seal();
            seal.setType(type);
            seal.setNumber(number);

            return seal;
        }
    }
}
