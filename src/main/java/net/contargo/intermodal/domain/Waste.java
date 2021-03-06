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
    @NotNull(message = "keyID is part of minimum requirement and must not be null")
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

    private Waste() {

        // OK
    }

    /**
     * Creates a new builder for {@link Waste}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Waste}.
     *
     * @param  waste  that should be copied.
     *
     * @return  new builder with values of given waste.
     */
    public static Builder newBuilder(Waste waste) {

        return new Builder().withReceiptNumber(waste.getReceiptNumber())
            .withKeyID(waste.getKeyID())
            .withWasteRegulationNumber(waste.getWasteRegulationNumber())
            .withPosition(waste.getPosition())
            .withWeight(waste.getWeight());
    }


    /**
     * Starts a new step builder pattern for {@link Waste}. Other than the normal {@link Builder} the
     * {@link StepBuilder} will enforce the order in which fields are set to make sure the minimum requirements are
     * fulfilled.
     *
     * @return  IKeyID
     */
    public static IKeyID newStepBuilder() {

        return new StepBuilder();
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

        if (weight != null) {
            return weight.getNetto();
        }

        return null;
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

    public interface IBuild {

        Waste build();


        Waste buildAndValidate();


        IBuild withWeightNetto(Double weight, MassUnit unit);


        IBuild withReceiptNumber(String receiptNumber);


        IBuild withPosition(Integer position);


        IBuild withWasteRegulationNumber(String wasteRegulationNumber);
    }

    public interface IKeyID {

        IBuild withKeyID(String keyID);
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


        Builder withWeight(Weight weight) {

            if (weight != null) {
                this.weightNetto = weight.getNetto();
            }

            return this;
        }


        /**
         * Builds {@link Waste} without input validation.
         *
         * @return  new {@link Waste} with attributes specified in {@link Builder}
         */
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


        /**
         * Validates the input and builds {@link Waste}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Waste}.
         *
         * @return  new {@link Waste} with attributes specified in {@link Builder}
         */
        public Waste buildAndValidate() {

            Waste waste = this.build();

            MinimumRequirementValidator.validate(waste);

            return waste;
        }
    }

    public static final class StepBuilder implements IKeyID, IBuild {

        private Quantity<Mass> weightNetto;
        private String receiptNumber;
        private String wasteRegulationNumber;
        @NotNull(message = "keyID is part of minimum requirement and must not be null")
        private String keyID;
        private Integer position;

        private StepBuilder() {
        }

        @Override
        public IBuild withWeightNetto(Double weightNetto, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNetto = Quantities.getQuantity(weightNetto, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightNetto = UnitConverter.tonToKilogram(weightNetto);
            }

            return this;
        }


        @Override
        public IBuild withReceiptNumber(String receiptNumber) {

            this.receiptNumber = receiptNumber;

            return this;
        }


        @Override
        public IBuild withWasteRegulationNumber(String wasteRegulationNumber) {

            this.wasteRegulationNumber = wasteRegulationNumber;

            return this;
        }


        @Override
        public IBuild withKeyID(String keyID) {

            this.keyID = keyID;

            return this;
        }


        @Override
        public IBuild withPosition(Integer position) {

            this.position = position;

            return this;
        }


        /**
         * Builds {@link Waste} without input validation.
         *
         * @return  new {@link Waste} with attributes specified in {@link Builder}
         */
        @Override
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


        /**
         * Validates the input and builds {@link Waste}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Waste}.
         *
         * @return  new {@link Waste} with attributes specified in {@link Builder}
         */
        @Override
        public Waste buildAndValidate() {

            Waste waste = this.build();

            MinimumRequirementValidator.validate(waste);

            return waste;
        }
    }
}
