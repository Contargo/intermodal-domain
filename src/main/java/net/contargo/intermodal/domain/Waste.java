package net.contargo.intermodal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;

import javax.validation.constraints.NotNull;

import static tec.units.ri.unit.Units.KILOGRAM;


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

    private Integer position;

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

    public static Builder newBuilder() {

        return new Builder();
    }


    public Integer getPosition() {

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


    @JsonIgnore
    public Quantity<Mass> getWeightNetto() {

        return weight.getNetto();
    }


    public Weight getWeight() {

        return weight;
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

        private Integer position;
        private String keyID;
        private String wasteRegulationNumber;
        private String receiptNumber;
        private Quantity<Mass> weightNetto;

        private Builder() {
        }

        public Builder withPosition(Integer position) {

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


        public Builder withWeightNetto(Double weightNetto, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNetto = Quantities.getQuantity(weightNetto, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightNetto = UnitConverter.tonToKilogram(weightNetto);
            }

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
