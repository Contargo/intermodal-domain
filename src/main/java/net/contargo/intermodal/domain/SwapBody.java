package net.contargo.intermodal.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import tec.units.ri.quantity.Quantities;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import javax.validation.constraints.NotNull;

import static systems.uom.common.USCustomary.FOOT;

import static tec.units.ri.unit.Units.KILOGRAM;


/**
 * {@link LoadingUnit} intended for the transport of goods, optimized with regard to the dimensions of road vehicles
 * and equipped with gripping edges for the transfer between means of transport, usually between road/rail transport.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 * @version  2018-04
 * @name_german  Wechselbrücke
 * @name_english  swap body
 * @abbreviation_english  SB
 * @synonym_german  Wechselbehälter, Wechselaufbau
 * @definition_german  Für den Gütertransport bestimmter Behälter, der im Hinblick auf die Abmessungen von
 *                     Straßenfahrzeugen optimiert wurde und mit Greifkanten für den Umschlag zwischen den
 *                     Verkehrsmitteln, in der Regel der Verkehrsträger Straße-Schiene, ausgestattet ist.
 * @definition_english  Loading unit intended for the transport of goods, optimized with regard to the dimensions of
 *                      road vehicles and equipped with gripping edges for the transfer between means of transport,
 *                      usually between road and rail transport.
 * @minimum_requirement  type, size, stackable, also @see minimum requirements of {@link LoadingUnit}
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class SwapBody extends LoadingUnit implements Wechselbrücke, Wechselaufbau, Wechselbehälter {

    /**
     * e.g. Klasse A, Klasse C (C715, C745, C765, C782), Open Top
     */
    @NotNull(message = "type is part of minimum requirement")
    private String type;

    /**
     * in foot.
     */
    @NotNull(message = "size is part of minimum requirement")
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> size;

    @NotNull(message = "stackable is part of minimum requirement")
    private Boolean stackable;

    public static Builder newBuilder() {

        return new Builder();
    }


    public SwapBody isStackable(Boolean stackable) {

        this.stackable = stackable;

        return this;
    }


    public String getType() {

        return type;
    }


    @JsonSerialize(using = QuantityJsonSerializer.class)
    public Quantity<Length> getSize() {

        return size;
    }


    public Boolean isStackable() {

        return stackable;
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
        private Quantity<Mass> weightBruttoMax;
        private String type;
        private Quantity<Mass> weightNettoMax;
        private Quantity<Mass> weightTare;
        private Quantity<Length> size;
        private String condition;
        private Boolean stackable;
        private Boolean reefer;
        private String operator;

        private Builder() {
        }

        public Builder withIdentification(String identification) {

            this.identification = identification;

            return this;
        }


        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withNumber(String number) {

            this.number = number;

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


        public Builder withSize(Double size, LengthUnit unit) {

            if (unit.equals(LengthUnit.FOOT)) {
                this.size = Quantities.getQuantity(size, FOOT);
            } else if (unit.equals(LengthUnit.METRE)) {
                this.size = UnitConverter.metreToFoot(size);
            }

            return this;
        }


        public Builder withCondition(String condition) {

            this.condition = condition;

            return this;
        }


        public Builder isStackable(Boolean stackable) {

            this.stackable = stackable;

            return this;
        }


        public Builder isReefer(Boolean reefer) {

            this.reefer = reefer;

            return this;
        }


        public Builder withOperator(String operator) {

            this.operator = operator;

            return this;
        }


        public SwapBody build() {

            SwapBody swapBody = new SwapBody();
            swapBody.setIdentification(identification);
            swapBody.setNumber(number);
            swapBody.setCondition(condition);
            swapBody.setReefer(reefer);
            swapBody.setOperator(operator);
            swapBody.stackable = this.stackable;
            swapBody.size = this.size;
            swapBody.type = this.type;

            if (weightBruttoMax != null || weightNettoMax != null) {
                Weight weight = new Weight();
                weight.setBruttoMax(weightBruttoMax);
                weight.setNettoMax(weightNettoMax);
                weight.setTare(weightTare);
                swapBody.setWeight(weight);
            }

            swapBody.setCategory(LoadingUnitCategory.SWAP_BODY);

            return swapBody;
        }


        public SwapBody buildAndValidate() {

            SwapBody swapBody = this.build();

            Validator.validate(swapBody);

            return swapBody;
        }
    }
}

interface Wechselbrücke {
}

interface Wechselbehälter {
}

interface Wechselaufbau {
}
