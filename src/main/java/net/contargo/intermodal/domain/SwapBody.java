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
 * @minimum_requirement  type, size, stackable, @see also minimum requirements of {@link LoadingUnit}
 * @source  DIGIT - Standardisierung des Datenaustauschs für alle Akteure der intermodalen Kette zur Gewährleistung
 *          eines effizienten Informationsflusses und einer zukunftsfähigen digitalen Kommunikation
 */
public class SwapBody extends LoadingUnit {

    /**
     * e.g. Klasse A, Klasse C (C715, C745, C765, C782), Open Top
     */
    @NotNull(message = "type is part of minimum requirement and must not be null")
    private String type;

    /**
     * in foot.
     */
    @NotNull(message = "size is part of minimum requirement and must not be null")
    @JsonDeserialize(using = QuantityJsonDeserializer.class)
    private Quantity<Length> size;

    @NotNull(message = "stackable is part of minimum requirement and must not be null")
    private Boolean stackable;

    private SwapBody() {

        // OK
    }

    /**
     * Creates a new builder for {@link SwapBody}.
     *
     * @return  new builder
     */
    public static Builder newBuilder() {

        return new Builder();
    }


    /**
     * Creates a new builder with the values of another {@link SwapBody}.
     *
     * @param  swapBody  that should be copied.
     *
     * @return  new builder with values of given swapBody.
     */
    public static Builder newBuilder(SwapBody swapBody) {

        return new Builder().withNumberAndIdentification(swapBody.getNumber())
            .withCondition(swapBody.getCondition())
            .isReefer(swapBody.isReefer())
            .withOperator(swapBody.getOperator())
            .isStackable(swapBody.isStackable())
            .withSize(swapBody.getSize())
            .withType(swapBody.getType())
            .withWeight(swapBody.getWeight());
    }


    /**
     * Starts a new step builder pattern for {@link SwapBody}. Other than the normal {@link Builder} the
     * {@link StepBuilder} will enforce the order in which fields are set to make sure the minimum requirements are
     * fulfilled.
     *
     * @return  INumber
     */
    public static INumber newStepBuilder() {

        return new StepBuilder();
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

    public interface IBuild {

        IBuild withCondition(String condition);


        IBuild withCondition(LoadingUnitCondition loadingUnitCondition);


        IBuild withOperator(String operatorName);


        IBuild withWeightBruttoMax(Double weightBruttoMax, MassUnit unit);


        IBuild withWeightNettoMax(Double weightNettoMax, MassUnit unit);


        IBuild withWeightTare(Double weightTare, MassUnit unit);


        /**
         * Builds {@link SwapBody} without input validation.
         *
         * @return  new {@link SwapBody} with attributes specified in {@link StepBuilder}
         */
        SwapBody build();


        /**
         * Validates the input and builds {@link SwapBody}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link SwapBody}.
         *
         * @return  new {@link SwapBody} with attributes specified in {@link SwapBody}
         */
        SwapBody buildAndValidate();
    }

    public interface INumber {

        IReefer withNumberAndIdentification(String number);


        IReefer withNumberAndIdentification(String number, LoadingUnitIdentification loadingUnitIdentification);
    }

    public interface IReefer {

        IType isReefer(Boolean isReefer);
    }

    public interface IStackable {

        IBuild isStackable(Boolean isStackable);
    }

    public interface ISize {

        IStackable withSize(Double size, LengthUnit unit);
    }

    public interface IType {

        ISize withType(String type);
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
        private boolean reefer;
        private String operator;

        private Builder() {
        }

        public Builder withType(String type) {

            this.type = type;

            return this;
        }


        public Builder withNumberAndIdentification(String number,
            LoadingUnitIdentification loadingUnitIdentification) {

            number = checkIdentification(number, loadingUnitIdentification);

            this.number = number;
            this.identification = number;

            return this;
        }


        Builder withNumberAndIdentification(String number) {

            number = number.replaceAll("[^A-Za-z0-9]", "");

            if (!LoadingUnitNumber.isValidBIC(number)) {
                throw new IllegalArgumentException(String.format(
                        "Invalid number/identification for LoadingUnit: \'%s\' is not a valid BIC/ILU.", number));
            }

            this.number = number;
            this.identification = number;

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
                this.weightTare = weight.getTare();
                this.weightBruttoMax = weight.getBruttoMax();
                this.weightNettoMax = weight.getNettoMax();
            }

            return this;
        }


        Builder withSize(Quantity<Length> size) {

            this.size = size;

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


        public Builder withCondition(LoadingUnitCondition loadingUnitCondition) {

            this.condition = loadingUnitCondition.name();

            return this;
        }


        public Builder isStackable(Boolean stackable) {

            this.stackable = stackable;

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
         * Builds {@link SwapBody} without input validation.
         *
         * @return  new {@link SwapBody} with attributes specified in {@link Builder}
         */
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


        /**
         * Validates the input and builds {@link SwapBody}. Throws IllegalStateException if input doesn't fulfill the
         * minimum requirement of {@link SwapBody}.
         *
         * @return  new {@link SwapBody} with attributes specified in {@link Builder}
         */
        public SwapBody buildAndValidate() {

            SwapBody swapBody = this.build();

            MinimumRequirementValidator.validate(swapBody);

            return swapBody;
        }
    }

    public static final class StepBuilder implements INumber, IReefer, IStackable, ISize, IType, IBuild {

        private String identification;
        private String number;
        private Quantity<Mass> weightBruttoMax;
        private Quantity<Mass> weightNettoMax;
        private Quantity<Mass> weightTare;
        private String condition;
        private boolean reefer;
        private String operator;
        @NotNull(message = "stackable is part of minimum requirement and must not be null")
        private Boolean stackable;
        @NotNull(message = "size is part of minimum requirement and must not be null")
        private Quantity<Length> size;
        @NotNull(message = "type is part of minimum requirement and must not be null")
        private String type;

        private StepBuilder() {
        }

        @Override
        public IBuild isStackable(Boolean val) {

            stackable = val;

            return this;
        }


        @Override
        public IStackable withSize(Double size, LengthUnit unit) {

            if (unit.equals(LengthUnit.FOOT)) {
                this.size = Quantities.getQuantity(size, FOOT);
            } else if (unit.equals(LengthUnit.METRE)) {
                this.size = UnitConverter.metreToFoot(size);
            }

            return this;
        }


        @Override
        public ISize withType(String val) {

            type = val;

            return this;
        }


        @Override
        public IBuild withCondition(String condition) {

            this.condition = condition;

            return this;
        }


        @Override
        public IBuild withCondition(LoadingUnitCondition loadingUnitCondition) {

            this.condition = loadingUnitCondition.name();

            return this;
        }


        @Override
        public IBuild withOperator(String operatorName) {

            this.operator = operatorName;

            return this;
        }


        @Override
        public IBuild withWeightBruttoMax(Double weightBruttoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightBruttoMax = Quantities.getQuantity(weightBruttoMax, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightBruttoMax = UnitConverter.tonToKilogram(weightBruttoMax);
            }

            return this;
        }


        @Override
        public IBuild withWeightNettoMax(Double weightNettoMax, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightNettoMax = Quantities.getQuantity(weightNettoMax, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightNettoMax = UnitConverter.tonToKilogram(weightNettoMax);
            }

            return this;
        }


        @Override
        public IBuild withWeightTare(Double weightTare, MassUnit unit) {

            if (unit.equals(MassUnit.KILOGRAM)) {
                this.weightTare = Quantities.getQuantity(weightTare, KILOGRAM);
            } else if (unit.equals(MassUnit.TON)) {
                this.weightTare = UnitConverter.tonToKilogram(weightTare);
            }

            return this;
        }


        @Override
        public SwapBody build() {

            SwapBody swapBody = new SwapBody();

            swapBody.setCategory(LoadingUnitCategory.SWAP_BODY);
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

            return swapBody;
        }


        @Override
        public SwapBody buildAndValidate() {

            SwapBody swapBody = this.build();

            MinimumRequirementValidator.validate(swapBody);

            return swapBody;
        }


        @Override
        public IReefer withNumberAndIdentification(String number) {

            number = number.replaceAll("[^A-Za-z0-9]", "");

            if (!LoadingUnitNumber.isValidBIC(number)) {
                throw new IllegalArgumentException(String.format(
                        "Invalid number/identification for LoadingUnit: \'%s\' is not a valid BIC/ILU.", number));
            }

            this.number = number;
            this.identification = number;

            return this;
        }


        @Override
        public IReefer withNumberAndIdentification(String number,
            LoadingUnitIdentification loadingUnitIdentification) {

            number = checkIdentification(number, loadingUnitIdentification);

            this.number = number;
            this.identification = number;

            return this;
        }


        @Override
        public IType isReefer(Boolean isReefer) {

            this.reefer = isReefer;

            return this;
        }
    }
}
