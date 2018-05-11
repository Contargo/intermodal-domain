package net.contargo.intermodal.domain;

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

    private Boolean seal;

    public String getCustomProcess() {

        return customProcess;
    }


    public String getCustomDocumentNumber() {

        return customDocumentNumber;
    }


    public Boolean getSeal() {

        return seal;
    }

    public static final class CustomsBuilder {

        private String customProcess;
        private String customDocumentNumber;
        private Boolean seal;

        private CustomsBuilder() {
        }

        public static CustomsBuilder newCustoms() {

            return new CustomsBuilder();
        }


        public CustomsBuilder withCustomProcess(String customProcess) {

            this.customProcess = customProcess;

            return this;
        }


        public CustomsBuilder withCustomDocumentNumber(String customDocumentNumber) {

            this.customDocumentNumber = customDocumentNumber;

            return this;
        }


        public CustomsBuilder withSeal(Boolean seal) {

            this.seal = seal;

            return this;
        }


        public Customs build() {

            Customs customs = new Customs();
            customs.customProcess = this.customProcess;
            customs.customDocumentNumber = this.customDocumentNumber;
            customs.seal = this.seal;

            return customs;
        }


        public Customs buildAndValidate() {

            Customs customs = this.build();

            Validator.validate(customs);

            return customs;
        }
    }
}
