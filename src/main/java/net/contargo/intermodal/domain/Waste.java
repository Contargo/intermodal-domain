package net.contargo.intermodal.domain;

import javax.validation.constraints.NotNull;


/**
 * Substances or objects that their owner disposes of, wants to dispose of or has to dispose of.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Abfall
 * @name_english  waste
 * @definition_german  Stoffe oder Gegenstände, die ihr Besitzer entsorgt, entsorgen will oder entsorgen muss. (@see
 *                     Regelwerk Abfall – Kreislaufwirtschaftsgesetz (KrWG): Gesetz zur Förderung der
 *                     Kreislaufwirtschaft und Sicherung der umweltverträglichen Bewirtschaftung von Abfällen)
 * @definition_english  Substances or objects that their owner disposes of, wants to dispose of or has to dispose of.
 *                      (@see Regelwerk Abfall – Kreislaufwirtschaftsgesetz (KrWG): Gesetz zur Förderung der
 *                      Kreislaufwirtschaft und Sicherung der umweltverträglichen Bewirtschaftung von Abfällen)
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 * @minimum_requirement  keyId
 */
public class Waste {

    private String position;

    /**
     * @name_german  Abfallschlüsselnummer
     * @definition_german  Nummer zur Klassifizierung von Abfällen auf der Basis der Abfallverzeichnis-Verordnung.
     * @abbreviation_german  ASN
     */
    @NotNull(message = "keyID is part of minimum requirement")
    private String keyID;

    /**
     * @name_german  Abfallverzeichnis-Verordnung
     * @abbreviation_german  AVV
     */
    private String wasteRegulationNumber;

    private String receiptNumber;

    /**
     * in kg per position.
     */
    private Double weightNetto;

    public String getPosition() {

        return position;
    }


    public String getKeyID() {

        return keyID;
    }


    public String getWasteRegulationNumber() {

        return wasteRegulationNumber;
    }


    public String getReceiptNumber() {

        return receiptNumber;
    }


    public Double getWeightNetto() {

        return weightNetto;
    }

    public static final class WasteBuilder {

        private String position;
        private String keyID;
        private String wasteRegulationNumber;
        private String receiptNumber;
        private Double weightNetto;

        private WasteBuilder() {
        }

        public static WasteBuilder newWaste() {

            return new WasteBuilder();
        }


        public WasteBuilder withPosition(String position) {

            this.position = position;

            return this;
        }


        public WasteBuilder withKeyID(String keyID) {

            this.keyID = keyID;

            return this;
        }


        public WasteBuilder withWasteRegulationNumber(String wasteRegulationNumber) {

            this.wasteRegulationNumber = wasteRegulationNumber;

            return this;
        }


        public WasteBuilder withReceiptNumber(String receiptNumber) {

            this.receiptNumber = receiptNumber;

            return this;
        }


        public WasteBuilder withWeightNetto(Double weightNetto) {

            this.weightNetto = weightNetto;

            return this;
        }


        public Waste build() {

            Waste waste = new Waste();
            waste.receiptNumber = this.receiptNumber;
            waste.keyID = this.keyID;
            waste.wasteRegulationNumber = this.wasteRegulationNumber;
            waste.position = this.position;
            waste.weightNetto = this.weightNetto;

            return waste;
        }


        public Waste buildAndValidate() {

            Waste waste = this.build();

            Validator.validate(waste);

            return waste;
        }
    }
}
