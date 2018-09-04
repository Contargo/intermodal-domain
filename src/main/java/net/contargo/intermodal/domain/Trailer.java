package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import javax.validation.constraints.NotNull;

import static tec.units.ri.unit.Units.KILOGRAM;
import static tec.units.ri.unit.Units.METRE;


/**
 * Trailer vehicle which has no front axle so a substantial part of its total weight is transferred to a tractor unit.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Sattelanhänger
 * @name_english  semi trailer
 * @synonym_german  Sattelauflieger, Trailer
 * @definition_german  Anhängerfahrzeug, bei dem anstelle der bei Gelenk-Deichselanhägern vorhandenen ersten Achse eine
 *                     Sattelvorrichtung angeordnet ist und ein wesentlicher Teil seines Gesamtgewichts auf eine
 *                     Sattelzugmaschine übertragen wird. (@see DIN 70010:2001, 2.3 — modifiziert, „(siehe 1.2.2.3.2)
 *                     (auch Deichselachse (Dolly))“ gestrichen, Anmerkung 1 hinzugefügt)
 * @definition_english  Trailer vehicle which has no front axle so a substantial part of its total weight is
 *                      transferred to a tractor unit. (@see DIN 70010:2001, 2.3 — modified, „(see 1.2.2.3.2) (auch
 *                      Deichselachse (Dolly))“ gestrichen, Anmerkung 1 hinzugefügt)
 * @minimum_requirement  type, size, craneable, @see also minimum requirements of {@link LoadingUnit}
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class Trailer extends LoadingUnit {

    /**
     * e.g&#046; XL, ...
     */
    @NotNull(message = "type is part of minimum requirement and must not be null")
    private String type;

    /**
     * in meter.
     */
    @NotNull(message = "size is part of minimum requirement and must not be null")
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> size;

    @NotNull(message = "craneable is part of minimum requirement and must not be null")
    private Boolean craneable;

    private Trailer() {

        // OK
    }

    /**
     * Creates a new builder for {@link Trailer}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link Trailer}.
     *
     * @param  trailer  that should be copied.
     *
     * @return  new builder with values of given trailer.
     */
    public static Builder newBuilder(Trailer trailer) {

        return new Builder().withNumberAndIdentification(trailer.getNumber())
            .withCondition(trailer.getCondition())
            .isReefer(trailer.isReefer())
            .withOperator(trailer.getOperator())
            .withType(trailer.getType())
            .withSize(trailer.getSize())
            .isCraneable(trailer.isCraneable())
            .withWeight(trailer.getWeight());
    }


    public Trailer isCraneable(Boolean craneable) {

        this.craneable = craneable;

        return this;
    }


    public String getType() {

        return type;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getSize() {

        return size;
    }


    public Boolean isCraneable() {

        return craneable;
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

        private String identification;
        private String number;
        private String type;
        private Quantity<Length> size;
        private Quantity<Mass> weightBruttoMax;
        private Boolean craneable;
        private Quantity<Mass> weightNettoMax;
        private Quantity<Mass> weightTare;
        private String condition;
        private boolean reefer;
        private String operator;

        private Builder() {
        }

        public Builder withNumberAndIdentification(String number) {

            number = number.replaceAll("[^A-Za-z0-9]", "");

            if (!LoadingUnitNumber.isValidBIC(number)) {
                throw new IllegalArgumentException(String.format(
                        "Invalid number/identification for LoadingUnit: \'%s\' is not a valid BIC/ILU.", number));
            }

            this.number = number;
            this.identification = number;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        Builder withSize(Quantity<Length> size) {

            this.size = size;

            return this;
        }


        public Builder withSize(Double size, LengthUnit unit) {

            if (unit.equals(LengthUnit.METRE)) {
                this.size = Quantities.getQuantity(size, METRE);
            } else if (unit.equals(LengthUnit.FOOT)) {
                this.size = UnitConverter.footToMetre(size);
            }

            return this;
        }


        public Builder isCraneable(Boolean craneable) {

            this.craneable = craneable;

            return this;
        }


        public Builder withWeightBruttoMax(Double weightBruttoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightBruttoMax = Quantities.getQuantity(weightBruttoMax, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightBruttoMax = UnitConverter.tonToKilogram(weightBruttoMax);
            }

            return this;
        }


        public Builder withWeightNettoMax(Double weightNettoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNettoMax = Quantities.getQuantity(weightNettoMax, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightNettoMax = UnitConverter.tonToKilogram(weightNettoMax);
            }

            return this;
        }


        public Builder withWeightTare(Double weightTare, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightTare = Quantities.getQuantity(weightTare, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightTare = UnitConverter.tonToKilogram(weightTare);
            }

            return this;
        }


        Builder withWeight(Weight weight) {

            if (weight != null) {
                this.weightBruttoMax = weight.getBruttoMax();
                this.weightNettoMax = weight.getNettoMax();
                this.weightTare = weight.getTare();
            }

            return this;
        }


        public Builder withCondition(String condition) {

            this.condition = condition;

            return this;
        }


        public Builder isReefer(boolean reefer) {

            this.reefer = reefer;

            return this;
        }


        public Builder withOperator(String operator) {

            this.operator = operator;

            return this;
        }


        /**
         * Builds {@link Trailer} without input validation.
         *
         * @return  new {@link Trailer} with attributes specified in {@link Builder}
         */
        public Trailer build() {

            Trailer trailer = new Trailer();
            trailer.setIdentification(identification);
            trailer.setNumber(number);
            trailer.setCondition(condition);
            trailer.setReefer(reefer);
            trailer.setOperator(operator);
            trailer.type = this.type;
            trailer.size = this.size;
            trailer.craneable = this.craneable;

            if (weightBruttoMax != null || weightNettoMax != null) {
                Weight weight = new Weight();
                weight.setBruttoMax(weightBruttoMax);
                weight.setNettoMax(weightNettoMax);
                weight.setTare(weightTare);
                trailer.setWeight(weight);
            }

            trailer.setCategory(LoadingUnitCategory.TRAILER);

            return trailer;
        }


        /**
         * Validates the input and builds {@link Trailer}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link Trailer}.
         *
         * @return  new {@link Trailer} with attributes specified in {@link Builder}
         */
        public Trailer buildAndValidate() {

            Trailer trailer = this.build();

            MinimumRequirementValidator.validate(trailer);

            return trailer;
        }
    }
}
