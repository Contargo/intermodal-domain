package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * Group of data necessary for customs proceedings.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Zolldaten
 * @name_english  customs
 * @definition_german  Gruppe der Daten, die für Zollverfahren notwendig sind bzw. während der Zollverfahren anfallen.
 * @definition_english  Group of data necessary for customs proceedings.
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Customs {

    /**
     * e.g&#046; T1, EX, GW.
     */
    private String customProcess;

    /**
     * e.g&#046; MNR.
     */
    private String customDocumentNumber;

    private Seal seal;

    public static Builder newBuilder() {

        return new Builder();
    }


    public String getCustomProcess() {

        return customProcess;
    }


    public String getCustomDocumentNumber() {

        return customDocumentNumber;
    }


    public Seal getSeal() {

        return seal;
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

        private String customProcess;
        private String customDocumentNumber;
        private Seal seal;

        private Builder() {
        }

        public Builder withCustomProcess(String customProcess) {

            this.customProcess = customProcess;

            return this;
        }


        public Builder withCustomDocumentNumber(String customDocumentNumber) {

            this.customDocumentNumber = customDocumentNumber;

            return this;
        }


        public Builder withSeal(Seal seal) {

            this.seal = seal;

            return this;
        }


        /**
         * Builds {@link Customs} without input validation.
         *
         * @return  new {@link Customs} with attributes specified in {@link Builder}
         */
        public Customs build() {

            Customs customs = new Customs();
            customs.customProcess = this.customProcess;
            customs.customDocumentNumber = this.customDocumentNumber;
            customs.seal = this.seal;

            return customs;
        }


        /**
         * Validates the input and builds {@link Customs}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Customs}.
         *
         * @return  new {@link Customs} with attributes specified in {@link Builder}
         */
        public Customs buildAndValidate() {

            Customs customs = this.build();

            MinimumRequirementValidator.validate(customs);

            return customs;
        }
    }
}
