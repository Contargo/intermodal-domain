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
 * @minimum_requirement  keyId
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
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
    private Weight weight;

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

        return weight.getNetto();
    }


    public Weight getWeight() {

        return weight;
    }

    public static final class Builder {

        private String position;
        private String keyID;
        private String wasteRegulationNumber;
        private String receiptNumber;
        private Double weightNetto;

        private Builder() {
        }

        public static Builder newWaste() {

            return new Builder();
        }


        public Builder withPosition(String position) {

            this.position = position;

            return this;
        }


        public Builder withKeyID(String keyID) {

            this.keyID = keyID;

            return this;
        }


        public Builder withWasteRegulationNumber(String wasteRegulationNumber) {

            this.wasteRegulationNumber = wasteRegulationNumber;

            return this;
        }


        public Builder withReceiptNumber(String receiptNumber) {

            this.receiptNumber = receiptNumber;

            return this;
        }


        public Builder withWeightNetto(Double weightNetto) {

            this.weightNetto = weightNetto;

            return this;
        }


        public Waste build() {

            Waste waste = new Waste();
            waste.receiptNumber = this.receiptNumber;
            waste.keyID = this.keyID;
            waste.wasteRegulationNumber = this.wasteRegulationNumber;
            waste.position = this.position;

            Weight weight = new Weight();
            weight.setNetto(this.weightNetto);
            waste.weight = weight;

            return waste;
        }


        public Waste buildAndValidate() {

            Waste waste = this.build();

            Validator.validate(waste);

            return waste;
        }
    }
}
