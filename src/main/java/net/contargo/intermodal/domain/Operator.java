package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * Unit for organization of multiple actors in trimodal transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Operateur
 * @name_english  operator
 * @definition_german  Funktionseinheit, die bei der Güterbeförderung im Kombinierten Verkehr die akteurübergreifende
 *                     Organisation durchführt.
 * @definition_english  Unit for organization of multiple actors in trimodal transport.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Operator {

    private String name;

    private String legalForm;

    private Address address;

    /**
     * @name_english  value added tax identification number
     * @name_german  Umsatzsteuer-Identifikationsnummer
     */
    private String vatId;

    /**
     * @name_english  Tax Identification Number
     * @name_german  Steuerliche Identifikationsnummer
     */
    private String tin;

    private String insurance;

    /**
     * Creates a new builder for {@link Operator}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Operator}.
     *
     * @param  operator  that should be copied.
     *
     * @return  new builder with values of given operator.
     */
    public static Builder newBuilder(Operator operator) {

        return new Builder().withAddress(operator.getAddress())
            .withTin(operator.getTin())
            .withName(operator.getName())
            .withVatId(operator.getVatId())
            .withInsurance(operator.getInsurance())
            .withLegalForm(operator.getLegalForm());
    }


    public String getName() {

        return name;
    }


    public String getLegalForm() {

        return legalForm;
    }


    public Address getAddress() {

        return address;
    }


    public String getVatId() {

        return vatId;
    }


    public String getTin() {

        return tin;
    }


    public String getInsurance() {

        return insurance;
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
        private String legalForm;
        private Address adress;
        private String vatId;
        private String tin;
        private String insurance;

        private Builder() {
        }

        public Builder withName(String name) {

            this.name = name;

            return this;
        }


        public Builder withLegalForm(String legalForm) {

            this.legalForm = legalForm;

            return this;
        }


        public Builder withAddress(Address address) {

            this.adress = address;

            return this;
        }


        public Builder withVatId(String vatId) {

            this.vatId = vatId;

            return this;
        }


        public Builder withTin(String tin) {

            this.tin = tin;

            return this;
        }


        public Builder withInsurance(String insurance) {

            this.insurance = insurance;

            return this;
        }


        /**
         * Builds {@link Operator} without input validation.
         *
         * @return  new {@link Operator} with attributes specified in {@link Builder}
         */
        public Operator build() {

            Operator operator = new Operator();
            operator.address = this.adress;
            operator.tin = this.tin;
            operator.name = this.name;
            operator.vatId = this.vatId;
            operator.insurance = this.insurance;
            operator.legalForm = this.legalForm;

            return operator;
        }


        /**
         * Validates the input and builds {@link Operator}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Operator}.
         *
         * @return  new {@link Operator} with attributes specified in {@link Builder}
         */
        public Operator buildAndValidate() {

            Operator operator = this.build();

            MinimumRequirementValidator.validate(operator);

            return operator;
        }
    }
}
